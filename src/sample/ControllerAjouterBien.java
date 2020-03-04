package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.omg.CORBA.IMP_LIMIT;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;





public class ControllerAjouterBien implements Initializable {
    @FXML
    private ChoiceBox<String> WilayachoiceBox;
    @FXML
    private ChoiceBox  TransactionChoiceBox;
    @FXML   ChoiceBox  ProprioChoiceBox;
    @FXML
    private TextField adresse;
    @FXML
    private TextField surface;
    @FXML
    private TextField prix;
    @FXML private CheckBox CheckBoxjardin;
    @FXML private CheckBox CheckBoxpiscine;
    @FXML private CheckBox CheckBoxgarage;
    @FXML private CheckBox CheckBoxnegociable;
    @FXML private CheckBox CheckBoxmeuble;
    @FXML private TextArea Textfielddescriptif;
    @FXML private TextField Textfieldnbr_pieces;
    @FXML private TextField Textfieldnbr_etages;


    

    public void AjouterBienButton(ActionEvent actionEvent) throws IOException {
        

        Wilaya wilaya =Enum.valueOf(Wilaya.class, WilayachoiceBox.getValue().toString().toLowerCase());
        TypeDeTransaction transaction = Enum.valueOf(TypeDeTransaction.class,TransactionChoiceBox.getValue().toString().toLowerCase());
        Date  date = new Date();
        Proprietaire prop = null;
            
            String s = ProprioChoiceBox.getValue().toString();
            boolean bool=true ;
            Iterator<Proprietaire> it = ImmoESI.proprietaires.iterator() ;
            while (it.hasNext() &&  bool )
            {
                prop  = it.next() ;
                if (prop.getNom().compareTo(s)==0) {

                    bool = false;
                }
            }
        

        Bien nouveau = new Maison(adresse.getText(),wilaya,Integer.parseInt(surface.getText()),prop,transaction,Integer.parseInt(prix.getText()),CheckBoxnegociable.isSelected(),Textfielddescriptif.getText(),
                date,"photo",Integer.parseInt(Textfieldnbr_pieces.getText()),CheckBoxmeuble.isSelected(),Integer.parseInt(Textfieldnbr_etages.getText()),CheckBoxgarage.isSelected(),
                CheckBoxjardin.isSelected(), CheckBoxpiscine.isSelected(),120);
              ImmoESI.liste_des_biens.add(nouveau);
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("PublicMenu.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(AdminMenuScene);
        window.show();
       // ImmoESI.afficher_liste_des_bien();
    }
    public void GotoAdminMenu(ActionEvent event) throws IOException {
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("PublicMenu.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }
    public void GotoAjouterProprio(ActionEvent event) throws IOException {

        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("AjouterProprio.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Proprietaire p1;
        Proprietaire prop2 = new Proprietaire("Noui", "+213*********", "moussa", "im_noui@esi.dz", "Bouraoui");
        Proprietaire prop3 = new Proprietaire("Hafri", "+213*********", "seif", "is_hafri@esi.dz", "Beni-Ourthilane");
        Proprietaire prop4 = new Proprietaire("NINI", "+213*********", "Dhia", "id_nini@esi.dz", "Lebanon");


        ImmoESI.proprietaires.add(prop2);
        ImmoESI.proprietaires.add(prop3);
        ImmoESI.proprietaires.add(prop4);
        WilayachoiceBox.getItems().addAll("Setif" , "batna" , "alger");
        TransactionChoiceBox.getItems().addAll("vente" , "Location" , "Echange");
       // Iterator<Proprietaire> it = ImmoESI.proprietaires.iterator() ;
        ProprioChoiceBox.getItems().addAll("belgenbour" , "noui" ,"hafri");





    }
}
