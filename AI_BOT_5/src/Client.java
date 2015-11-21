import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author shakhawat amin
 */
public class Client {

	public Client() throws IOException {
		//final String host = "localhost";
		final int portNum = 2016;
                final String Host = "192.168.0.105";
                try {
                    //InetAddress ipAddr = InetAddress.getLocalHost();
                //final String Host = ipAddr.getHostAddress();
                    
                
		//System.out.println("Creating socket to local network on port " + portNum);
		//System.out.println("Creating socket to '" + Host + "' on port " + portNum);

//		while (true) 
          //     {
                       
			Socket socket = new Socket(Host, portNum);
                        System.out.println("check from client ");
                        
			//BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			//System.out.println("server says:" + br.readLine());

			//BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			//String userInput = userInputBR.readLine();

			//out.println(userInput);

			//System.out.println("server says:" + br.readLine());

			//if ("exit".equalsIgnoreCase(userInput)) {
			//	socket.close();
			//	//break;
			//}
	//	}
	} catch (UnknownHostException e) {
                    e.printStackTrace();
            }
        }
}