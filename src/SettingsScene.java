import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SettingsScene {
	
    private String playerName = "Player"; // Default player name

    public void showSettingsStage() {
        Stage settingsStage = new Stage();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(new Label("Settings"));
        vbox.getChildren().add(new Button("Set Player Name", e -> setPlayerName()));
        vbox.getChildren().add(new Button("Score", e -> Score()));

        Scene settingsScene = new Scene(vbox, 300, 200);

        settingsStage.setTitle("Settings");
        settingsStage.setScene(settingsScene);
        settingsStage.show();
    }

    private void setPlayerName() {       
        TextField playerNameField = new TextField(playerName);
        VBox inputVBox = new VBox(new Label("Enter Player Name:"), playerNameField);
        inputVBox.setAlignment(Pos.CENTER);

        Scene inputScene = new Scene(inputVBox, 200, 100);

        Stage inputStage = new Stage();
        inputStage.setScene(inputScene);
        inputStage.setTitle("Player Name Input");
        inputStage.showAndWait();

        playerName = playerNameField.getText();
    }

	@SuppressWarnings("unused")
	private void Score() {
		//shows the score of each rock paper and scissor battle
    	PrimaryScene.count();    	
    	
    }
}
