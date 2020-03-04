package sample;

public class criterePrix {
    public criterePrix(int prixMinimal, int prixMaximal) {
        PrixMaximal = prixMaximal;
        PrixMinimal = prixMinimal;
    }

    private int PrixMaximal;
    private int PrixMinimal;

    public int getPrixMaximal() {
        return PrixMaximal;
    }

    public void setPrixMaximal(int prixMaximal) {
        PrixMaximal = prixMaximal;
    }

    public int getPrixMinimal() {
        return PrixMinimal;
    }

    public void setPrixMinimal(int prixMinimal) {
        PrixMinimal = prixMinimal;
    }
}
