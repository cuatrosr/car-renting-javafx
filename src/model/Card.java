package model;

import java.io.Serializable;

public class Card extends Pay implements Serializable{
    
    private int cSegurity;
    private double balance;

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
