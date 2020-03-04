package sample;

import java.util.Date;

public class Terrain extends NonHabitable  implements Transaction {

    public Terrain(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_facades, String etat_juridique , Wilaya wilaya_echange) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_facades, etat_juridique,wilaya_echange);
    }
    public Terrain(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_facades, String etat_juridique ) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_facades, etat_juridique);
    }
    public Terrain(){
        super();
    }

    public Terrain(String adresse, Wilaya wilaya) {
        super(adresse, wilaya);
    }

    @Override
    public float calculerprix() {
        float prix1 = 0;
        float prixMetre = getWilaya().getPrixMetreCarre();
        float prixBien = getPrix();
        if (getTransaction() == TypeDeTransaction.vente) {
            if (prixBien < 5000000) {
                if (prixMetre < 50000) {
                    prix1 = (float) (prixBien + 0.03 * prixBien);
                } else {
                    prix1 = (float) (prixBien + 0.035 * prixBien);
                }
            } else if ((5000000 <= prixBien) && (prixBien <= 15000000)) {
                if (prixMetre <= 50000) {
                    prix1 = (float) (prixBien + 0.02 * prixBien);
                } else {
                    prix1 = (float) (prixBien + 0.025 * prixBien);
                }
            } else if (prixBien > 15000000) {
                if (prixMetre < 70000) {
                    prix1 = (float) (prixBien + 0.01 * prixBien);
                } else {
                    prix1 = (float) (prixBien + 0.02 * prixBien);
                }
            }
            if (this.getNbr_facades() > 1) prix1 = (float) (prix1 + (0.005) * (prixBien) * (getNbr_facades() - 1));

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
        }
            if (getTransaction() == TypeDeTransaction.echange) {

                if (prixBien < 5000000) {
                    if (prixMetre < 50000) {
                        prix1 = (float) (prixBien + 0.03 * prixBien);
                    } else {
                        prix1 = (float) (prixBien + 0.035 * prixBien);
                    }
                } else if ((5000000 <= prixBien) && (prixBien <= 15000000)) {
                    if (prixMetre <= 50000) {
                        prix1 = (float) (prixBien + 0.02 * prixBien);
                    } else {
                        prix1 = (float) (prixBien + 0.025 * prixBien);
                    }
                } else if (prixBien > 15000000) {
                    if (prixMetre < 70000) {
                        prix1 = (float) (prixBien + 0.01 * prixBien);
                    } else {
                        prix1 = (float) (prixBien + 0.02 * prixBien);
                    }
                }
                if (getNbr_facades() > 1) prix1 = (float) (prix1 + (0.005 * ( getNbr_facades() - 1)));


                if (!getWilaya().equals(getWilaya_echange())) {
                    prix1 = (float) (prix1 + prix1 * 0.0025);
                }

            }
            return prix1;
        }
    }