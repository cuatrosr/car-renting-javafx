package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import exception.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import javafx.stage.FileChooser;

public class RentingCar implements Serializable {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the rentingCar class ----------------------------\\
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

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * RentingCar class constructor, initialize all relations.
     */
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

    //-------------------------- Gestion employee, add and login --------------------------\\
    /**
     * Create a employee and add in the linkedlist
     *
     * @param username employee's username, a string not null
     * @param password employee's password, a string not null
     * @param nSold employee's amount of sold = 0
     * @param vComision employee's value of comision = 0
     * @param codeP employee's code
     * @param refP employee's reference = 0
     * @param name employee's name, a string not null
     * @param lastName employee's, a string not null
     * @param id employee's id, a long not null.
     */
    public void addEmployee(String username, String password, int nSold, double vComision, int codeP, int refP, String name, String lastName, long id) {
        Employee emp = new Employee(username, password, nSold, vComision, code++, refP, name, lastName, id);
        addEmp(emp);
    }

    /**
     * Add employe whit recurive.
     *
     * @param emp employee to add to linkedlist
     */
    public void addEmp(Employee emp) {
        if (firstE == null) {
            firstE = emp;
            empActive = firstE;
            addBinaryEmployee(emp);
        } else {
            addEmp(emp, firstE);
        }
    }

    /**
     * Support to add employe with recursive.
     *
     * @param emp employee to add to linkedlist
     * @param current next employe, if this is null, add, if isn't null to pass
     * next.
     */
    private void addEmp(Employee emp, Employee current) {
        if (current.getNext() == null) {
            current.setNext(emp);
            empActive = emp;
            addBinaryEmployee(emp);
        } else {
            addEmp(emp, current.getNext());
        }
    }

    /**
     * Check if the username and password are correct with recursive.
     *
     * @param userName employee's username
     * @param password employee's password
     * @return
     */
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

    /**
     * Suport to check the username and passoword with recursive.
     *
     * @param current next employee
     * @param userName employee's username
     * @param password employee's password
     * @return
     */
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

    //-------------------------- Add employee to binary tree --------------------------\\
    /**
     * Add employee to binary tree with recursive.
     *
     * @param nextTest employee to add to tree
     */
    public void addBinaryEmployee(Employee nextTest) {
        if (rootNameE == null) {
            rootNameE = nextTest;
        } else {
            addBinaryEmployee(rootNameE, nextTest);
        }
    }

    /**
     * Suport to add employee to add, with recursive
     *
     * @param current employee to compare
     * @param next employee to add
     */
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

    /**
     * Convert the binary tree to arraylist in the employee
     *
     * @param root root of the binary tree
     */
    public void showBinaryTreeNameEmployee(Employee root) {
        if (root != null) {
            showBinaryTreeNameEmployee(root.getLeft());
            showRootName.add(root);
            showBinaryTreeNameEmployee(root.getRight());
        }
    }

    //-------------------------- Gestion City --------------------------\\
    /**
     * Add a city to the list, the city must have a different name of the other
     * cities.
     *
     * @param codeCi city's code
     * @param nameCi city's name, a string not null
     * @param refCi city's reference = 0
     * @return boolean to know if the city was added orn ot
     */
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

    /**
     * Update the city, the city's name must be different of the other city
     *
     * @param code city's code
     * @param name city's name, a string not null to update.
     * @return boolean to know if the city was updated or not
     */
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

    /**
     * Remove a city, this city must have the reference equals to 0
     *
     * @param code city's code
     * @throws Reference
     */
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

    //-------------------------- Gestion Type vehicle --------------------------\\
    /**
     * add a type of vehicle to the list, the type must have a different name
     * and quality of the other type of vehicle
     *
     * @param quality typev's quality, a integer
     * @param refTv typev's reference = 0
     * @param codeA typev's code
     * @param nameTB typev's name, a string not null
     * @return boolean to know if the type was added or not
     */
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

    /**
     * Update the type, the type's name and quality must be different of the
     * other type
     *
     * @param code type's code
     * @param name typev's name, a string not null
     * @param quality typev's quality, a integer
     * @return boolean to know if the type was updated
     */
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

    /**
     * Remove a type, this type must have the reference equals to 0
     *
     * @param code typev's code
     * @throws Reference
     */
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

