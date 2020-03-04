package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnvoyerMessage implements Initializable {
 @FXML
    TextField message;

 public static Bien bienconcerne;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void EnvoyerButton(javafx.event.ActionEvent event) throws IOException {
        ImmoESI.envoyerMessage(bienconcerne, message.getText());
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("Interfacepublic.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();

    }
}
