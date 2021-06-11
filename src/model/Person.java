package model;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Person class ----------------------------\\
    private int codeP;
    private int refP;
    private String name;
    private String lastName;
    private long id;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Person class constructor
     * @param codeP object's code
     * @param refP object's reference
     * @param name object's name
     * @param lastName object's last name
     * @param id object's identification
     */
    public Person(int codeP, int refP, String name, String lastName, long id) {
        this.codeP = codeP;
        this.refP = refP;
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    public int getRefP() {
        return refP;
    }

    public void setRefP(int refP) {
        this.refP = refP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameLN() {
        String nameLN = getName() + " " + getLastName();
        return nameLN;
    }
}
