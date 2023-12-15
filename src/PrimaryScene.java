import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrimaryScene extends StartingScene {

    public PrimaryScene(PrintWriter outgoing, BufferedReader incoming) {
        super(outgoing, incoming);
    }
    
    public static void count() {
    	int RockCounter = 0;
    	int PaperCounter = 0;
    	int ScissorCounter = 0;
    	
    	outgoing.println(RockCounter,PaperCounter, ScissorCounter);
    	
    }

    public static void run() {
        // Buttons
        Button rock = new Button("Rock");
        Button paper = new Button("Paper");
        Button scissors = new Button("Scissors");

        rock.setMinWidth(200);
        rock.setAlignment(Pos.LEFT);

        paper.setMinWidth(200);
        paper.setAlignment(Pos.CENTER);

        scissors.setMinWidth(200);
        scissors.setAlignment(Pos.RIGHT);

        rock.setOnAction(e -> {
            try {
                // Send choice to server
                outgoing.println("Rock");

                // Wait for server
                String request = incoming.readLine();

                if (request.contains("Paper")) {
                    // Send victor to server
                    outgoing.println("Paper wins!");
                    System.out.println("Paper wins!");
                } else if (request.contains("Scissors")) {
                    // Send victor to server
                    outgoing.println("Rock wins!");
                    System.out.println("Rock wins!");
                    int RockCounter = 0;
                    
                } else {
                    // Send victor to server
                    outgoing.println("It's a tie!");
                    System.out.println("It's a tie!");
                    PrimaryScene.run();
                }
            } catch (IOException ex) {
                // Display error if cannot connect to server
                ex.printStackTrace(); // Handle the exception appropriately
            }
        });

        // Paper Button action
        paper.setOnAction(e -> {
            try {
                // Send choice to server
                outgoing.println("Paper");

                // Wait for server
                String request = incoming.readLine();

                if (request.contains("Rock")) {
                    // Send victor to server
                    outgoing.println("Paper wins!");
                    System.out.println("Paper wins!");
         
                    int PaperCounter = 0;
                    
                } else if (request.contains("Scissors")) {
                    // Send victor to server
                    outgoing.println("Scissors wins!");
                    System.out.println("Scissors wins!");
                } else {
                    // Send victor to server
                    outgoing.println("It's a tie!");
                    System.out.println("It's a tie!");
                    PrimaryScene.run();
                }

            } catch (IOException ex) {
                // Display error if cannot connect to server
                ex.printStackTrace(); // Handle the exception appropriately
            }
        });

        scissors.setOnAction(e -> {
            try {
                // Send choice to server
                outgoing.println("Scissors");

                // Wait for server
                String request = incoming.readLine();

                if (request.contains("Rock")) {
                    // Send victor to server
                    outgoing.println("Rock wins!");
                    System.out.println("Rock wins!");
                    
                } else if (request.contains("Paper")) {
                    // Send victor to server
                    outgoing.println("Scissors wins!");
                    System.out.println("Scissors wins!");
                    ScissorCounter++;
                    
                } else {
                    // Send victor to server
                    outgoing.println("It's a tie!");
                    System.out.println("It's a tie!");
                    PrimaryScene.run();
                }

            } catch (IOException ex) {
                // Display error if cannot connect to server
                ex.printStackTrace(); // Handle the exception appropriately
            }
        });
        
        
    }
    
   
}