package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Rent implements Serializable {

    private static final long serialVersionUID = 1;
    private final String PREFTICKET = "TRC";

    //---------------------------- Attributes of the Rent class ----------------------------\\
    private int codeR;
    private int ticket;
    private Client clientR;
    private Car carR;
    private LocalDate Finitial;
    private LocalDate Ffinal;
    private int days;
    private Status status;
    private int delay;
    private int mult;
    private int priceTotal;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Rent class constructor
     * @param codeR object's code
     * @param ticket object's ticket
     * @param clientR object's client to rent
     * @param carR object's car to rent
     * @param Finitial object's initial date
     * @param Ffinal object's final date
     * @param days object's days to rent
     * @param status object's stat
     * @param delay object's day of delay
     * @param mult object's value of mult
     * @param priceTotal object's price total to pay
     */
    public Rent(int codeR, int ticket, Client clientR, Car carR, LocalDate Finitial, LocalDate Ffinal, int days, Status status, int delay, int mult, int priceTotal) {
        this.codeR = codeR;
        this.ticket = ticket;
        this.clientR = clientR;
        this.carR = carR;
        this.Finitial = Finitial;
        this.Ffinal = Ffinal;
        this.days = days;
        this.status = status;
        this.delay = delay;
        this.mult = mult;
        this.priceTotal = priceTotal;
    }

    public int getCodeR() {
        return codeR;
    }

    public void setCodeR(int codeR) {
        this.codeR = codeR;
    }

    public int getTicket() {
        return ticket;
    }

    public String getNameTicket() {
        String nameTicket;
        nameTicket = PREFTICKET + ticket;
        return nameTicket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public Client getClientR() {
        return clientR;
    }

    public void setClientR(Client clientR) {
        this.clientR = clientR;
    }

    public Long getIdClient() {
        return clientR.getId();
    }

    public String getNameClient() {
        return clientR.getName();
    }

    public Long getPhoneClient() {
        return clientR.getPhoneC();
    }

    public Car getCarR() {
        return carR;
    }

    public void setCarR(Car carR) {
        this.carR = carR;
    }

    public int getIdCar() {
        return carR.getCodeV();
    }

    public String getPlateCar() {
        return carR.getPlate();
    }

    public String getNameType() {
        return carR.getNameType();
    }

    public String getNameModel() {
        return carR.getModel();
    }

    public LocalDate getFinitial() {
        return Finitial;
    }

    public String getStringFinitial() {
        return Finitial.toString();
    }

    public void setFinitial(LocalDate Finitial) {
        this.Finitial = Finitial;
    }

    public LocalDate getFfinal() {
        return Ffinal;
    }

    public String getStringFfinal() {
        return Ffinal.toString();
    }

    public void setFfinal(LocalDate Ffinal) {
        this.Ffinal = Ffinal;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getMult() {
        return mult;
    }

    public void setMult(int mult) {
        this.mult = mult;
    }

    public int getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }
}
