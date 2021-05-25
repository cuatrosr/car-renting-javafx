package model;

import java.io.Serializable;

public class TypeV implements Serializable {

    private static final long serialVersionUID = 1;
    private int codeTv;
    private String nameTv;
    private int refTv;

    public TypeV(int codeTv, String nameTv, int refTv) {
        this.codeTv = codeTv;
        this.nameTv = nameTv;
        this.refTv = refTv;
    }

    public int getCodeTv() {
        return codeTv;
    }

    public void setCodeTv(int codeTv) {
        this.codeTv = codeTv;
    }

    public String getNameTv() {
        return nameTv;
    }

    public void setNameTv(String nameTv) {
        this.nameTv = nameTv;
    }

    public int getRefTv() {
        return refTv;
    }

    public void setRefTv(int refTv) {
        this.refTv = refTv;
    }
}
