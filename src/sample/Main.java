package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;
import java.util.*;

import static sample.ImmoESI.proprietaires;


public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ImmoESI");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        critere cri1 = new critere();
        cri1.liste_des_biens_filtres.addAll(ImmoESI.liste_des_biens);


        /*Creation liste des proprietaires*/
        Proprietaire prop1 = new Proprietaire("Belguenbour", "+213*********", "walid", "iw_belguenbour@esi.dz", "Dely Brahim");

        /*Creation liste des biens*/
        Date date = new Date();
        Date date1 = new Date("2019/2/2");
        Date date2 = new Date("2018/5/2");
        Date date3 = new Date("2007/9/1");
        Date date4 = new Date("2006/1/11");
        Date date5 = new Date("2005/3/13");
        Date date6 = new Date("2004/2/12");
        Date date7 = new Date("1990/2/2");

        Wilaya alger = Enum.valueOf(Wilaya.class, "alger"); // wilaya 2
        Wilaya setif = Enum.valueOf(Wilaya.class, "setif");//wilaya 1
        Wilaya batna = Enum.valueOf(Wilaya.class, "batna");//wilaya3
        TypeDeTransaction vente = Enum.valueOf(TypeDeTransaction.class, "vente");
        TypeDeTransaction location = Enum.valueOf(TypeDeTransaction.class, "location");
        TypeDeTransaction echange = Enum.valueOf(TypeDeTransaction.class, "echange");
        Bien bien1 = new Appartement("bien1", alger, 120, prop1, vente, 4000000, false, "", date, "", 4, false, 1, false);
        Bien bien2 = new Maison("bien2 ", batna, 200, prop1, vente, 10000000, true, "", date1, "", 0, false, true, true, true, 200);
        Bien bien3 = new Terrain("bien3", setif, 500, prop1, vente, 20000000, false, "", date2, "", 3, "");
        Bien bien4 = new Appartement("bien4", batna, 100, prop1, location, 40000, false, "", date3, "", 3, false, 1, false, false, false);
        Bien bien5 = new Maison("bien5", alger, 160, prop1, location, 150000, true, "", date4, "", 5, false, 2, true, true, true, 100);
        Bien bien6 = new Appartement("bien6", batna, 50, prop1, location, 600000, false, "", date5, "", 3, false, 6, false, false, true);
        Bien bien7 = new Terrain("bien7", setif, 650, prop1, echange, 18000000, false, "", date6, "", 1, "", batna);
        Bien bien8 = new Maison("bien8 ", alger, 200, prop1, echange, 14000000, true, "", date7, "", 2, true, false,false, 100, alger);
        ImmoESI.liste_des_biens.add(bien1);
        ImmoESI.liste_des_biens.add(bien2);
        ImmoESI.liste_des_biens.add(bien3);
        ImmoESI.liste_des_biens.add(bien4);
        ImmoESI.liste_des_biens.add(bien5);
        ImmoESI.liste_des_biens.add(bien6);
        ImmoESI.liste_des_biens.add(bien7);
        ImmoESI.liste_des_biens.add(bien8);









        //  Proprietaire prop11 = new Proprietaire("Belguenbour", "+213*********", "walid", "iw_belguenbour@esi.dz", "Dely Brahim");

    }


    public static void main(String[] args) {
        launch(args);







    }
}
