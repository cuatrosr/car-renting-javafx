package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1;
    private Employee next;
    private String username;
    private String password;
    private int nSold;
    private double vComision;

    public Employee(String username, String password, int nSold, double vComision, int codeP, int refP, String name, String lastName, long id) {
        super(codeP, refP, name, lastName, id);
        this.username = username;
        this.password = password;
        this.nSold = nSold;
        this.vComision = vComision;
        next = null;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee emp) {
        next = emp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getnSold() {
        return nSold;
    }

    public void setnSold(int nSold) {
        this.nSold = nSold;
    }

    public double getvComision() {
        return vComision;
    }

    public void setvComision(int nSold) {
        this.vComision = nSold * 10000;
    }
}
