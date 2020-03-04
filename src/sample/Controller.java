package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML  private TextField adress;
    @FXML private TextField Surface ;
    @FXML  private TextField prix ;
    @FXML
    private AnchorPane content;


    public void ChangeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent LoginScreenParent = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene LoginScreenScene = new Scene(LoginScreenParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(LoginScreenScene);
        window.show();
    }

    public void GotoAjouterBien(ActionEvent event) throws IOException {
        Parent AjouterBienParent = FXMLLoader.load(getClass().getResource("AjouterBien.fxml"));
        Scene AjouterBienScene = new Scene(AjouterBienParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AjouterBienScene);
        window.show();
    }


    public void GotoAdminMenu(ActionEvent event) throws IOException {
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("PublicMenu.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }
    public void GotoPublic(ActionEvent event) throws IOException {
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("InterfacePublic.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }
    public void GotoPrimary(ActionEvent event) throws IOException {
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }



            @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
