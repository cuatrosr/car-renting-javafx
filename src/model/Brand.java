package model;

import java.io.Serializable;

public class Brand extends Accessory implements Serializable {

    private static final long serialVersionUID = 1;
    
    private String country;
    private int refB;

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
    
    public String getNameP(){
        return this.getNameTB() + " " + country;
    }
}
