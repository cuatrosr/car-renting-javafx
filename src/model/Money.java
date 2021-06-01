package model;

import java.io.Serializable;

public class Money extends Pay implements Serializable {

    private static final long serialVersionUID = 1;

    private double valueMoney;

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
