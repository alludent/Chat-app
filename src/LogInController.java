// handles the login screen logic

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LogInController {

    @FXML private TextField IPToConnectTo;
    @FXML private TextField username;

    // the label you see when you 
    // enter invalid login info
    @FXML private Label loginChecker;

    // separate private from public!!
    @FXML
    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }   

    private void checkLogin() throws IOException {
        ChatApp scene = new ChatApp();
        if (username.getText().isEmpty() || IPToConnectTo.getText().isEmpty()) {
            loginChecker.setText("Invalid name or IP.");
        } else {
            scene.changeScene("fxml/chat.fxml");
        }
    }
}