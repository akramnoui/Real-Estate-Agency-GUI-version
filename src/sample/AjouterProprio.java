package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class AjouterProprio {
    @FXML
    TextField Nom;
    @FXML
    TextField Prenom;
    @FXML
    TextField Telephone;
    @FXML
    TextField Adresse;


    public void AjouterProprioevent(ActionEvent event) throws IOException {

        Proprietaire prop = new Proprietaire(Nom.getText(),Telephone.getText(),Prenom.getText(),"jfk@gmail.com",Adresse.getText());
        ImmoESI.proprietaires.add(prop);
        Parent AjouterBienParent = FXMLLoader.load(getClass().getResource("AjouterBien.fxml"));
        Scene AjouterBienScene = new Scene(AjouterBienParent);
        ImmoESI.propriospec= prop;

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AjouterBienScene);
        window.show();
    }


    public void AjouterProprioevent(javafx.event.ActionEvent event) throws IOException {
        Proprietaire prop = new Proprietaire(Nom.getText(),Telephone.getText(),Prenom.getText(),"jfk@gmail.com",Adresse.getText());
        ImmoESI.proprietaires.add(prop);
        Parent AjouterBienParent = FXMLLoader.load(getClass().getResource("AjouterBien.fxml"));
        Scene AjouterBienScene = new Scene(AjouterBienParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AjouterBienScene);
        window.show();
    }
}
