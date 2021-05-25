package model;

import java.io.Serializable;

public class RentingCar implements Serializable {

    private static final long serialVersionUID = 1;
    public Vehicle firstV;
    public Employee firstE;
    public int code;
    public Employee empActive;

    public RentingCar() {
        firstV = null;
        firstE = null;
        code = 0;
    }

    public Employee getEmpActive() {
        return empActive;
    }

    public Employee getFirstE() {
        return firstE;
    }

    public int getCode() {
        return code;
    }

    public void addEmployee(String username, String password, int nSold, double vComision, int codeP, int refP, String name, String lastName, long id) {
        Employee emp = new Employee(username, password, nSold, vComision, code++, refP, name, lastName, id);
        addEmp(emp);
    }

    public void addEmp(Employee emp) {
        if (firstE == null) {
            firstE = emp;
        } else {
            addEmp(emp, firstE);
        }
    }

    private void addEmp(Employee emp, Employee current) {
        if (current.getNext() == null) {
            current.setNext(emp);
        } else {
            addEmp(emp, current.getNext());
        }
    }

    public boolean loginEmployee(String userName, String password) {
        if (firstE.getUsername().equals(userName) && firstE.getPassword().equals(password)) {
            empActive = firstE;
            return true;
        } else if (firstE.getNext() != null) {
            return loginEmployee(firstE.getNext(), userName, password);
        } else {
            return false;
        }
    }

    private boolean loginEmployee(Employee current, String userName, String password) {
        if (current.getUsername().equals(userName) && current.getPassword().equals(password)) {
            empActive = firstE;
            return true;
        } else if (current.getNext() != null) {
            return loginEmployee(current.getNext(), userName, password);
        } else {
            return false;
        }
    }
}
