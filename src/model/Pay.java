package model;

import java.io.Serializable;

public class Pay implements Serializable {

    private static final long serialVersionUID = 1;
    
    private String namePay;

    public Pay(String namePay) {
        this.namePay = namePay;
    }

    public String getNamePay() {
        return namePay;
    }

    public void setNamePay(String namePay) {
        this.namePay = namePay;
    }
}
