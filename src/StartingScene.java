import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartingScene extends Application {
    private PrintWriter outgoing;
    private BufferedReader incoming;

    // Constructor
    public StartingScene(PrintWriter outgoing, BufferedReader incoming) {
        this.outgoing = outgoing;
        this.incoming = incoming;

        Button startGameButton = new Button("Start Game");
        startGameButton.setOnAction(e -> startGame());

    }

    @Override
    public void start(Stage primaryStage) {
        // Set up the scene
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(new Label("Welcome to Rock, Paper, Scissors!"));
        vbox.getChildren().add(new Label("Click 'Start Game' to begin."));
        vbox.getChildren().add(new Button("Start Game", e -> startGame()));

        Scene scene = new Scene(vbox, 300, 200);

        // Set up the stage
        primaryStage.setTitle("Rock, Paper, Scissors");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startGame() {
        PrimaryScene.run();
    }

    public static void main(String[] args) {
        launch(args);
    }
}