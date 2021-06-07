package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import exception.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class RentingCar implements Serializable {

    private static final long serialVersionUID = 1;
    public int code;
    public int codeTicket;
    public Employee firstE;
    public Employee empActive;
    public Employee rootNameE;
    public List<Employee> showRootName;
    public Car firstC;
    public Car rootNameC;
    public List<Car> showRootCar;
    public List<City> listCities;
    public List<Client> listClients;
    public List<TypeV> listTypeV;
    public List<Brand> listBrands;
    public List<Rent> listRents;

    public RentingCar() {
        code = 1;
        codeTicket = 1;
        firstC = null;
        firstE = null;
        rootNameE = null;
        rootNameC = null;
        listCities = new ArrayList<>();
        listClients = new ArrayList<>();
        listTypeV = new ArrayList<>();
        listBrands = new ArrayList<>();
        showRootName = new ArrayList<>();
        showRootCar = new ArrayList<>();
        listRents = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public int getCodeTicket() {
        return codeTicket;
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

    public void setShowRootName() {
        this.showRootName.clear();
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

    public List<Rent> getListRent() {
        return listRents;
    }

    public void addEmployee(String username, String password, int nSold, double vComision, int codeP, int refP, String name, String lastName, long id) {
        Employee emp = new Employee(username, password, nSold, vComision, code++, refP, name, lastName, id);
        addEmp(emp);
    }

    public void addEmp(Employee emp) {
        if (firstE == null) {
            firstE = emp;
            empActive = firstE;
            addBinaryEmployee(emp);
        } else {
            addEmp(emp, firstE);
        }
    }

    private void addEmp(Employee emp, Employee current) {
        if (current.getNext() == null) {
            current.setNext(emp);
            empActive = emp;
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
            empActive = current;
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

    public boolean addCar(String model, String color, Brand brand, TypeV typeV, double priceXDay, int codeV, String plate, boolean dispV, String photo, int year) {
        if (!searchPlate(plate)) {
            Car newCar = new Car(model, color, brand, typeV, priceXDay, code++, plate, dispV, photo, year, 0);
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

    public void restRefType(TypeV typeVRest) {
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getCodeA() == typeVRest.getCodeA()) {
                listTypeV.get(i).setRefTv(listTypeV.get(i).getRefTv() - 1);
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

    public void restRefBrand(Brand brandRest) {
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getCodeA() == brandRest.getCodeA()) {
                listBrands.get(i).setRefB(listBrands.get(i).getRefB() - 1);
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

    public boolean uptadeCar(int code, String model, String color, Brand brand, TypeV typeV, double priceXDay, String plate, boolean dispV, String photo, int year) {
        boolean out1 = false;
        boolean out2 = false;
        if (!searchPlate(plate)) {
            out1 = true;
        }
        if (verifySameCar(code).equals(plate)) {
            out2 = true;
        }
        if (out1 || out2) {
            Car temp = firstC;
            while (code != temp.getCodeV()) {
                temp = temp.getNext();
            }
            restRefBrand(temp.getBrand());
            restRefType(temp.getTypeV());
            temp.setModel(model);
            temp.setColor(color);
            temp.setBrand(brand);
            temp.setTypeV(typeV);
            temp.setPriceXDay(priceXDay);
            temp.setPlate(plate);
            temp.setDispV(dispV);
            temp.setPhoto(photo);
            temp.setYear(year);
            plusRefBrand(brand);
            plusRefTypeV(typeV);
            return true;
        } else {
            return false;
        }
    }

    public String verifySameCar(int code) {
        if (firstC == null) {
            return "";
        } else {
            return verifySameCar(code, firstC);
        }
    }

    private String verifySameCar(int code, Car current) {
        if (current.getCodeV() == code) {
            return current.getPlate();
        } else {
            if (current.getNext() == firstC) {
                return "";
            } else {
                return verifySameCar(code, current.getNext());
            }
        }
    }

    public void removeCar(int code) throws Reference {
        Car carRemove = findCar(code);
        int ref = findCar(code).getRefV();
        if (ref == 0) {
            if (firstC.getNext() == firstC && firstC.getPrev() == firstC) {
                firstC = null;
            } else if (carRemove == firstC) {
                Car tempNext = carRemove.getNext();
                Car tempPrev = carRemove.getPrev();
                firstC = tempNext;
                firstC.setNext(tempNext);
                firstC.setPrev(tempPrev);
            } else {
                Car tempNext = carRemove.getNext();
                Car tempPrev = carRemove.getPrev();
                carRemove.getPrev().setNext(tempNext);
                carRemove.getNext().setPrev(tempPrev);
            }
        } else {
            throw new Reference(ref);
        }
    }

    public void removeCarBinaryTree(int code) throws Reference {
        Car rCar = findCar(code);
        if (rCar.getRefV() == 0) {
            removeCarBinaryTree(rCar);
        } else {
            throw new Reference(rCar.getRefV());
        }
    }

    public void removeCarBinaryTree(Car rmvCar) {
        if (rmvCar != null) {
            if (rmvCar.getLeft() == null && rmvCar.getRight() == null) {
                if (rmvCar == rootNameC) {
                    rootNameC = null;
                } else if (rmvCar.getParent().getLeft() == rmvCar) {
                    rmvCar.getParent().setLeft(null);
                } else {
                    rmvCar.getParent().setRight(null);
                }
                rmvCar.setParent(null);
            } else if (rmvCar.getLeft() == null || rmvCar.getRight() == null) {
                Car onlySon;
                if (rmvCar.getLeft() != null) {
                    onlySon = rmvCar.getLeft();
                } else {
                    onlySon = rmvCar.getRight();
                }
                onlySon.setParent(rmvCar.getParent());
                if (rmvCar == rootNameC) {
                    rootNameC = onlySon;
                } else if (rmvCar.getParent().getLeft() == rmvCar) {
                    rmvCar.getParent().setLeft(onlySon);
                } else {
                    rmvCar.getParent().setRight(onlySon);
                }
            } else {
                Car successor = min(rmvCar.getRight());
                rmvCar.setModel(successor.getModel());
                rmvCar.setColor(successor.getColor());
                rmvCar.setBrand(successor.getBrand());
                rmvCar.setTypeV(successor.getTypeV());
                rmvCar.setPriceXDay(successor.getPriceXDay());
                rmvCar.setCodeV(successor.getCodeV());
                rmvCar.setPlate(successor.getPlate());
                rmvCar.setDispV(successor.isDispV());
                rmvCar.setPhoto(successor.getPhoto());
                rmvCar.setYear(successor.getYear());
                rmvCar.setRefV(successor.getRefV());
                removeCarBinaryTree(successor);
            }
        }
    }

    private Car min(Car current) {
        if (current.getLeft() == null) {
            return current;
        } else {
            return min(current.getLeft());
        }
    }

    private Car minIterative(Car current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public Car findCar(int code) {
        if (firstC.getCodeV() == code) {
            return firstC;
        } else {
            return findCar(code, firstC.getNext());
        }
    }

    private Car findCar(int code, Car next) {
        if (next.getCodeV() == code) {
            return next;
        } else {
            if (next.getNext() == firstC) {
                return null;
            } else {
                return findCar(code, next.getNext());
            }
        }
    }

    public boolean addRent(int codeR, int ticket, Client clientR, Car carR, LocalDate Finitial, LocalDate Ffinal, int days, Status status, int delay, int mult, int priceTotal) {
        if (days > 0) {
            Rent newRent = new Rent(code++, codeTicket++, clientR, carR, Finitial, Ffinal, days, status, delay, mult, priceTotal);
            listRents.add(newRent);
            plusComisionEmployeeEnlazada();
            //plusComisionEmployeeList();
            plusRefClients(clientR.getCodeP());
            plusRefCar(carR.getCodeV());
            return true;
        } else {
            return false;
        }
    }

    public Client searchClientSelected(int code) {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getCodeP() == code) {
                return listClients.get(i);
            }
        }
        return null;
    }

    public void plusComisionEmployeeEnlazada() {
        if (empActive.getCodeP() == firstE.getCodeP()) {
            firstE.setnSold(firstE.getNSold() + 1);
        } else {
            plusComisionEmployee(firstE.getNext());
        }
    }

    private void plusComisionEmployee(Employee current) {
        if (current.getCodeP() == empActive.getCodeP()) {
            current.setnSold(current.getNSold() + 1);
        } else {
            plusComisionEmployee(current.getNext());
        }
    }

    public void plusComisionEmployeeList() {
        for (int i = 0; i < showRootName.size(); i++) {
            if (showRootName.get(i).getCodeP() == empActive.getCodeP()) {
                showRootName.get(i).setnSold(showRootName.get(i).getNSold() + 1);
            }
        }
    }

    public void plusRefClients(int code) {
        for (int i = 0; i < listCities.size(); i++) {
            if (listClients.get(i).getCodeP() == code) {
                listClients.get(i).setRefP(listClients.get(i).getRefP() + 1);
            }
        }
    }

    public void plusRefCar(int code) {
        if (firstC.getCodeV() == code) {
            firstC.setRefV(firstC.getRefV() + 1);
        } else {
            plusRefCar(firstC.getNext(), code);
        }
    }

    private void plusRefCar(Car current, int code) {
        if (current.getCodeV() == code) {
            current.setRefV(current.getRefV() + 1);
        } else {
            plusRefCar(current.getNext(), code);
        }
    }

    public Rent findRentSelected(int code) {
        for (int i = 0; i < listRents.size(); i++) {
            if (listRents.get(i).getCodeR() == code) {
                return listRents.get(i);
            }
        }
        return null;
    }

    public void uptadeStatRent(int code) {
        for (int i = 0; i < listRents.size(); i++) {
            if (listRents.get(i).getCodeR() == code) {
                if (listRents.get(i).getStatus() != Status.PAID) {
                    Long days = listRents.get(i).getFfinal().toEpochDay() - LocalDate.now().toEpochDay();
                    setStatRent(listRents.get(i), days);
                }
            }
        }
    }

    public void setStatRent(Rent rentSelected, long days) {
        if (days > 0) {
            rentSelected.setMult(0);
            rentSelected.setDelay(0);
            rentSelected.setStatus(Status.DEFERRED);
        } else if (days == 0) {
            rentSelected.setMult(0);
            rentSelected.setDelay(0);
            rentSelected.setStatus(Status.EXPIRES_TODAY);
        } else {
            rentSelected.setStatus(Status.EXPIRED);
            int deleayDay = (int) Math.abs(days);
            double plusPrice = rentSelected.getPriceTotal() * 0.25;
            double mult = 0;
            for (int i = 0; i < deleayDay; i++) {
                mult = mult + plusPrice;
            }

            rentSelected.setMult((int) mult);
            rentSelected.setDelay(deleayDay);
            rentSelected.setPriceTotal(rentSelected.getPriceTotal() + rentSelected.getMult());
        }
    }

    public void payRent(int code) {
        findRentSelected(code).setStatus(Status.PAID);
        restRefClient(findRentSelected(code).getClientR().getCodeP());
        restRefCar(findRentSelected(code).getCarR().getCodeV());
    }

    public void restRefClient(int code) {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getCodeP() == code) {
                listClients.get(i).setRefP(listClients.get(i).getRefP() - 1);
            }
        }
    }

    public void restRefCar(int code) {
        if (firstC.getCodeV() == code) {
            firstC.setRefV(firstC.getRefV() - 1);
        } else {
            restRefCar(firstC.getNext(), code);
        }
    }

    private void restRefCar(Car current, int code) {
        if (current.getCodeV() == code) {
            current.setRefV(current.getRefV() - 1);
        } else {
            plusRefCar(current.getNext(), code);
        }
    }

    public Card addCard(int cSegurity, double balance, String namePay, double ammountPay) throws Payed {
        if (balance >= ammountPay) {
            Card newCard = new Card(cSegurity, balance, namePay);
            return newCard;
        } else {
            throw new Payed(balance, ammountPay);
        }
    }

    public Money addMoney(double valueMoney, String namePay, double ammountPay) throws Payed {
        if (valueMoney >= ammountPay) {
            Money newMoney = new Money(valueMoney, namePay);
            return newMoney;
        } else {
            throw new Payed(valueMoney, ammountPay);
        }
    }

    //********************** Algoritmos de ordenamiento *******************\\
    public void sortIDClient() {
        Comparator<Client> employeeComparator = new Comparator<Client>() {
            @Override
            public int compare(Client e1, Client e2) {
                String e1String = e1.getId() + "";
                return e1String.compareTo(e2.getId() + "");
            }
        };
        Collections.sort(listClients, employeeComparator);
    }

    //******* Inserction *************\\
    public List<Employee> sortIDEmployee() {
        List<Employee> sortEmployee;
        sortEmployee = showRootName;
        for (int i = 1; i < sortEmployee.size(); i++) {
            for (int j = i; j > 0 && sortEmployee.get(j - 1).getId() > sortEmployee.get(j).getId(); j--) {
                Employee temp = sortEmployee.get(i);
                sortEmployee.set(j, sortEmployee.get(j - 1));
                sortEmployee.set(j - 1, temp);
            }
        }
        return sortEmployee;
    }

    //Bubble Sort
    public List<Employee> sortComisionEmployee() {
        List<Employee> sortEmployee;
        sortEmployee = showRootName;
        for (int i = 1; i < sortEmployee.size(); i++) {
            for (int j = 0; j < sortEmployee.size() - i; j++) {
                if (sortEmployee.get(j).getNSold() < sortEmployee.get(j + 1).getNSold()) {
                    Employee temp = sortEmployee.get(j);
                    sortEmployee.set(j, sortEmployee.get(j + 1));
                    sortEmployee.set(j + 1, temp);
                }
            }
        }
        return sortEmployee;
    }

    //Selection sort
    public List<Rent> sortRentIDClient() {
        List<Rent> sortRentID;
        sortRentID = listRents;
        for (int i = 0; i < sortRentID.size() - 1; i++) {
            Rent menor = sortRentID.get(i);
            int cual = i;
            for (int j = i + 1; j < sortRentID.size(); j++) {
                if (sortRentID.get(j).getClientR().getId() < menor.getClientR().getId()) {
                    menor = sortRentID.get(j);
                    cual = j;
                }
            }
            Rent temp = sortRentID.get(i);
            sortRentID.set(i, menor);
            sortRentID.set(cual, temp);
        }
        return sortRentID;
    }

    public List<Rent> sortRentTicket() {
        List<Rent> sortRentTicket;
        sortRentTicket = listRents;
        for (int i = 0; i < sortRentTicket.size() - 1; i++) {
            Rent menor = sortRentTicket.get(i);
            int cual = i;
            for (int j = i + 1; j < sortRentTicket.size(); j++) {
                if (sortRentTicket.get(j).getTicket() < menor.getTicket()) {
                    menor = sortRentTicket.get(j);
                    cual = j;
                }
            }
            Rent temp = sortRentTicket.get(i);
            sortRentTicket.set(i, menor);
            sortRentTicket.set(cual, temp);
        }
        return sortRentTicket;
    }

    //******************** Busqueda Binaria *****************\\
    public List<Client> binaryClient(boolean out, String name) {
        List<Client> selectedClient = new ArrayList<>();
        if (out) {
            for (int i = 0; i < listClients.size(); i++) {
                if (listClients.get(i).getName().equalsIgnoreCase(name)) {
                    selectedClient.add(listClients.get(i));
                }
            }
        } else {
            sortIDClient();
            long Id = Long.parseLong(name);
            int pos = -1;
            int i = 0;
            int j = listClients.size() - 1;
            while (i <= j && pos < 0) {
                int m = (i + j) / 2;
                if (listClients.get(m).getId() == Id) {
                    selectedClient.add(listClients.get(m));
                    pos = m;
                } else if (listClients.get(m).getId() > Id) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
        }
        return selectedClient;
    }

    //***************** Binary Employee **********************\\
    public List<Employee> binaryEmployee(boolean out, String name) {
        List<Employee> selectedEmployee = new ArrayList<>();
        if (out) {
            for (int i = 0; i < showRootName.size(); i++) {
                if (showRootName.get(i).getName().equalsIgnoreCase(name)) {
                    selectedEmployee.add(showRootName.get(i));
                }
            }
        } else {
            List<Employee> arraySortID;
            arraySortID = sortIDEmployee();
            long Id = Long.parseLong(name);
            int pos = -1;
            int i = 0;
            int j = arraySortID.size() - 1;
            while (i <= j && pos < 0) {
                int m = (i + j) / 2;
                if (arraySortID.get(m).getId() == Id) {
                    selectedEmployee.add(arraySortID.get(m));
                    pos = m;
                } else if (arraySortID.get(m).getId() > Id) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
        }
        return selectedEmployee;
    }

    public List<City> searchCityName(String name) {
        Collections.sort(listCities);
        List<City> selectedCity = new ArrayList<>();
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getNameCi().equalsIgnoreCase(name)) {
                selectedCity.add(listCities.get(i));
            }
        }
        return selectedCity;
    }

    public List<Brand> searchBrandName(String name) {
        Collections.sort(listBrands);
        List<Brand> selectedBrand = new ArrayList<>();
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getNameTB().equalsIgnoreCase(name)) {
                selectedBrand.add(listBrands.get(i));
            }
        }
        return selectedBrand;
    }

    public List<TypeV> searchTypeName(String name) {
        Collections.sort(listTypeV);
        List<TypeV> selectedType = new ArrayList<>();
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getNameTB().equalsIgnoreCase(name)) {
                selectedType.add(listTypeV.get(i));
            }
        }
        return selectedType;
    }

    public List<Car> searchPlateVehicle(String plate) {
        Collections.sort(showRootCar);
        List<Car> selectedCar = new ArrayList<>();
        for (int i = 0; i < showRootCar.size(); i++) {
            if (showRootCar.get(i).getPlate().equalsIgnoreCase(plate)) {
                selectedCar.add(showRootCar.get(i));
            }
        }
        return selectedCar;
    }

    public List<Rent> searchPlateVehicle(int ticket, List<Rent> sortRent) {
        return null;
    }

    public List<Rent> searchIDCR(long id, List<Rent> sortRent) {
        List<Rent> selectedRent = new ArrayList<>();
        for (int i = 0; i < sortRent.size(); i++) {
            if (sortRent.get(i).getClientR().getId() == id) {
                selectedRent.add(sortRent.get(i));
            }
        }
        return selectedRent;
    }

    //***************** Binary Rent **********************\\
    public List<Rent> binaryRent(int ticket, List<Rent> sortRent) {
        List<Rent> selectedRent = new ArrayList<>();
        int pos = -1;
        int i = 0;
        int j = sortRent.size() - 1;
        while (i <= j && pos < 0) {
            int m = (i + j) / 2;
            if (sortRent.get(m).getTicket() == ticket) {
                selectedRent.add(sortRent.get(m));
                pos = m;
            } else if (sortRent.get(m).getTicket() > ticket) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return selectedRent;
    }

    //***************** Export Client *****************\\
    public void exportClient(boolean out, City city, String filename) throws FileNotFoundException {
        List<Client> clientsExport = new ArrayList<>();
        String msg;
        if (out) {
            for (int i = 0; i < listClients.size(); i++) {
                clientsExport.add(listClients.get(i));
            }
            msg = "Reportes de todos los clientes";
        } else {
            for (int i = 0; i < listClients.size(); i++) {
                if (listClients.get(i).getCityC().getCodeCi() == city.getCodeCi()) {
                    clientsExport.add(listClients.get(i));
                }
            }
            msg = "Reportes de clientes filtrado por la ciudad de " + city.getNameCi();
        }
        writeClient(clientsExport, filename, msg);
    }

    public void writeClient(List<Client> clients, String filename, String msg) throws FileNotFoundException {
        int count = 1;
        PrintWriter pw = new PrintWriter(filename);
        pw.println("Sistema de reportes RentingCar");
        pw.println(msg);
        pw.println("Fecha: " + LocalDate.now());
        for (int i = 0; i < clients.size(); i++) {
            pw.println("-------------------------------------------------");
            pw.println("Cliente en factura No. " + count);
            count++;
            pw.println("Codigo: " + clients.get(i).getCodeP() + "\nCedula: " + clients.get(i).getId() + "\nNombre: " + clients.get(i).getName()
                    + "\nApellido: " + clients.get(i).getLastName() + "\nTelefono: " + clients.get(i).getPhoneC()
                    + "\nDirección: " + clients.get(i).getAddressC() + "\nEmail: " + clients.get(i).getEmailC() + "\nCiudad :" + clients.get(i).getNameCity());
        }
        pw.println("-------------------------------------------------");
        pw.println("Factura termianda");
        pw.println("Total de clientes exportados " + clients.size());
        pw.close();
    }

    //***************** Export Vehicle *****************\\
    public void exportVehicle(boolean out, TypeV typeV, String filename) throws FileNotFoundException {
        List<Car> carsExport = new ArrayList<>();
        String msg;
        if (out) {
            for (int i = 0; i < showRootCar.size(); i++) {
                carsExport.add(showRootCar.get(i));
            }
            msg = "Reportes de todos los carros";
        } else {
            for (int i = 0; i < showRootCar.size(); i++) {
                if (showRootCar.get(i).getTypeV().getCodeA() == typeV.getCodeA()) {
                    carsExport.add(showRootCar.get(i));
                }
            }
            msg = "Reportes de carros filtrado por la ciudad de " + typeV.getNameTB();
        }
        writeCar(carsExport, filename, msg);
    }

    public void writeCar(List<Car> cars, String filename, String msg) throws FileNotFoundException {
        int count = 1;
        PrintWriter pw = new PrintWriter(filename);
        pw.println("Sistema de reportes RentingCar");
        pw.println(msg);
        pw.println("Fecha: " + LocalDate.now());
        for (int i = 0; i < cars.size(); i++) {
            pw.println("-------------------------------------------------");
            pw.println("Carro en factura No. " + count);
            count++;
            pw.println("Codigo: " + cars.get(i).getCodeV() + "\nPlaca: " + cars.get(i).getPlate() + "\nTipo de carro: " + cars.get(i).getNameType()
                    + "\nModelo: " + cars.get(i).getModel() + "\nColor: " + cars.get(i).getColor() + "\nMarca: " + cars.get(i).getNameBrand()
                    + "\nPrecio por día: " + cars.get(i).getPriceXDay() + "\nAño: " + cars.get(i).getYear());
        }
        pw.println("-------------------------------------------------");
        pw.println("Factura termianda");
        pw.println("Total de carros exportados " + cars.size());
        pw.close();
    }

    //***************** Export Rent *****************\\
    public void exportRent(boolean out, LocalDate init, LocalDate end, String filename) throws FileNotFoundException {
        List<Rent> rentsExport = new ArrayList<>();
        for (int i = 0; i < listRents.size(); i++) {
            uptadeStatRent(listRents.get(i).getCodeR());
        }
        String msg;
        if (out) {
            for (int i = 0; i < listRents.size(); i++) {
                rentsExport.add(listRents.get(i));
            }
            msg = "Reportes de todas las rentas";
        } else {
            for (int i = 0; i < listRents.size(); i++) {
                if((init.isBefore(listRents.get(i).getFinitial()) || init.equals(listRents.get(i).getFinitial())) 
                        && (end.isAfter(listRents.get(i).getFfinal()) || end.equals(listRents.get(i).getFfinal()))){
                    rentsExport.add(listRents.get(i));
                    System.out.println("Sapa hpta");
                }
            }
            msg = "Reportes de rentas filtradas por fechas\nFecha inicial: "+init.toString()
                    +"\nFecha final: "+end.toString();
        }
        writeRent(rentsExport, filename, msg);
    }

    public void writeRent(List<Rent> rents, String filename, String msg) throws FileNotFoundException {
        int count = 1;
        PrintWriter pw = new PrintWriter(filename);
        pw.println("Sistema de reportes RentingCar");
        pw.println(msg);
        pw.println("Fecha Actual: " + LocalDate.now());
        for (int i = 0; i < rents.size(); i++) {
            pw.println("-------------------------------------------------");
            pw.println("Renta en factura No. " + count);
            count++;
            pw.println("Codigo: " + rents.get(i).getCodeR() + "\nTicket: TRC" + rents.get(i).getTicket() + "\nFecha inicial: "+rents.get(i).getFinitial().toString()
                    + "\nFecha final: " + rents.get(i).getFfinal()+"\nCedula del cliente: " + rents.get(i).getIdClient()
                    + "\nNombre del cliente: " + rents.get(i).getNameClient() + "\nTelefono del cliente: " + rents.get(i).getPhoneClient() 
                    + "\nID vehiculo: " + rents.get(i).getIdCar() + "\nPlaca del vehículo: " + rents.get(i).getPlateCar() 
                    + "\nTipo de Carro: " + rents.get(i).getCarR().getNameType() + "\nMarca: " + rents.get(i).getCarR().getNameBrand()
                    + "\nPrecio por día: " + rents.get(i).getCarR().getPriceXDay() + "\nDias de prestamo: " + rents.get(i).getDays()
                    + "\nSubTotal: " + rents.get(i).getDays()*rents.get(i).getCarR().getPriceXDay()+"\nDías de atrazo: "+rents.get(i).getDelay() + "\nEstado: " + rents.get(i).getStatus()
                    + "\nMulta: " + rents.get(i).getMult() + "\nTotal a pagar: " + rents.get(i).getPriceTotal());
        }
        pw.println("-------------------------------------------------");
        pw.println("Factura termianda");
        pw.println("Total de rentas exportados " + rents.size());
        pw.close();
    }
    
    public String calculateCategorySpeed(int velocity) {
        String msg = "El vehiculo con velocidad " + velocity + " entra en la categoria de: ";
        if (velocity < 100) {
            msg += "Casual";
        } else if (velocity < 200) {
            msg += "Exotico";
        } else if (velocity < 300) {
            msg += "Deportivo";
        } else {
            msg += "Corsa";
        }
        return msg;
    }
}
