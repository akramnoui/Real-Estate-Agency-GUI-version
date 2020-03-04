package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailsBien implements Initializable {
    @FXML
    private Label adress;
    @FXML
    private Label wilaya1;
    @FXML
    private Label proprio1;
    @FXML
    private Label transaction1;
    @FXML
    private Label prix1;
    @FXML
    private Label negociable1;
    @FXML
    private Label description1;
    @FXML
    private Label dateajout1;

    @FXML
     private Label  TypeBien1;


    private Bien SelectedBien;

        public void initData(Bien bien){
        SelectedBien = bien;
            TypeBien1.setText(SelectedBien.getClass().getSimpleName());
            adress.setText(SelectedBien.getAdresse());
            wilaya1.setText(String.valueOf(SelectedBien.getWilaya()));
           // proprio.setText(SelectedBien.getProprietaire().getNom()+" "+SelectedBien.getProprietaire().getPrenom());
            transaction1.setText(String.valueOf(SelectedBien.getTransaction().toString()));
            prix1.setText(String.valueOf(SelectedBien.getPrix()));
            negociable1.setText(String.valueOf(SelectedBien.isNegociable()));
            description1.setText(SelectedBien.getDescriptif());
          //  superficie1.setText(String.valueOf(SelectedBien.getSurface()));



        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void retour(javafx.event.ActionEvent event) throws IOException {

        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("Interfacepublic.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }
}