    //-------------------------- Gestion Brand  --------------------------\\
    /**
     * Add a brand to the list, the brand must have a different name and country
     * of the other brand
     *
     * @param country brand's country, a string not null
     * @param refB brand's reference = 0
     * @param codeA brand's code
     * @param nameTB brand's name, a string not null
     * @return boolean to know if the brand was added
     */
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

    /**
     * Update the brand, the brand's name and country must be differetn of the
     * other brand
     *
     * @param code brand's code
     * @param name brand's name, a string not null
     * @param country brand's country, a string not null
     * @return boolean to know if the brand was updated
     */
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

    /**
     * Remove a brand, this brand must have the reference equals to 0
     *
     * @param code brand's code
     * @throws Reference
     */
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

    //-------------------------- Gestion Client  --------------------------\\
    /**
     * Add a client to the list, the client must have a different id to the
     * other client
     *
     * @param addressC client's address, a string not null
     * @param phoneC client's phone, a long not null
     * @param emailC client's email, a string that contains a @ in the string
     * @param cityC clients city, a city not null in the list cities
     * @param codeP client's code
     * @param refP client's reference = 0
     * @param name client's name, a string not null
     * @param lastName client's last name, a string not null
     * @param id client's identification, a long not null
     * @return boolean to know if the client was added or not
     * @throws Email
     */
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
                    if (cityC != null) {
                        plusRefCity(cityC);
                    }
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

