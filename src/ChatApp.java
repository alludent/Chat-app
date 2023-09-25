// the Main App code


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class ChatApp extends Application {
    private static Stage currStage;

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage startStage) throws Exception{
        currStage = startStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        Scene scene = new Scene (root, 600, 400);

        startStage.setX(1000);
        startStage.setY(50);
        
        Image icon = new Image ("images/csce315-logo.png");
        startStage.getIcons().add(icon);

        startStage.setScene(scene);
        startStage.setTitle("Chat");
        startStage.show();
    }

    public void changeScene(String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        currStage.getScene().setRoot(root);
    }

    
}
