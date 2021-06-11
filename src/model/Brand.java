package model;

import java.io.Serializable;

public class Brand extends Accessory implements Serializable, Comparable<Brand> {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Brand class ----------------------------\\
    
    private String country;
    private int refB;

    //-------------------------- Constructor, getter and setter class --------------------------\\

    /**
     * Brand class constructor.
     * @param country object's country
     * @param refB object's reference
     * @param codeA object's code
     * @param nameTB object's name
     */
    public Brand(String country, int refB, int codeA, String nameTB) {
        super(codeA, nameTB);
        this.country = country;
        this.refB = refB;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRefB() {
        return refB;
    }

    public void setRefB(int refB) {
        this.refB = refB;
    }

    public String getNameP() {
        return this.getNameTB() + " " + country;
    }

    @Override
    public int compareTo(Brand o) {
        return this.getNameTB().compareToIgnoreCase(o.getNameTB());
    }
}
