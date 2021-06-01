package exception;

public class Payed extends Exception {

    private static final long serialVersionUID = 1L;
    
    private double valuePay;
    private double valueCost;

    public Payed(double valuePay, double valueCost) {
        super("Hace falta "+(valueCost-valuePay)+" para completar el pago");
        this.valuePay = valuePay;
        this.valueCost = valueCost;
    }

    public double getValuePay() {
        return valuePay;
    }

    public void setValuePay(double valuePay) {
        this.valuePay = valuePay;
    }

    public double getValueCost() {
        return valueCost;
    }

    public void setValueCost(double valueCost) {
        this.valueCost = valueCost;
    }
}
