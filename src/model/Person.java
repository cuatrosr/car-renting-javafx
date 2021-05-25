package model;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1;
    private int codeP;
    private int refP;
    private String name;
    private String lastName;
    private long id;

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
}
