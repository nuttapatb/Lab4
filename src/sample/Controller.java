package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    Label textLabel;
    @FXML
    Button clickBTN;
    @FXML
    TextField inputText;
    @FXML
    TextArea textArea;

    @FXML public void initialize() {

    }

    @FXML public void handlerClick(ActionEvent event) {
        textLabel.setText(inputText.getText());
        clickBTN.setVisible(false);
        inputText.setText("");
    }

}
