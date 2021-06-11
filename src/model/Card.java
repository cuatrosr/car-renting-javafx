package model;

import java.io.Serializable;

public class Card extends Pay implements Serializable {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Card class ----------------------------\\
    private int cSegurity;
    private double balance;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Card class constructor
     * @param cSegurity objetct's code segurity
     * @param balance objetct's balance of money
     * @param namePay objetct's person's name pay
     */
    public Card(int cSegurity, double balance, String namePay) {
        super(namePay);
        this.cSegurity = cSegurity;
        this.balance = balance;
    }

    public int getcSegurity() {
        return cSegurity;
    }

    public void setcSegurity(int cSegurity) {
        this.cSegurity = cSegurity;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
