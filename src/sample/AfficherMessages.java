package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherMessages implements Initializable {
    Administrateur admin = new Administrateur("walid", "24102000");
    @FXML
    ListView<String> list = new ListView<>();
    ObservableList listofitems = FXCollections.observableArrayList();
    public void visualiser() {
        for (Messages messages : ImmoESI.liste_messages
        ) {
            listofitems.add(messages.getMessage() +"     ----- Bien concerné :  "  + messages.getBienconcerne().adresse);

        }

        list.getItems().addAll(listofitems);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
            visualiser();

    }

    public void Retour(javafx.event.ActionEvent event) throws IOException {
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("PublicMenu.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }
}
