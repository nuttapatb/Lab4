package HangmanUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HangmanFX.fxml"));
        primaryStage.setTitle("Hangman");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 463, 308));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
