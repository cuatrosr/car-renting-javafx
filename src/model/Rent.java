package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Rent implements Serializable {

    private static final long serialVersionUID = 1;
    private final String PREFTICKET = "RC0";
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

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public Client getClientR() {
        return clientR;
    }

    public void setClientR(Client clientR) {
        this.clientR = clientR;
    }

    public Car getCarR() {
        return carR;
    }

    public void setCarR(Car carR) {
        this.carR = carR;
    }

    public LocalDate getFinitial() {
        return Finitial;
    }

    public void setFinitial(LocalDate Finitial) {
        this.Finitial = Finitial;
    }

    public LocalDate getFfinal() {
        return Ffinal;
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
