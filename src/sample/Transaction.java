package sample;

public interface Transaction {
//public static final float  b= 5000000;

    default float ventePrix (float prixBien, float prixMetre) {
        float prix = 0 ;
        //on peut pas switcher un float !!
        if (prixBien<5000000) {
            if (prixMetre<50000) {
                prix = (float) (prixBien + 0.03*prixBien);
            }
            else {
                prix = (float) (prixBien + 0.035*prixBien);
            }
        }
        else if ((5000000<= prixBien)&&( prixBien<= 15000000)) {
            if (prixMetre<=50000) {
                prix = (float) (prixBien + 0.02*prixBien);
            }
            else {
                prix = (float) (prixBien + 0.025*prixBien);
            }
        }
        else if (prixBien>15000000) {
            if (prixMetre<70000) {
                prix = (float) (prixBien + 0.01*prixBien);
            }
            else {
                prix = (float) (prixBien + 0.02*prixBien);
            }
        }


        return prix ;
    }
    default float locationPrix (float prixBien, float prixMetre,float superficie) {
        float prix = 0 ;
        //on peut pas switcher un float !!
        if (superficie<60) {
            if (prixMetre<50000) {
                prix = (float) (prixBien + 0.01*prixBien);
            }
            else {
                prix = (float) (prixBien + 0.015*prixBien);
            }
        }
        else if ((60<= superficie)&&( superficie<= 150)) {
            if (prixMetre<=50000) {
                prix = (float) (prixBien + 0.02*prixBien);
            }
            else {
                prix = (float) (prixBien + 0.025*prixBien);
            }
        }
        else if (superficie>150) {
            if (prixMetre<50000) {
                prix = (float) (prixBien + 0.03*prixBien);
            }
            else {
                prix = (float) (prixBien + 0.035*prixBien);
            }
        }


        return prix ;
    }
    default float echangePrix (float prixBien, float prixMetre,String wilayaSource,String wilayaDes) {
        float prix  ;
        prix = ventePrix(prixBien,prixMetre);
        if (!wilayaSource.equalsIgnoreCase(wilayaDes)) {
            prix = (float) (prix +prix*0.0025);
        }
        return prix ;
    }

}
