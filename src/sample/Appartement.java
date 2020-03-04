package sample;

import java.util.Date;

public class Appartement extends Habitable implements Transaction{
    public int getEtage() {
        return etage;
    }

    private int etage;
    private boolean duplex;
    private boolean simplexe;
    private boolean studio;
    private boolean ascenseur;

        public Appartement(){
            super();
        }
    public Appartement(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble, int etage, boolean duplex) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_pieces, meuble);
        this.etage = etage;
        this.duplex = duplex;
    }
    public Appartement(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble, int etage, boolean duplex,boolean ascenseur,boolean studio) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_pieces, meuble);
        this.etage = etage;
        this.duplex = duplex;
        this.ascenseur=ascenseur;
        this.studio=studio;
    }

    public Appartement(String adresse, Wilaya wilaya, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, boolean meuble, int etage, boolean duplex) {
        super(adresse,wilaya,proprietaire,transaction,prix,negociable,descriptif,date,photos,nbr_pieces,meuble);
        this.etage=etage;
        this.duplex=duplex;
    }

    @Override
    public void afficherDetail() {
        super.afficherDetail();
        System.out.println("Etage "+etage);
        if(duplex) System.out.println("Ce bien est un duplexe");
        if(simplexe) System.out.println("Ce bien est un simplexe");
        if (studio) System.out.println("Ce bien est in studio");
        if(ascenseur) System.out.println("Ascenseur disponible");
    }

    @Override
    public float calculerprix(){
        float prix1 = 0 ;
        float prixMetre = getWilaya().getPrixMetreCarre();
        float prixBien = getPrix();
        if (getTransaction() == TypeDeTransaction.vente)
        {
            if (prixBien<5000000) {
                if (prixMetre<50000) {
                    prix1 = (float) (prixBien + 0.03*prixBien);
                }
                else {
                    prix1 = (float) (prixBien + 0.035*prixBien);
                }
            }
            else if ((5000000<= prixBien)&&( prixBien<= 15000000)) {
                if (prixMetre<=50000) {
                    prix1 = (float) (prixBien + 0.02*prixBien);
                }
                else {
                    prix1 = (float) (prixBien + 0.025*prixBien);
                }
            }
            else if (prixBien>15000000) {
                if (prixMetre<70000) {
                    prix1 = (float) (prixBien + 0.01*prixBien);
                }
                else {
                    prix1 = (float) (prixBien + 0.02*prixBien);
                }
            }
            if (this.getEtage() <= 2 ){prix1 = (float) (prix1 + 50000);}

        }
        if (getTransaction() == TypeDeTransaction.location)
        {
            float superficie = getSurface();
            if (superficie<60) {
                if (prixMetre<50000) {
                    prix1 = (float) (prixBien + 0.01*prixBien);
                }
                else {
                    prix1 = (float) (prixBien + 0.015*prixBien);
                }
            }
            else if ((60<= superficie)&&( superficie<= 150)) {
                if (prixMetre<=50000) {
                    prix1= (float) (prixBien + 0.02*prixBien);
                }
                else {
                    prix1 = (float) (prixBien + 0.025*prixBien);
                }
            }
            else if (superficie>150) {
                if (prixMetre < 50000) {
                    prix1 = (float) (prixBien + 0.03 * prixBien);
                } else {
                    prix1 = (float) (prixBien + 0.035 * prixBien);
                }
            }
                if (this.getEtage() <= 2 ){prix1 = (float) (prix1 + 5000);  }
                if ((!ascenseur) && (etage >= 6)) {prix1 = (float) (prix1 - (500) * ( getSurface() ) ); }

            if (getTransaction() == TypeDeTransaction.echange)
            {

                if (prixBien<5000000) {
                    if (prixMetre<50000) {
                        prix1 = (float) (prixBien + 0.03*prixBien);
                    }
                    else {
                        prix1 = (float) (prixBien + 0.035*prixBien);
                    }
                }
                else if ((5000000<= prixBien)&&( prixBien<= 15000000)) {
                    if (prixMetre<=50000) {
                        prix1 = (float) (prixBien + 0.02*prixBien);
                    }
                    else {
                        prix1 = (float) (prixBien + 0.025*prixBien);
                    }
                }
                else if (prixBien>15000000) {
                    if (prixMetre<70000) {
                        prix1 = (float) (prixBien + 0.01*prixBien);
                    }
                    else {
                        prix1 = (float) (prixBien + 0.02*prixBien);
                    }
                }


                if (!getWilaya().equals(getWilaya_echange())) {
                    prix1 = (float) (prix1 +prix1*0.0025);
                }

            }


        }
        return prix1 ;
    }

}