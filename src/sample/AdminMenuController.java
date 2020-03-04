package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    ImmoESI agence = new ImmoESI();
    Administrateur admin2 = new Administrateur("akram", "23062001");
    @FXML
    ListView<String> list = new ListView<>();


    @FXML
    Label Adresse ;
    @FXML
    Label Prix ;
    @FXML
    Label Transaction ;
    @FXML
    Label TypeBien;
    ObservableList listofitems = FXCollections.observableArrayList();
    Bien b ;

    public Bien displayItem ()
    {
        ObservableList listofitems = list.getSelectionModel().getSelectedItems();
        for (Object m:listofitems)
        {
            String s = (String) m;
            boolean bool=true ;
            Iterator<Bien> it = ImmoESI.liste_des_biens.iterator() ;
            while (it.hasNext() &&  bool )
            {
                b = it.next() ;
                if (b.getAdresse().compareTo(s)==0) {

                    bool = false;
                }
            }
        }
        Adresse.setText(b.getAdresse());
        Prix.setText(String.valueOf(b.getPrix()));
        Transaction.setText(b.getTransaction().getClass().getSimpleName());
        TypeBien.setText(b.getClass().getSimpleName());
        System.out.println(b.adresse);
        return b;

    }
    public Bien ItemSelect ()
    {
        ObservableList listofitems = list.getSelectionModel().getSelectedItems();
        for (Object m:listofitems)
        {
            String s = (String) m;
            boolean bool=true ;
            Iterator <Bien> it = ImmoESI.liste_des_biens.iterator() ;
            while (it.hasNext() &&  bool )
            {
                b = it.next() ;
                if (b.getAdresse().compareTo(s)==0) {

                    bool = false;
                }
            }
        }
        return b;

    }
    public void visualiser() {
        for (Bien b : ImmoESI.liste_des_biens
        ) {
            listofitems.add(b.getAdresse());

        }

        list.getItems().addAll(listofitems);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }



    public void GotoAjouterBien(ActionEvent event) throws IOException {
        Parent AjouterBienParent = FXMLLoader.load(getClass().getResource("AjouterBien.fxml"));
        Scene AjouterBienScene = new Scene(AjouterBienParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AjouterBienScene);
        window.show();
    }
    public void SuprrimerButton(ActionEvent event) throws IOException {
        Bien b;
        b = ItemSelect();
        agence.supprimer_bien(admin2,b);
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("PublicMenu.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();

    }
    public void ArchiverButton (ActionEvent event) throws IOException{
        Bien b;
        b = ItemSelect();
        agence.archiver_bien(admin2, b);
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("PublicMenu.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }


    public void GotoAdminMenu(ActionEvent event) throws IOException {
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("PublicMenu.fxml"));
        Scene AdminMenuScene = new Scene(AdminMenuParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();


        window.setScene(AdminMenuScene);
        window.show();
    }
    public void AfficherMessage(ActionEvent event) throws IOException {
        Parent AdminMenuParent = FXMLLoader.load(getClass().getResource("AfficherMessages.fxml"));
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


    public void DetailsButton(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DetailsBien.fxml"));

        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access the controller and call a method
        DetailsBien controller = loader.getController();Bien b;
        b = ItemSelect();
        controller.initData(b);



        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        visualiser();

    }
}
