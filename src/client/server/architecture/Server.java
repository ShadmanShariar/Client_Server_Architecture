package client.server.architecture;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    
	private static ServerSocket server = null;
	private static Socket socket = null;
	private static final int port = 8085;

	public static void main(String[] args) {

		BufferedReader in = null;
		PrintWriter out = null;
		Scanner consolelnput = new Scanner(System.in);

		try {
			System.out.println("Server is starting ...");
			server = new ServerSocket(port);
			System.out.println("Server has started");

		} 
                catch (IOException e) {
			System.out.println("Can not listen to port: " + port);
			System.exit(-1);

		}

		while (true) {

			try {
				socket = server.accept();
				System.out.println("Client has been connected\n");

			} catch (IOException e) {
				System.out.println("Communication Error with Client\n");
				System.exit(-1);

			}
			
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println("CSE438 LAB Server");
				System.out.println("Client Name: " + in.readLine());
				while (socket.isConnected()) {
					String clientInput = in.readLine();
					int value = Integer.parseInt(clientInput);
					System.out.println(value);
					if (value == 1) {
						out.println("Red");
					} else if (value == 2) {
						out.println("Yellow");
					} else {
						out.println("Invalid value");
					}

				}

			} 
                        catch (IOException e) {
				System.out.print("Client Left");
				consolelnput.close();
			}
	}	
   }

}

