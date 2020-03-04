package sample;

import java.util.Date;

public class Maison extends Habitable implements Transaction {
    private int nbr_etages;
    private boolean garage;
    private boolean jardin;
    private boolean piscine;
    private float surface_habitable;
    public Maison(){
        super();
    }

    public Maison(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble, int nbr_etages, boolean garage, boolean jardin, boolean piscine, float surface_habitable) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_pieces, meuble);
        this.nbr_etages = nbr_etages;
        this.garage = garage;
        this.jardin = jardin;
        this.piscine = piscine;
        this.surface_habitable = surface_habitable;
    }
    public Maison(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble, boolean garage, boolean jardin, boolean piscine, float surface_habitable) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_pieces, meuble);
        this.garage = garage;
        this.jardin = jardin;
        this.piscine = piscine;
        this.surface_habitable = surface_habitable;
    }



    public Maison(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_etages, boolean garage, boolean jardin, boolean piscine, float surface_habitable, Wilaya wilaya_echange) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos , wilaya_echange);
        this.nbr_etages = nbr_etages;
        this.garage = garage;
        this.jardin = jardin;
        this.piscine = piscine;
        this.surface_habitable = surface_habitable;

    }


    public void afficher(){
        super.afficher();
        System.out.println("Surface habitable (en m²)" +surface_habitable);
    }

    @Override
    public void afficherDetail() {
        super.afficherDetail();
        System.out.println("Nombre d'etages "+nbr_etages);
        if(jardin) System.out.print("Avec jardin-");
        if(piscine) System.out.println("Avec piscine-");
        if(garage) System.out.println("Avec garage-\n\n ");
    }

    public float calculerprix(){
        float prix1 = 1 ;
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
            if ((jardin)||(piscine)||(garage)){prix1 = (float) (prix1 + ( prixBien * 0.005));}

        }
        if (getTransaction() == TypeDeTransaction.location) {
            float superficie = getSurface();

            if (superficie < 60) {
                if (prixMetre < 50000) {
                    prix1 = (float) (prixBien + 0.01 * prixBien);
                } else {
                    prix1 = (float) (prixBien + 0.015 * prixBien);
                }
            } else if ((60 <= superficie) && (superficie <= 150)) {
                if (prixMetre <= 50000) {
                    prix1 = (float) (prixBien + 0.02 * prixBien);
                } else {
                    prix1 = (float) (prixBien + 0.025 * prixBien);
                }
            } else if (superficie > 150) {
                if (prixMetre < 50000) {
                    prix1 = (float) (prixBien + 0.03 * prixBien);
                } else {
                    prix1 = (float) (prixBien + 0.035 * prixBien);
                }

            }
            if (piscine) {
                prix1 = prix1 + 50000;
            }
        }

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
                if ((jardin)||(piscine)||(garage)){prix1 = (float) (prix1 + ( prixBien * 0.005));}


                if (!getWilaya().equals(getWilaya_echange())) {
                    prix1 = (float) (prix1 +prixBien*0.0025);
                }

            }

        return prix1 ;
    }

}