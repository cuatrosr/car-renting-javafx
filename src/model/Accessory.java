package model;

import java.io.Serializable;

public class Accessory implements Serializable {
    
    
    //---------------------------- Attributes of the Accessory class ----------------------------\\

    private int codeA;
    private String nameTB;
    
    //-------------------------- Constructor, getter and setter class --------------------------\\
    
    /**
     * Accseroy class constructor
     * @param codeA Accesory's code
     * @param nameTB Accesory's code
     */
    public Accessory(int codeA, String nameTB) {
        this.codeA = codeA;
        this.nameTB = nameTB;
    }

    public int getCodeA() {
        return codeA;
    }

    public void setCodeA(int codeA) {
        this.codeA = codeA;
    }

    public String getNameTB() {
        return nameTB;
    }

    public void setNameTB(String nameTB) {
        this.nameTB = nameTB;
    }
}
