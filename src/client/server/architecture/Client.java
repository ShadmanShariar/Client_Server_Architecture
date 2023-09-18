package client.server.architecture;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static Socket socket = null;

	public static void main(String[] args) {

		try {

socket = new Socket("localhost", 8085);
System.out.println("Connected to Server\n" + "Socket." + socket.getInetAddress()+ ":" + socket.getPort() + "\n");
		
                } catch (IOException e) {
		
                    System.out.print("Connection to network can not be Established");

	       }
                
		BufferedReader in = null;
		PrintWriter out = null;
		Scanner consoleInput = new Scanner(System.in);

		try {
                    
		    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    out = new PrintWriter(socket.getOutputStream(), true);
                    
		    System.out.println("Server: " + in.readLine());

		    System.out.print("Enter Your Name : ");

		    out.println(consoleInput.nextLine());

		    while (true) {

		        System.out.print("Client: ");
		        String clientInput = consoleInput.nextLine();
		        out.println(clientInput);

		        System.out.print("Server: ");
		        String serverInput = in.readLine();
		        System.out.println(serverInput);

		  
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

}