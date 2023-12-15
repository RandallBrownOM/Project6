//Author: Aeden Deudi

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WorkerThread extends Thread {
    protected Socket clientSocket;
    protected Socket clientSocket2;
    private BufferedReader input;
    private BufferedReader input2;
    private PrintWriter output;
    private PrintWriter output2;

    public WorkerThread(Socket connection, Socket connection2) {
        this.clientSocket = connection;
        this.clientSocket2 = connection2;
        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            input2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
            output2 = new PrintWriter(clientSocket2.getOutputStream(), true);
            output = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String firstPlayer = input.readLine();
            System.out.println(firstPlayer);
            String secondPlayer = input2.readLine();
            System.out.println(secondPlayer);
            String result = determineWinner(firstPlayer, secondPlayer);

            System.out.println(result); // for debugging..

            if (result.equals("rock") || result.equals("paper") || result.equals("scissors")) {
                sendResult(result);
            }

            System.out.println(result); // for debugging..
        } catch (Exception e) {
            System.out.println("Sorry, the server has shut down.");
            System.out.println("Error: " + e);
            return;
        }
    }

    public String determineWinner(String choice1, String choice2) {
        if (choice1.equals(choice2)) {
            return "It's a tie!";
        } else if ((choice1.equals("rock") && choice2.equals("scissors")) ||
                (choice1.equals("scissors") && choice2.equals("paper")) ||
                (choice1.equals("paper") && choice2.equals("rock"))) {
            return "rock";
        } else {
            return "scissors";
        }
    }

    private void sendResult(String result) {
        output.println(result);
        output2.println(result);
    }
}
	
