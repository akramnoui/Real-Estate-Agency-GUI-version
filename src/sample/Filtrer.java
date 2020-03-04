package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Filtrer implements Initializable {
    @FXML
    ChoiceBox<String> typetransac;
    @FXML
    ChoiceBox  wilayaChoice ;
    @FXML
    TextField prixmin ;
    @FXML
    TextField prixmax ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typetransac.getItems().addAll("Vente" ,"Location" ,"Echange");
        wilayaChoice.getItems().addAll("setif" ,"batna","alger");
    }

    public void FIltrerButton(javafx.event.ActionEvent event) throws IOException {

       Wilaya wilaya =Enum.valueOf(Wilaya.class, wilayaChoice.getValue().toString().toLowerCase());
        TypeDeTransaction transaction = Enum.valueOf(TypeDeTransaction.class,typetransac.getValue().toString().toLowerCase());
        Wilaya alger = Enum.valueOf(Wilaya.class, "alger"); // wilaya 2
        Wilaya setif = Enum.valueOf(Wilaya.class, "setif");//wilaya 1
        Wilaya batna = Enum.valueOf(Wilaya.class, "batna");//wilaya3
        TypeDeTransaction vente = Enum.valueOf(TypeDeTransaction.class, "vente");
        TypeDeTransaction location = Enum.valueOf(TypeDeTransaction.class, "location");
        TypeDeTransaction echange = Enum.valueOf(TypeDeTransaction.class, "echange");
        Iterator<Bien> it = ImmoESI.liste_des_biens.iterator();
        Bien b;
        while (it.hasNext()) {
            b = it.next();
            System.out.println(b.getTransaction().toString());
            System.out.println(b.getWilaya().toString());

            if (!b.getWilaya().toString().equals(wilaya.toString()) || !b.getTransaction().toString().equals(transaction.toString())
                   /*  (b.getPrix() < Integer.parseInt(prixmin.getText())) ||  (b.getPrix()  > Integer.parseInt(prixmax.getText()))*/ ) {
                   it.remove();
            }
        }
       // criterePrix cp = new criterePrix(Integer.parseInt(prixmin.getText()), Integer.parseInt(primax.getText()));
       // critere.recherche_critere(cp);
        //ImmoESI.liste_des_biens.clear();
        critere.liste_des_biens_filtres.addAll(ImmoESI.liste_des_biens);
        critere.afficher_resultat();
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("InterfacePublic.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }
}