    /**
     * Find a city to vincule with a client
     *
     * @param nameCity city's name, this city get of combobox.
     * @return City selectedif the city was not found return null
     */
    public City findCitySelected(String nameCity) {
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getNameCi().equals(nameCity)) {
                return listCities.get(i);
            }
        }
        return null;
    }

    /**
     * Plus reference in city vincule to client
     *
     * @param cityPlus client's city to plus its reference
     */
    public void plusRefCity(City cityPlus) {
        for (int i = 0; i < listCities.size(); i++) {
            if (listCities.get(i).getCodeCi() == cityPlus.getCodeCi()) {
                listCities.get(i).setRefCi(listCities.get(i).getRefCi() + 1);
            }
        }
    }

    /**
     * Update the client, the client's id must be different to other client's id
     * to update
     *
     * @param addressC client's address, a string not null
     * @param phoneC client's phone, a long not null
     * @param emailC client's email, a string that contains one @
     * @param cityC client's city, a city not null
     * @param code client's code
     * @param name client's name, a string not null
     * @param lastName client's list name, a string not null
     * @param id client's identification, a long not null
     * @return boolean to know if the client was updated or not
     * @throws Email
     */
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

    /**
     * Rest reference in city vincule to client
     *
     * @param city ex client's city to rest its reference
     */
    public void restRefCity(City city) {
        for (int j = 0; j < listCities.size(); j++) {
            if (listCities.get(j) == city) {
                listCities.get(j).setRefCi(listCities.get(j).getRefCi() - 1);
            }
        }
    }

    /**
     * Remove the client, this client must have the reference equals to 0
     *
     * @param code client's code
     * @throws Reference
     */
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

    //-------------------------- Gestion Car  --------------------------\\
    /**
     * Add a car to the linked list, the car's plate must be different to other
     * car's plate, recursive
     *
     * @param model car's model, a string not null
     * @param color car's color, a string not null
     * @param brand car's brand, a brand from the listbrands, not null
     * @param typeV car's type, a type from the listType, not null
     * @param priceXDay car's price for day, a double not null
     * @param codeV car's code
     * @param plate car's plate, a string not null
     * @param dispV car's disponibility, a boolean
     * @param photo car's photo, a string from a path
     * @param year car's year, a integer not null
     * @return
     */
    public boolean addCar(String model, String color, Brand brand, TypeV typeV, double priceXDay, int codeV, String plate, boolean dispV, String photo, int year) {
        if (!searchPlate(plate)) {
            Car newCar = new Car(model, color, brand, typeV, priceXDay, code++, plate, dispV, photo, year, 0);
            if (brand != null && typeV != null) {
                plusRefBrand(brand);
                plusRefTypeV(typeV);
            }
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

    /**
     * Support to add car to the linked list, recursive
     *
     * @param current car next to set its next
     * @param newCar car to add
     * @return
     */
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

    /**
     * Search a plate to know if this plate is repeat in other car, with
     * recursive
     *
     * @param plate car's plate, a string not null
     * @return boolean to know if the plate is repeat or not
     */
    public boolean searchPlate(String plate) {
        if (firstC == null) {
            return false;
        } else {
            return searchPlate(plate, firstC);
        }
    }

    /**
     * Suport to search a plate, recursive
     *
     * @param plate car's plate, a string not null
     * @param current next car to compare its plate
     * @return boolean to know if the plate is repeat or not
     */
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

    /**
     * Find a type of vehicle to vincule with a car
     *
     * @param nameTypeV type's name to search
     * @return car selected if the car was not found return null
     */
    public TypeV findTypeVSelected(String nameTypeV) {
        String[] nameSplit = nameTypeV.split(" ");
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getNameTB().equals(nameSplit[0]) && listTypeV.get(i).getQuality() == Integer.parseInt(nameSplit[1])) {
                return listTypeV.get(i);
            }
        }
        return null;
    }

    /**
     * Plus reference type vincule to car
     *
     * @param typeVPlus car's type, a type from the list types
     */
    public void plusRefTypeV(TypeV typeVPlus) {
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getCodeA() == typeVPlus.getCodeA()) {
                listTypeV.get(i).setRefTv(listTypeV.get(i).getRefTv() + 1);
            }
        }
    }

    /**
     * Rest reference type vincule to car
     *
     * @param typeVRest ex car's type, a type from the list type
     */
    public void restRefType(TypeV typeVRest) {
        for (int i = 0; i < listTypeV.size(); i++) {
            if (listTypeV.get(i).getCodeA() == typeVRest.getCodeA()) {
                listTypeV.get(i).setRefTv(listTypeV.get(i).getRefTv() - 1);
            }
        }
    }

    /**
     * Find a brand to vincule with a car
     *
     * @param nameBrand brand's name to search
     * @return brand selected, if the brand selecte was not found return null
     */
    public Brand findBrandSelected(String nameBrand) {
        String[] nameSplit = nameBrand.split(" ");
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getNameTB().equals(nameSplit[0]) && listBrands.get(i).getCountry().equals(nameSplit[1])) {
                return listBrands.get(i);
            }
        }
        return null;
    }

    /**
     * Plus reference brand vincule to car
     *
     * @param brandPlus car's brand, a brand from the list brands
     */
    public void plusRefBrand(Brand brandPlus) {
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getCodeA() == brandPlus.getCodeA()) {
                listBrands.get(i).setRefB(listBrands.get(i).getRefB() + 1);
            }
        }
    }

    /**
     * Rest reference brand vincule to car
     *
     * @param brandRest ex car's brand, a brand from the list brands
     */
    public void restRefBrand(Brand brandRest) {
        for (int i = 0; i < listBrands.size(); i++) {
            if (listBrands.get(i).getCodeA() == brandRest.getCodeA()) {
                listBrands.get(i).setRefB(listBrands.get(i).getRefB() - 1);
            }
        }
    }

    /**
     * Update a car, car's plate must be differnte to the othre car's plates,
     * recursive
     *
     * @param code car's car's
     * @param model car's model, a string not null
     * @param color car's color, a string not null
     * @param brand car's brand, a brand from the list brand
     * @param typeV car's tuype, a type from the list type
     * @param priceXDay car's price for day, a double not null
     * @param plate car's plate, a stirng not null
     * @param dispV car's disponibility, a boolean
     * @param photo car's photo, a string from a path
     * @param year car's year, a integer not null
     * @return boolean to know if the car was updated or not
     */
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

    /**
     * Verify if the new car's plate is the same as the new one, recurive
     *
     * @param code car's code
     * @return car's plate
     */
    public String verifySameCar(int code) {
        if (firstC == null) {
            return "";
        } else {
            return verifySameCar(code, firstC);
        }
    }

    /**
     * Support to verify the plates, recursive
     *
     * @param code car's code
     * @param current next car to verify
     * @return car's plate
     */
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

    /**
     * Remove the car from the linked list, the car must have its reference
     * equals to 0, recurive
     *
     * @param code car's code
     * @throws Reference
     */
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

    //-------------------------- Add car to binary tree --------------------------\\
    /**
     * Add a car to the binary tree, recursive
     *
     * @param f car to add to tree
     */
    public void addBinaryVehicle(Car f) {
        if (rootNameC == null) {
            rootNameC = f;
        } else {
            addBinaryVehicle(rootNameC, f);
        }
    }

    /**
     * Suport add car to binary tree, recursive
     *
     * @param current car to comapre with the new car
     * @param next new car to add to tree
     */
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

    /**
     * Convert the binary tree to arraylist in the car
     *
     * @param root binary tree's root
     */
    public void showBinaryTreeVehicle(Car root) {
        if (root != null) {
            showBinaryTreeVehicle(root.getLeft());
            showRootCar.add(root);
            showBinaryTreeVehicle(root.getRight());
        }
    }

    /**
     * Find a vehicle according to its position, next.
     *
     * @param position car's position in the linked list
     * @return car find, if the car was not found return null
     */
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

    /**
     * Find a vehicle accorgin to its position, prev.
     *
     * @param position car's position in the linked list
     * @return caf ind, if the car was not found return null
     */
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

    /**
     * Remove the car from the binary tree, the car must have its reference
     * equasl to 0, recursive
     *
     * @param code car's code
     * @throws Reference
     */
    public void removeCarBinaryTree(int code) throws Reference {
        Car rCar = findCar(code);
        if (rCar.getRefV() == 0) {
            removeCarBinaryTree(rCar);
        } else {
            throw new Reference(rCar.getRefV());
        }
    }

    /**
     * Support to remove a car, recursive
     *
     * @param rmvCar car to remove
     */
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

    /**
     * Get the minimous plate car, recursive
     *
     * @param current car minimous
     * @return car to settear
     */
    private Car min(Car current) {
        if (current.getLeft() == null) {
            return current;
        } else {
            return min(current.getLeft());
        }
    }

    /**
     * Find a car according to its code, recursive
     *
     * @param code code to find car, a integer
     * @return car found
     */
    public Car findCar(int code) {
        if (firstC.getCodeV() == code) {
            return firstC;
        } else {
            return findCar(code, firstC.getNext());
        }
    }

    /**
     * Support a find car, recursive
     *
     * @param code code to find car, a integer
     * @param next next car to compare and find
     * @return car found
     */
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

    //-------------------------- Gestion Rent --------------------------\\
    /**
     * Add a rent, the rent final date must be bigger than the first date, the
     * client and the car aren't null
     *
     * @param codeR rent's code
     * @param ticket rent's ticket, a integer not null
     * @param clientR rent's client, a client not null from the list clients
     * @param carR rent's car, a client not null form the linked list car
     * @param Finitial rent's initial date, a local date not null, localdate now
     * @param Ffinal rent's final date, a local date not null
     * @param days rent's days, difference between initial date and final date
     * @param status rent's status, stat like as deffered, expire today, expire,
     * paid
     * @param delay rent's dalay, if the date now is bigger than the final date,
     * rest between these dates
     * @param mult rent's mult, days of dealy for the car's price
     * @param priceTotal rent's price total, the value to pay
     * @return boolean to know if the rent was added or not
     */
    public boolean addRent(int codeR, int ticket, Client clientR, Car carR, LocalDate Finitial, LocalDate Ffinal, int days, Status status, int delay, int mult, int priceTotal) {
        if (days > 0) {
            if (clientR == null || carR == null) {
                return false;
            } else {
                Rent newRent = new Rent(code++, codeTicket++, clientR, carR, Finitial, Ffinal, days, status, delay, mult, priceTotal);
                listRents.add(newRent);
                plusComisionEmployeeEnlazada();
                plusRefClients(clientR.getCodeP());
                plusRefCar(carR.getCodeV());
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Search a client to add in a rent
     *
     * @param code client's code to search
     * @return client selected
     */
    public Client searchClientSelected(int code) {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getCodeP() == code) {
                return listClients.get(i);
            }
        }
        return null;
    }

    /**
     * Plus commision to employee active if this do a rent in the linked list,
     * recursive.
     */
    public void plusComisionEmployeeEnlazada() {
        if (empActive.getCodeP() == firstE.getCodeP()) {
            firstE.setnSold(firstE.getNSold() + 1);
        } else {
            plusComisionEmployee(firstE.getNext());
        }
    }

    /**
     * Support to plus comision in employee active
     *
     * @param current next employee
     */
    private void plusComisionEmployee(Employee current) {
        if (current.getCodeP() == empActive.getCodeP()) {
            current.setnSold(current.getNSold() + 1);
        } else {
            plusComisionEmployee(current.getNext());
        }
    }

    /**
     * Plus reference client in the rent
     *
     * @param code client's code in the rent
     */
    public void plusRefClients(int code) {
        for (int i = 0; i < listCities.size(); i++) {
            if (listClients.get(i).getCodeP() == code) {
                listClients.get(i).setRefP(listClients.get(i).getRefP() + 1);
            }
        }
    }

    /**
     * Plus reference car in the rent, recursive
     *
     * @param code car's code in the rent
     */
    public void plusRefCar(int code) {
        if (firstC.getCodeV() == code) {
            firstC.setRefV(firstC.getRefV() + 1);
        } else {
            plusRefCar(firstC.getNext(), code);
        }
    }

    /**
     * Support to plus reference.
     *
     * @param current next car
     * @param code car's code in the rent
     */
    private void plusRefCar(Car current, int code) {
        if (current.getCodeV() == code) {
            current.setRefV(current.getRefV() + 1);
        } else {
            plusRefCar(current.getNext(), code);
        }
    }

    /**
     * Find a rent in the list rent according a code
     *
     * @param code rent's code to find
     * @return rent found
     */
    public Rent findRentSelected(int code) {
        for (int i = 0; i < listRents.size(); i++) {
            if (listRents.get(i).getCodeR() == code) {
                return listRents.get(i);
            }
        }
        return null;
    }

    /**
     * Update the stat of the rent according the rent
     *
     * @param code rent's code to update stat
     */
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

    /**
     * Update the stat of the rent according the days, set the mult and delay
     *
     * @param rentSelected rent to update stat
     * @param days amount of day, rest between final date and now date
     */
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

    /**
     * Pay a rent according its code
     *
     * @param code rent's code to pay
     */
    public void payRent(int code) {
        findRentSelected(code).setStatus(Status.PAID);
        restRefClient(findRentSelected(code).getClientR().getCodeP());
        restRefCar(findRentSelected(code).getCarR().getCodeV());
    }

    /**
     * Rest client in the rent paid
     *
     * @param code client's code in the rent
     */
    public void restRefClient(int code) {
        for (int i = 0; i < listClients.size(); i++) {
            if (listClients.get(i).getCodeP() == code) {
                listClients.get(i).setRefP(listClients.get(i).getRefP() - 1);
            }
        }
    }

    /**
     * Rest car in the rent paid, recursive
     *
     * @param code car's code in the rent
     */
    public void restRefCar(int code) {
        if (firstC.getCodeV() == code) {
            firstC.setRefV(firstC.getRefV() - 1);
        } else {
            restRefCar(firstC.getNext(), code);
        }
    }

    /**
     * Support to rest car in the rent paid, recursive
     *
     * @param current next car
     * @param code car's code in the rent
     */
    private void restRefCar(Car current, int code) {
        if (current.getCodeV() == code) {
            current.setRefV(current.getRefV() - 1);
        } else {
            plusRefCar(current.getNext(), code);
        }
    }

    /**
     * Add card to pay a rent selecetd
     *
     * @param cSegurity car's segurity code, a interger not null
     * @param balance car's value of moneu, a double not null
     * @param namePay car's name person to pay
     * @param ammountPay rent's total value
     * @return Car to know if the pay was correct
     * @throws Payed
     */
    public Card addCard(int cSegurity, double balance, String namePay, double ammountPay) throws Payed {
        if (balance >= ammountPay) {
            Card newCard = new Card(cSegurity, balance, namePay);
            return newCard;
        } else {
            throw new Payed(balance, ammountPay);
        }
    }

    /**
     * Add Money to pay a rent selected
     *
     * @param valueMoney money value
     * @param namePay person to pay
     * @param ammountPay rent's total value
     * @return Money to know if the pay was corred
     * @throws Payed
     */
    public Money addMoney(double valueMoney, String namePay, double ammountPay) throws Payed {
        if (valueMoney >= ammountPay) {
            Money newMoney = new Money(valueMoney, namePay);
            return newMoney;
        } else {
            throw new Payed(valueMoney, ammountPay);
        }
    }

    //-------------------------- Sorting algorithms --------------------------\\
    /*
    Sort Client's id, Comparable
     */
    public void sortIDClient() {
        @SuppressWarnings("Convert2Lambda")
        Comparator<Client> employeeComparator = new Comparator<Client>() {
            @Override
            public int compare(Client e1, Client e2) {
                String e1String = e1.getId() + "";
                return e1String.compareTo(e2.getId() + "");
            }
        };
        Collections.sort(listClients, employeeComparator);
    }

    /**
     * Sort Employee's Id, inserction
     *
     * @return a sort ID client arraylist
     */
    public List<Employee> sortIDEmployee() {
        List<Employee> sortEmployee = new ArrayList<>();
        for (int i = 0; i < showRootName.size(); i++) {
            sortEmployee.add(showRootName.get(i));
        }
        for (int i = 1; i < sortEmployee.size(); i++) {
            for (int j = i; j > 0 && sortEmployee.get(j - 1).getId() > sortEmployee.get(j).getId(); j--) {
                Employee temp = sortEmployee.get(j);
                sortEmployee.set(j, sortEmployee.get(j - 1));
                sortEmployee.set((j - 1), temp);
            }
        }
        return sortEmployee;
    }

    /**
     * Sort Employee's comision, Bubble
     *
     * @return a sort Comision employee ArrayList
     */
    public List<Employee> sortComisionEmployee() {
        List<Employee> sortEmployeeComision = new ArrayList<>();
        for (int i = 0; i < showRootName.size(); i++) {
            sortEmployeeComision.add(showRootName.get(i));
        }
        for (int i = 1; i < sortEmployeeComision.size(); i++) {
            for (int j = 0; j < sortEmployeeComision.size() - i; j++) {
                if (sortEmployeeComision.get(j).getNSold() < sortEmployeeComision.get(j + 1).getNSold()) {
                    Employee temp = sortEmployeeComision.get(j);
                    sortEmployeeComision.set(j, sortEmployeeComision.get(j + 1));
                    sortEmployeeComision.set(j + 1, temp);
                }
            }
        }
        return sortEmployeeComision;
    }

    /**
     * Sort Rent's Id, Selection
     *
     * @return a sort Id Client Rent ArrayList
     */
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

    /**
     * Sort Rent's ticket, Selecction
     *
     * @return a sort Rent ticket arraylist
     */
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

    //-------------------------- Binary Search, and search --------------------------\\
    /**
     * Binary search in the client, search for name and id
     *
     * @param out centinel to know if the search is for name or id
     * @param name param to search
     * @return a arrayList with elements search
     */
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

    /**
     * Binary search in the employee search for name and id
     *
     * @param out centinel to know if the search is for name or id
     * @param name param to search
     * @return a arrayList with elements search
     */
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

    /**
     * Search cities for name
     *
     * @param name param to search
     * @return a arraylist with elements search
     */
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

    /**
     * Search brands for name
     *
     * @param name param to search
     * @return a arraylist with elements search
     */
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

    /**
     * Search types for name
     *
     * @param name param to search
     * @return a arraylist with elements search
     */
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

    /**
     * Search cars for plate
     *
     * @param name param to search
     * @return a arraylist with elements search
     */
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

    /**
     * Search rents for client's id
     *
     * @param id param to search
     * @param sortRent sort ArrayList
     * @return
     */
    public List<Rent> searchIDCR(long id, List<Rent> sortRent) {
        List<Rent> selectedRent = new ArrayList<>();
        for (int i = 0; i < sortRent.size(); i++) {
            if (sortRent.get(i).getClientR().getId() == id) {
                selectedRent.add(sortRent.get(i));
            }
        }
        return selectedRent;
    }

    /**
     * Binary Search rents for ticket
     *
     * @param ticket param to search
     * @param sortRent sort Arraylist
     * @return rents searched
     */
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

    //-------------------------- Export elements --------------------------\\
    /**
     * Export clients, all clients or clients filter for city
     * @param out centinel to know if the export all of filter it.
     * @param city city to filter
     * @param filename file to save the information
     * @throws FileNotFoundException 
     */
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

    /**
     * Write the information in the file
     * @param clients clients to export
     * @param filename file to save the information
     * @param msg a string to show in the information file
     * @throws FileNotFoundException 
     */
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

    /**
     * Export vehicles, all vehicles or vehicles filter for type
     * @param out centiniel to know if the export all of filter it
     * @param typeV type to filter
     * @param filename file to save the information
     * @throws FileNotFoundException 
     */
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

    /**
     * Write the information in the file
     * @param cars cars to export
     * @param filename file to save the information
     * @param msg a string to show in the information file
     * @throws FileNotFoundException 
     */
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

    /**
     * Export rents, all rents or rents filter for dates
     * @param out centinel to know if the export all or filter it.
     * @param init init date to filer
     * @param end end date to filter
     * @param filename file to save information
     * @throws FileNotFoundException 
     */
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
                if ((init.isBefore(listRents.get(i).getFinitial()) || init.equals(listRents.get(i).getFinitial()))
                        && (end.isAfter(listRents.get(i).getFfinal()) || end.equals(listRents.get(i).getFfinal()))) {
                    rentsExport.add(listRents.get(i));
                    System.out.println("Sapa hpta");
                }
            }
            msg = "Reportes de rentas filtradas por fechas\nFecha inicial: " + init.toString()
                    + "\nFecha final: " + end.toString();
        }
        writeRent(rentsExport, filename, msg);
    }

    /**
     * Write the information in the file
     * @param rents rents to export
     * @param filename file to save the information
     * @param msg a string to show in the information file
     * @throws FileNotFoundException 
     */
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
            pw.println("Codigo: " + rents.get(i).getCodeR() + "\nTicket: TRC" + rents.get(i).getTicket() + "\nFecha inicial: " + rents.get(i).getFinitial().toString()
                    + "\nFecha final: " + rents.get(i).getFfinal() + "\nCedula del cliente: " + rents.get(i).getIdClient()
                    + "\nNombre del cliente: " + rents.get(i).getNameClient() + "\nTelefono del cliente: " + rents.get(i).getPhoneClient()
                    + "\nID vehiculo: " + rents.get(i).getIdCar() + "\nPlaca del vehículo: " + rents.get(i).getPlateCar()
                    + "\nTipo de Carro: " + rents.get(i).getCarR().getNameType() + "\nMarca: " + rents.get(i).getCarR().getNameBrand()
                    + "\nPrecio por día: " + rents.get(i).getCarR().getPriceXDay() + "\nDias de prestamo: " + rents.get(i).getDays()
                    + "\nSubTotal: " + rents.get(i).getDays() * rents.get(i).getCarR().getPriceXDay() + "\nDías de atrazo: " + rents.get(i).getDelay() + "\nEstado: " + rents.get(i).getStatus()
                    + "\nMulta: " + rents.get(i).getMult() + "\nTotal a pagar: " + rents.get(i).getPriceTotal());
        }
        pw.println("-------------------------------------------------");
        pw.println("Factura termianda");
        pw.println("Total de rentas exportados " + rents.size());
        pw.close();
    }

    /**
     * Calculate the test of the velocity
     * @param velocity param to determinted the category
     * @return a string with the category of the car
     */
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

    /**
     * Import clients
     * @return boolean to know if the import was corrected
     */
    public boolean importClient() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileChooser()));
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String lastName = parts[1];
                long id = Long.parseLong(parts[2]);
                String emailC = parts[3];
                String addressC = parts[4];
                long phoneC = Long.parseLong(parts[5]);
                boolean added = false;
                try {
                    added = addClient(addressC, phoneC, emailC, null, code, 0, name, lastName, id);
                } catch (Email e) {
                }
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Import vehicles
     * @return boolean to know if the import was corrected
     */
    public boolean importVehicle() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileChooser()));
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String model = parts[0];
                String color = parts[1];
                double priceXDay = Double.parseDouble(parts[2]);
                String plate = parts[3];
                int year = Integer.parseInt(parts[4]);
                try {
                    addCar(model, color, null, null, priceXDay, code, plate, true, "", year);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Open the file choseer
     * @return file to save the information
     */
    public File fileChooser() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open File Client");
        File file = fc.showOpenDialog(null);
        return file;
    }

   /**
    * Determine array to show the pie shart
    * @return array with the values to show in the pie chart
    */
    public int[] amountStatRent() {
        int[] amountStatRent = new int[4];
        int amountDefered = 0;
        int amountExpireToday = 0;
        int amountExpire = 0;
        int amountPaid = 0;
        for (int i = 0; i < listRents.size(); i++) {
            uptadeStatRent(listRents.get(i).getCodeR());
        }
        for (int i = 0; i < listRents.size(); i++) {
            if (listRents.get(i).getStatus() == Status.DEFERRED) {
                amountDefered++;
            } else if (listRents.get(i).getStatus() == Status.EXPIRES_TODAY) {
                amountExpireToday++;
            } else if (listRents.get(i).getStatus() == Status.EXPIRED) {
                amountExpire++;
            } else {
                amountPaid++;
            }
        }
        amountStatRent[0] = amountDefered;
        amountStatRent[1] = amountExpireToday;
        amountStatRent[2] = amountExpire;
        amountStatRent[3] = amountPaid;
        return amountStatRent;
    }
}
