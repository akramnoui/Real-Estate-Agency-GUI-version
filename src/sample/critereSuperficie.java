package sample;

public class critereSuperficie {
    private float supMaximal;
    private float supMinimal;

    public critereSuperficie(int supMaximal, int supMinimal) {
        this.supMaximal=supMaximal;
        this.supMinimal=supMinimal;
    }

    public float getSupMaximal() {
        return supMaximal;
    }

    public void setSupMaximal(float supMaximal) {
        this.supMaximal = supMaximal;
    }

    public float getSupMinimal() {
        return supMinimal;
    }

    public void setSupMinimal(float supMinimal) {
        this.supMinimal = supMinimal;
    }
}
