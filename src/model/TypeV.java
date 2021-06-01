package model;

import java.io.Serializable;

public class TypeV extends Accessory implements Serializable {

    private static final long serialVersionUID = 1;
    
    private int quality;
    private int refTv;

    public TypeV(int quality, int refTv, int codeA, String nameTB) {
        super(codeA, nameTB);
        this.quality = quality;
        this.refTv = refTv;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getRefTv() {
        return refTv;
    }

    public void setRefTv(int refTv) {
        this.refTv = refTv;
    }
}
