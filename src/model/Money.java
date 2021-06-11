package model;

import java.io.Serializable;

public class Money extends Pay implements Serializable {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Money class ----------------------------\\
    private double valueMoney;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Money class constructor
     * @param valueMoney object's value of pay
     * @param namePay object's person's name to pay
     */
    public Money(double valueMoney, String namePay) {
        super(namePay);
        this.valueMoney = valueMoney;
    }

    public double getValueMoney() {
        return valueMoney;
    }

    public void setValueMoney(double valueMoney) {
        this.valueMoney = valueMoney;
    }
}
