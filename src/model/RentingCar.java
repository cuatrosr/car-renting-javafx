package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RentingCar implements Serializable {

    private static final long serialVersionUID = 1;
    public int code;
    public Employee firstE;
    public Employee empActive;
    public Vehicle firstV;
    public List<City> listCities;
    public List<Client> listClients;

    public RentingCar() {
        code = 1;
        firstV = null;
        firstE = null;
        listCities = new ArrayList<>();
        listClients = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public Employee getEmpActive() {
        return empActive;
    }

    public Employee getFirstE() {
        return firstE;
    }

    public List<City> getListCities() {
        return listCities;
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

    public boolean addCity(int codeCi, String nameCi, int refCi) {
        int count = 0;
        if (listCities.isEmpty()) {
            City newCity = new City(code++, nameCi, refCi);
            listCities.add(newCity);
            return true;
        } else {
            for (int i = 0; i < listCities.size(); i++) {
                if (listCities.get(i).getNameCi().equalsIgnoreCase(nameCi)) {
                    count++;
                }
            }
            if (count == 0) {
                City newCity = new City(code++, nameCi, refCi);
                listCities.add(newCity);
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean uptadeCity(int code, String name){
        int count = 0;
        for(int i = 0; i<listCities.size(); i++){
            if(listCities.get(i).getNameCi().equalsIgnoreCase(name)){
                count++;
            }
        }
        if(count == 0){
            for(int i = 0; i<listCities.size(); i++){
                if(listCities.get(i).getCodeCi() == code){
                    listCities.get(i).setNameCi(name);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean removeCity(int code) {
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getCodeCi() == code) {
                if (listCities.get(i).getRefCi() == 0) {
                    listCities.remove(i);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
