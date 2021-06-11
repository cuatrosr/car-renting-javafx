package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable, Comparable<Employee> {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Employee class ----------------------------\\
    private String username;
    private String password;
    private int nSold;
    private double vComision;
    private Employee next;

    //---------------------------- Binary tree Employee class ----------------------------\\
    private Employee left;
    private Employee right;
    private Employee parent;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Employee class constructor
     * @param username object's username
     * @param password object's password
     * @param nSold object's amount of sold
     * @param vComision object's value of comision
     * @param codeP object's code
     * @param refP object's reference
     * @param name object's name
     * @param lastName object's last name
     * @param id object's identification
     */
    public Employee(String username, String password, int nSold, double vComision, int codeP, int refP, String name, String lastName, long id) {
        super(codeP, refP, name, lastName, id);
        this.username = username;
        this.password = password;
        this.nSold = nSold;
        this.vComision = vComision;
        next = null;
        left = null;
        right = null;
        parent = null;
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

    public int getNSold() {
        return nSold;
    }

    public void setnSold(int nSold) {
        this.nSold = nSold;
        this.vComision = this.nSold * 10000;
    }

    public double getVComision() {
        return vComision;
    }

    public void setvComision(int nSold) {
        this.vComision = nSold * 10000;
    }

    public Employee getLeft() {
        return left;
    }

    public void setLeft(Employee left) {
        this.left = left;
    }

    public Employee getRight() {
        return right;
    }

    public void setRight(Employee right) {
        this.right = right;
    }

    public Employee getParent() {
        return parent;
    }

    public void setParent(Employee parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
}
