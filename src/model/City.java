package model;

import java.io.Serializable;

public class City implements Serializable, Comparable<City> {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the City class ----------------------------\\
    private int codeCi;
    private String nameCi;
    private int refCi;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * City class constructor
     * @param codeCi object's code
     * @param nameCi object's name
     * @param refCi  object's reference
     */
    public City(int codeCi, String nameCi, int refCi) {
        this.codeCi = codeCi;
        this.nameCi = nameCi;
        this.refCi = refCi;
    }

    public int getCodeCi() {
        return codeCi;
    }

    public void setCodeCi(int codeCi) {
        this.codeCi = codeCi;
    }

    public String getNameCi() {
        return nameCi;
    }

    public void setNameCi(String nameCi) {
        this.nameCi = nameCi;
    }

    public int getRefCi() {
        return refCi;
    }

    public void setRefCi(int refCi) {
        this.refCi = refCi;
    }

    @Override
    public int compareTo(City o) {
        return this.getNameCi().compareToIgnoreCase(o.getNameCi());
    }
}
