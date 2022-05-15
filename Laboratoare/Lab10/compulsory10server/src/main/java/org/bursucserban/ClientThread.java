package org.bursucserban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread
{
    private Socket socket = null;
    private boolean stop = false;

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
            while (true)
            {
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                String response = "";

                if(request==null)
                    request = "";

                if (request.equals("stop"))
                {
                    response = "Server stopped";
                    out.println(response);
                    out.flush();
                    System.exit(-1);
                }
                else response = "Server received the request \"" + request + "\"";
                out.println(response);
                out.flush();
            }
        }
        catch (IOException e)
        {
            System.err.println("Communication error... " + e);
        }
        finally
        {
            try
            {
                socket.close(); // or use try-with-resources
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }

    }
}