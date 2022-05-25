package org.bursucserban;

import org.bursucserban.Entities.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    private static CopyOnWriteArrayList<User> loggedUsers = new CopyOnWriteArrayList<>();
    private static ConcurrentHashMap<User,String> inbox = new ConcurrentHashMap<>();

    private static boolean stop = false;

    public synchronized static void setStop(boolean value)
    {
        stop=value;
    }

    public synchronized static void addLoggedUser(User user)
    {
        loggedUsers.add(user);
        inbox.put(user,"");
    }

    public synchronized static ConcurrentHashMap<User,String> getInbox()
    {
        return inbox;
    }

    public synchronized static void removeUser(User user)
    {
        loggedUsers.remove(user);
        inbox.remove(user);
    }
    public synchronized static List<User> getLoggedUsers()
    {
        return loggedUsers;
    }

    private static CopyOnWriteArrayList<ClientThread> threadPool = new CopyOnWriteArrayList<>();

    public synchronized static CopyOnWriteArrayList<ClientThread> getThreadPool()
    {
        return threadPool;
    }


    public Server() throws IOException
    {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            boolean close = false;
            while (!close) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(120000000);
                if(!stop)
                {
                    ClientThread ct = new ClientThread(socket);
                    threadPool.add(ct);
                    ct.start();
                }
                else
                {
                    System.out.println("Waiting for clients to finish ...");
                    while(!close)
                    {
                        if (Server.getThreadPool().size() == 0)
                        {
                            System.out.println("Peace out");
                            close=true;
                            break;
                        }
                    }
                }
                // Execute the client's request in a new thread
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main ( String [] args ) throws IOException
    {
        Server server = new Server ();
    }

}