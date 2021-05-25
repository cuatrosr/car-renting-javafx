package model;

import java.io.Serializable;

public class Brand implements Serializable {

    private static final long serialVersionUID = 1;
    private int codeB;
    private String name;
    private int refB;

    public Brand(int codeB, String name, int refB) {
        this.codeB = codeB;
        this.name = name;
        this.refB = refB;
    }

    public int getCodeB() {
        return codeB;
    }

    public void setCodeB(int codeB) {
        this.codeB = codeB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRefB() {
        return refB;
    }

    public void setRefB(int refB) {
        this.refB = refB;
    }
}
