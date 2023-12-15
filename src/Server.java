import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Server {
	// This is the port that the server will be listening on for incoming connections.
	public static final int LISTENING_PORT = 32007;

	public static void main(String[] args) {

		// The ServerSocket object will listen for incoming connections.
		// The Socket object will be used for communication with the client.

		try (ServerSocket listener = new ServerSocket(LISTENING_PORT)) {
            System.out.println("Listening on port " + LISTENING_PORT);
			while (true) {
				try {
					Socket connection = listener.accept();
					Socket connection2 = listener.accept();
					InetAddress clientAddress = connection.getInetAddress();
					InetAddress clientAddress2 = connection2.getInetAddress();
					System.out.println("New client connected from " + clientAddress);
					System.out.println("New client connected from " + clientAddress2);
					
					// Create a new thread for each client
					WorkerThread thread = new WorkerThread(connection,connection2);
					thread.start();
					//new Thread(new ServerThread(connection)).start();
					System.out.println("A new thread has been started");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sorry, the server has shut down.");
			System.out.println("Error:  " + e);
			return;
		}

	}}