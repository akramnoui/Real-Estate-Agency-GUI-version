package sample;

import java.util.Date;

public abstract class Habitable extends Bien {
    public Habitable(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, Wilaya wilaya_echange) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos,wilaya_echange);
    }

    public Habitable() {
        super();
    }

    public int getNbr_pieces() {
        return nbr_pieces;
    }

    private int nbr_pieces;

    private Boolean meuble;

    public Habitable(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble ) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos);
        this.nbr_pieces = nbr_pieces;
        this.meuble = meuble;
    }

 /*   public Habitable(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble , Wilaya wilaya_echange) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos  , wilaya_echange);
        this.nbr_pieces = nbr_pieces;
        this.meuble = meuble;
    }*/
    public Habitable(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos);
    }
    public Habitable(String adresse, Wilaya wilaya) {
        super(adresse,wilaya);
    }

    public Habitable(String adresse) {
        super(adresse);
    }

    public Habitable(String adresse, Wilaya wilaya, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, boolean meuble) {
        super(adresse,wilaya,proprietaire,transaction,prix,negociable,descriptif,date,photos);
        this.nbr_pieces=nbr_pieces;
        this.meuble=meuble;
    }

    public void afficherDetail(){
        super.afficherDetail();
        System.out.println("Nombre de pieces "+nbr_pieces);
        if(meuble)
            System.out.println("Ce bien est meublé");
        else System.out.println("Ce bien est non-meublé");
    }
}