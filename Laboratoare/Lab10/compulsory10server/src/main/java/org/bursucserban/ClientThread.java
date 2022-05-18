package org.bursucserban;

import org.bursucserban.DAO.FriendsDAO;
import org.bursucserban.DAO.UsersDAO;
import org.bursucserban.Entities.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

class ClientThread extends Thread
{
    private Socket socket = null;
    private boolean stop = false;
    private boolean logged = false;
    private User loggedUser;


    public ClientThread(Socket socket)
    {
        this.socket = socket;
    }

    public void run()
    {

        try
        {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Database.createConnection();
            UsersDAO usersdao = new UsersDAO();
            FriendsDAO friendsdao = new FriendsDAO();
            while (true)
            {
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                String response = "";

                if(request==null)
                    request = "";

                response = "Command executed successfully";

                String[] command = request.split(" ");

                if(command[0].equals("register") && command[1]!=null && !logged)
                {
                    usersdao.create(command[1]);
                }
                else if(command[0].equals("login") && command[1]!=null && !logged)
                {
                    List<User> result = usersdao.findByName(command[1]);
                    if(result.size()!=0)
                    {
                        logged=true;
                        loggedUser = result.get(0);
                        Server.addLoggedUser(loggedUser);
                    }
                    else
                        response = "Command executed successfully but user doesn't exist";
                }
                else if(logged && command[0].equals("friends") && command[1]!=null)
                {
                    System.out.println(loggedUser.getId());
                    for(int i=1;i<command.length;i++)
                    {
                        friendsdao.create(loggedUser.getId(), usersdao.findByName(command[i]).get(0).getId());
                    }
                }
                else if(logged && command[0].equals("send") && command[1]!=null)
                {
                    String message = "";
                    for(int i=1;i<command.length;i++)
                    {
                        message = message + command[i] + " ";
                    }

                    for(User user : Server.getLoggedUsers())
                    {
                        if(user.getId()!= loggedUser.getId())
                        {
                            if (friendsdao.findById(loggedUser.getId()).get(0).getId() == user.getId())
                            {
                                Server.getInbox().put(user, message);
                            }
                        }

                    }
                }
                else if(command[0].equals("read") && logged)
                {
                    for(User user : Server.getInbox().keySet())
                    {
                        if(user.getId()== loggedUser.getId())
                        {
                            response = Server.getInbox().get(user);
                        }
                    }
                }
                else if(command[0].equals("stop"))
                {
                    Server.setStop(true);
                    response = "Server shutting down";
                }
                else if(command[0].equals("exit"))
                {
                    out.println("quit");
                    out.flush();
                    break;
                }
                else
                    response = "Something failed somewhere";

                out.println(response);
                out.flush();
            }
        }
        catch (IOException | SQLException e)
        {
            System.err.println("Communication error... " + e);
        }
        finally
        {
            try
            {
                if(logged)
                    Server.removeUser(loggedUser);
                Server.getThreadPool().remove(this);
                socket.close(); // or use try-with-resources
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }

    }
}