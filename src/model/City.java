package model;

import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = 1;
    private int codeCi;
    private String nameCi;
    private int refCi;

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
}
