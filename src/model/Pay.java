package model;

import java.io.Serializable;

public class Pay implements Serializable {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Pay class ----------------------------\\
    private String namePay;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Pay class constructor
     * @param namePay object's person's name to pay
     */
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
