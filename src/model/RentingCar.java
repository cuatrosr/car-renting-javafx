package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import exception.*;

public class RentingCar implements Serializable {

    private static final long serialVersionUID = 1;
    public int code;
    public Employee firstE;
    public Employee empActive;
    public Vehicle firstV;
    public List<City> listCities;
    public List<Client> listClients;
    public List<TypeV> listTypeV;
    public List<Brand> listBrands;

    public RentingCar() {
        code = 1;
        firstV = null;
        firstE = null;
        listCities = new ArrayList<>();
        listClients = new ArrayList<>();
        listTypeV = new ArrayList<>();
        listBrands = new ArrayList<>();
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

    public List<TypeV> getListTypeV() {
        return listTypeV;
    }

    public List<Brand> getListBrand() {
        return listBrands;
    }

    public List<Client> getListClients() {
        return listClients;
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

    public boolean uptadeCity(int code, String name) {
        int count = 0;
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getNameCi().equalsIgnoreCase(name)) {
                count++;
            }
        }
        if (count == 0) {
            for (int i = 0; i < listCities.size(); i++) {
                if (listCities.get(i).getCodeCi() == code) {
                    listCities.get(i).setNameCi(name);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void removeCity(int code) throws Reference {
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getCodeCi() == code) {
                if (listCities.get(i).getRefCi() == 0) {
                    listCities.remove(i);
                } else {
                    throw new Reference(listCities.get(i).getRefCi());
                }
            }
        }
    }

    public boolean addTypeV(int quality, int refTv, int codeA, String nameTB) {
        int count = 0;
        if (listTypeV.isEmpty()) {
            TypeV newTypeV = new TypeV(quality, refTv, code++, nameTB);
            listTypeV.add(newTypeV);
            return true;
        } else {
            for (int i = 0; i < listTypeV.size(); i++) {
                if (listTypeV.get(i).getNameTB().equalsIgnoreCase(nameTB) && listTypeV.get(i).getQuality() == quality) {
                    count++;
                }
            }
            if (count == 0) {
                TypeV newTypeV = new TypeV(quality, refTv, code++, nameTB);
                listTypeV.add(newTypeV);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean uptadeTypeV(int code, String name, int quality) {
        int count = 0;
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getNameTB().equalsIgnoreCase(name) && listTypeV.get(i).getQuality() == quality) {
                count++;
            }
        }
        if (count == 0) {
            for (int i = 0; i < listTypeV.size(); i++) {
                if (listTypeV.get(i).getCodeA() == code) {
                    listTypeV.get(i).setNameTB(name);
                    listTypeV.get(i).setQuality(quality);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void removTypeV(int code) throws Reference {
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getCodeA() == code) {
                if (listTypeV.get(i).getRefTv() == 0) {
                    listTypeV.remove(i);
                } else {
                    throw new Reference(listTypeV.get(i).getRefTv());
                }
            }
        }
    }

    public boolean addBrand(String country, int refB, int codeA, String nameTB) {
        int count = 0;
        if (listBrands.isEmpty()) {
            Brand newBrand = new Brand(country, refB, code++, nameTB);
            listBrands.add(newBrand);
            return true;
        } else {
            for (int i = 0; i < listBrands.size(); i++) {
                if (listBrands.get(i).getNameTB().equalsIgnoreCase(nameTB) && listBrands.get(i).getCountry().equalsIgnoreCase(country)) {
                    count++;
                }
            }
            if (count == 0) {
                Brand newBrand = new Brand(country, refB, code++, nameTB);
                listBrands.add(newBrand);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean uptadeBrand(int code, String name, String country) {
        int count = 0;
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getNameTB().equalsIgnoreCase(name) && listBrands.get(i).getCountry().equalsIgnoreCase(country)) {
                count++;
            }
        }
        if (count == 0) {
            for (int i = 0; i < listBrands.size(); i++) {
                if (listBrands.get(i).getCodeA() == code) {
                    listBrands.get(i).setNameTB(name);
                    listBrands.get(i).setCountry(country);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void removeBrand(int code) throws Reference {
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getCodeA() == code) {
                if (listBrands.get(i).getRefB() == 0) {
                    listBrands.remove(i);
                } else {
                    throw new Reference(listBrands.get(i).getRefB());
                }
            }
        }
    }

    public boolean addClient(String addressC, long phoneC, String emailC, City cityC, int codeP, int refP, String name, String lastName, long id) throws Email {
        boolean out = false;
        int count = 0;
        if (listClients.isEmpty() && !out) {
            if (emailC.contains("@")) {
                Client newClient = new Client(addressC, phoneC, emailC, cityC, code++, refP, name, lastName, id);
                listClients.add(newClient);
                plusRefCity(cityC);
                out = true;
            } else {
                out = false;
                throw new Email(emailC);
            }
        } else {
            for (int i = 0; i < listClients.size(); i++) {
                if (listClients.get(i).getId() == id) {
                    count++;
                }
            }
            if (count == 0) {
                if (emailC.contains("@")) {
                    Client newClient = new Client(addressC, phoneC, emailC, cityC, code++, refP, name, lastName, id);
                    int n = 0;
                    while (n < listClients.size() && newClient.compareTo(listClients.get(n)) > 0) {
                        n++;
                    }
                    listClients.add(n, newClient);
                    plusRefCity(cityC);
                    out = true;
                } else {
                    out = false;
                    throw new Email(emailC);
                }
            } else {
                out = false;
            }
        }
        return out;
    }

    public City findCitySelected(String nameCity) {
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getNameCi().equals(nameCity)) {
                return listCities.get(i);
            }
        }
        return null;
    }

    public void plusRefCity(City cityPlus) {
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getCodeCi() == cityPlus.getCodeCi()) {
                listCities.get(i).setRefCi(listCities.get(i).getRefCi() + 1);
            }
        }
    }

    public boolean uptadeClient(String addressC, long phoneC, String emailC, City cityC, int code, String name, String lastName, long id) throws Email {
        boolean out = false;
        boolean sameID = false;
        int count = 0;
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getId() == id) {
                count++;
            }
            if(listClients.get(i).getCodeP() == code){
                if(listClients.get(i).getId() == id){
                    sameID = true;
                }
            }
        }
        if (count == 0 || sameID) {
            for (int i = 0; i < listClients.size(); i++) {
                if (listClients.get(i).getCodeP() == code) {
                    if (emailC.contains("@")) {
                        restRefCity(findCitySelected(listClients.get(i).getNameCity()));
                        int refP = listClients.get(i).getRefP();
                        listClients.remove(i);
                        Client newClient = new Client(addressC, phoneC, emailC, cityC, code, refP, name, lastName, id);
                        int n = 0;
                        while (n < listClients.size() && newClient.compareTo(listClients.get(n)) > 0) {
                            n++;
                        }
                        listClients.add(n, newClient);
                        plusRefCity(cityC);
                        out = true;
                    } else {
                        out = false;
                        throw new Email(emailC);
                    }
                }
            }
        } else {
            out = false;
        }
        return out;
    }

    public void restRefCity(City city) {
        for (int j = 0; j < listCities.size(); j++) {
            if (listCities.get(j) == city) {
                listCities.get(j).setRefCi(listCities.get(j).getRefCi() - 1);
            }
        }
    }
    
    public void removeClient(int code) throws Reference{
        for (int i = 0; i < listClients.size(); i++) {
            if(listClients.get(i).getCodeP() == code){
                if(listClients.get(i).getRefP() == 0){
                    listClients.remove(i);
                } else {
                    throw new Reference(listClients.get(i).getRefP());
                }
            }
        }
    }
}
