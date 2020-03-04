package sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class critere {
    public static List<Bien> liste_des_biens_filtres = new ArrayList<>(); //liste des biens de l'agence


    public static void recherche_critere(Wilaya wilaya) {
        Bien bien = null;
        int cpt = 0;
        Iterator<Bien> it = ImmoESI.liste_des_biens.iterator();
        while (it.hasNext()) {
            bien = it.next();
            if (!bien.getWilaya().equals(wilaya)) {
                liste_des_biens_filtres.remove(bien);
            }
        }
      /* for (Bien ele : liste_des_biens_filtres) {
            System.out.println("NUMERO DU BIEN : " + cpt);
            ele.afficher();
            System.out.println("---------------------------------------");
            cpt++;
        }*/

    }

    public static void recherche_critere(TypeDeTransaction trans) {
        Bien bien = null;
        int cpt = 0;
        for(Bien ele: ImmoESI.liste_des_biens){
            if (! ele.getTransaction().equals(trans)) {
                liste_des_biens_filtres.remove(ele);
            }
        }


    }
    public  static void recherche_critere(Bien bien) {
        int cpt = 0;
        for(Bien ele: ImmoESI.liste_des_biens){
            if (! ele.getClass().equals( bien.getClass())) {
                liste_des_biens_filtres.remove(ele);
            }
        }

    }
    public static void recherche_critere(criterePrix o) {
        Bien bien = null;
        int cpt = 0;
        for (Bien ele : ImmoESI.liste_des_biens) {
            if ((ele.getPrix() < o.getPrixMinimal()) && (o.getPrixMinimal() != 0)) {
                liste_des_biens_filtres.remove(ele);
            }
            if ((ele.getPrix() > o.getPrixMaximal()) && (o.getPrixMaximal() != 0)) {
                liste_des_biens_filtres.remove(ele);
            }
        }
    }
        public static void recherche_critere(critereSuperficie o) {
            Bien bien = null;
            int cpt = 0;
            for (Bien ele : ImmoESI.liste_des_biens) {
                if ((o.getSupMinimal() > ele.getSurface()) && (o.getSupMinimal() != 0)) {
                    liste_des_biens_filtres.remove(ele);
                }
                if ((ele.getPrix() > o.getSupMaximal()) && (o.getSupMaximal() != 0)) {
                    liste_des_biens_filtres.remove(ele);
                }
            }
        }
          /*  public void recherche_critere(int nb_pieces) {
                Habitable bien = null;
                int cpt = 0;
                for(Habitable ele: ImmoESI.liste_des_biens){
                    if ( ele.getNbr_pieces() < nb_pieces) {
                        liste_des_biens_filtres.remove(ele);
                    }
                }

            }*/

    public static void afficher_resultat() {
        int cpt = 1;

        for (Bien ele : liste_des_biens_filtres) {
            System.out.println("NUMERO DU BIEN : " + cpt);
            ele.afficher();
            System.out.println("---------------------------------------");
            cpt++;
        }
    }
}