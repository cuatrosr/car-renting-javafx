package model;

import java.io.Serializable;

public class TypeV extends Accessory implements Serializable, Comparable<TypeV> {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Type of vehicle class ----------------------------\\
    private int quality;
    private int refTv;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Type vehiclie class constructor
     * @param quality objects's quality
     * @param refTv objects's reference
     * @param codeA objects's code
     * @param nameTB objects's name
     */
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

    public String getNameQ() {
        return this.getNameTB() + " " + quality;
    }

    @Override
    public int compareTo(TypeV o) {
        return this.getNameTB().compareToIgnoreCase(o.getNameTB());
    }
}
