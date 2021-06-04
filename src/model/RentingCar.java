package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import exception.*;
import javafx.scene.image.Image;

public class RentingCar implements Serializable {

    private static final long serialVersionUID = 1;
    public int code;
    public Employee firstE;
    public Employee empActive;
    public Employee rootNameE;
    public List<Employee> showRootName;
    public Employee rootComision;
    public List<Employee> showRootComision;
    public Car firstC;
    public Car rootNameC;
    public List<Car> showRootCar;
    public List<City> listCities;
    public List<Client> listClients;
    public List<TypeV> listTypeV;
    public List<Brand> listBrands;

    public RentingCar() {
        code = 1;
        firstC = null;
        firstE = null;
        rootNameE = null;
        rootNameC = null;
        listCities = new ArrayList<>();
        listClients = new ArrayList<>();
        listTypeV = new ArrayList<>();
        listBrands = new ArrayList<>();
        showRootName = new ArrayList<>();
        showRootComision = new ArrayList<>();
        showRootCar = new ArrayList<>();
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

    public Car getFirstC() {
        return firstC;
    }

    public Employee getRootNameE() {
        return rootNameE;
    }

    public Car getRootNameC() {
        return rootNameC;
    }

    public List<Employee> getShowRootName() {
        return showRootName;
    }

    public List<Employee> getShowRootComision() {
        return showRootComision;
    }

    public List<Car> getShowRootCar() {
        return showRootCar;
    }

    public void setShowRootCar() {
        this.showRootCar.clear();
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
            addBinaryEmployee(emp);
        } else {
            addEmp(emp, firstE);
        }
    }

    private void addEmp(Employee emp, Employee current) {
        if (current.getNext() == null) {
            current.setNext(emp);
            addBinaryEmployee(emp);
        } else {
            addEmp(emp, current.getNext());
        }
    }

    public void addBinaryEmployee(Employee nextTest) {
        if (rootNameE == null) {
            rootNameE = nextTest;
        } else {
            addBinaryEmployee(rootNameE, nextTest);
        }
    }

    private void addBinaryEmployee(Employee current, Employee next) {
        if (current.compareTo(next) < 0) {
            if (current.getRight() == null) {
                current.setRight(next);
                next.setParent(current);
            } else {
                addBinaryEmployee(current.getRight(), next);
            }
        } else {
            if (current.getLeft() == null) {
                current.setLeft(next);
                next.setParent(current);
            } else {
                addBinaryEmployee(current.getLeft(), next);
            }
        }
    }

    public void showBinaryTreeNameEmployee(Employee root) {
        if (root != null) {
            showBinaryTreeNameEmployee(root.getLeft());
            showRootName.add(root);
            showBinaryTreeNameEmployee(root.getRight());
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
            if (listClients.get(i).getCodeP() == code) {
                if (listClients.get(i).getId() == id) {
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

    public void removeClient(int code) throws Reference {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getCodeP() == code) {
                if (listClients.get(i).getRefP() == 0) {
                    listClients.remove(i);
                } else {
                    throw new Reference(listClients.get(i).getRefP());
                }
            }
        }
    }

    public boolean addCar(String model, String color, Brand brand, TypeV typeV, double priceXDay, int codeV, String plate, boolean dispV, Image photo, int year) {
        if (!searchPlate(plate)) {
            Car newCar = new Car(model, color, brand, typeV, priceXDay, code++, plate, dispV, photo, year);
            plusRefBrand(brand);
            plusRefTypeV(typeV);
            addBinaryVehicle(newCar);
            if (firstC == null) {
                firstC = newCar;
                firstC.setNext(newCar);
                firstC.setPrev(newCar);
                return true;
            } else {
                return addCar(firstC, newCar);
            }
        } else {
            return false;
        }
    }

    private boolean addCar(Car current, Car newCar) {
        if (current.getNext() == firstC) {
            current.setNext(newCar);
            newCar.setNext(firstC);
            newCar.setPrev(current);
            firstC.setPrev(newCar);
            return true;
        } else {
            return addCar(current.getNext(), newCar);
        }
    }

    public boolean searchPlate(String plate) {
        if (firstC == null) {
            return false;
        } else {
            return searchPlate(plate, firstC);
        }
    }

    private boolean searchPlate(String plate, Car current) {
        if (current.getPlate().equals(plate)) {
            return true;
        } else {
            if (current.getNext() == firstC) {
                return false;
            } else {
                return searchPlate(plate, current.getNext());
            }
        }
    }

    public TypeV findTypeVSelected(String nameTypeV) {
        String[] nameSplit = nameTypeV.split(" ");
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getNameTB().equals(nameSplit[0]) && listTypeV.get(i).getQuality() == Integer.parseInt(nameSplit[1])) {
                return listTypeV.get(i);
            }
        }
        return null;
    }

    public void plusRefTypeV(TypeV typeVPlus) {
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getCodeA() == typeVPlus.getCodeA()) {
                listTypeV.get(i).setRefTv(listTypeV.get(i).getRefTv() + 1);
            }
        }
    }

    public Brand findBrandSelected(String nameBrand) {
        String[] nameSplit = nameBrand.split(" ");
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getNameTB().equals(nameSplit[0]) && listBrands.get(i).getCountry().equals(nameSplit[1])) {
                return listBrands.get(i);
            }
        }
        return null;
    }

    public void plusRefBrand(Brand brandPlus) {
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getCodeA() == brandPlus.getCodeA()) {
                listBrands.get(i).setRefB(listBrands.get(i).getRefB() + 1);
            }
        }
    }

    public void addBinaryVehicle(Car f) {
        if (rootNameC == null) {
            rootNameC = f;
        } else {
            addBinaryVehicle(rootNameC, f);
        }
    }

    private void addBinaryVehicle(Car current, Car next) {
        if (current.compareTo(next) < 0) {
            if (current.getRight() == null) {
                current.setRight(next);
                next.setParent(current);
            } else {
                addBinaryVehicle(current.getRight(), next);
            }
        } else {
            if (current.getLeft() == null) {
                current.setLeft(next);
                next.setParent(current);
            } else {
                addBinaryVehicle(current.getLeft(), next);
            }
        }
    }

    public void showBinaryTreeVehicle(Car root) {
        if (root != null) {
            showBinaryTreeVehicle(root.getLeft());
            showRootCar.add(root);
            showBinaryTreeVehicle(root.getRight());
        }
    }

    public Car findVehicletoShowNext(int position) {
        if (firstC == null) {
            return null;
        } else {
            Car temp = firstC;
            int count = 0;
            while (count < position) {
                temp = temp.getNext();
                count++;
            }
            if (count != position) {
                return null;
            } else {
                return temp;
            }
        }
    }

    public Car findVehicletoShowPrev(int position) {
        if (firstC == null) {
            return null;
        } else {
            Car temp = firstC;
            int count = 0;
            while (count < position) {
                temp = temp.getPrev();
                count++;
            }
            if (count != position) {
                return null;
            } else {
                return temp;
            }
        }
    }
}
