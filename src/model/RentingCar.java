package model;

import java.io.Serializable;

public class RentingCar implements Serializable {

    private static final long serialVersionUID = 1;
    public Vehicle firstV;
    public Employee firstE;
    public int code;

    public RentingCar() {
        firstV = null;
        firstE = null;
        code = 0;
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
        if (current.getName() == null) {
            current.setNext(emp);
        } else {
            addEmp(emp, current.getNext());
        }
    }
}
