//import com.sun.corba.se.spi.activation.Server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server{
    
    private static ServerSocket server = null;
    private static Socket  clientSocket[]  = null; 
    private static int  MAX_CLIENT = 2;
    //private static ClientThread clientThread [] = new ClientThread[MAX_CLIENT];
    public static boolean cont = true;
        public Server ()  throws IOException{
        
        int portNum = 2016;
        server = new ServerSocket(portNum); // server er port creation
        System.out.println("server started ,waiting for clients");
        //new Client();                                            
        new Thread(new Runnable() {

                                                //@Override
                                                public void run() {
                                                    try {
                                                        System.out.println("server started ,waiting for clients");
                                                        new Client();
                                                    } catch (IOException ex) {
                                                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                }
                                            }).start();
        clientSocket = new Socket[2];
        clientSocket[0] = server.accept();
        //Main.c1 = true;
        // create an object of Client class
         System.out.println("accepted from server1");    
        clientSocket[1] = server.accept();
        //Main.c2 = true;
        System.out.println("accepted from server2");
     /*   for (int j = 0;j < 2;j++)
        {
            if (clientThread[j] == null)
                //herw j for detecting 1st player
                clientThread[j] = new ClientThread(clientSocket[j], clientThread,j);
                clientThread[j].start();
        }
        */
                server.close();

    }
    
}
