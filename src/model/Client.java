package model;

import java.io.Serializable;

public class Client extends Person implements Serializable, Comparable<Client> {

    private static final long serialVersionUID = 1;

    //---------------------------- Attributes of the Client class ----------------------------\\
    private String addressC;
    private long phoneC;
    private String emailC;
    private City cityC;

    //-------------------------- Constructor, getter and setter class --------------------------\\
    /**
     * Client class constructor
     * @param addressC object's address
     * @param phoneC  object's phone
     * @param emailC object's email
     * @param cityC object's city
     * @param codeP object's code
     * @param refP object's reference
     * @param name object's name
     * @param lastName object's last name
     * @param id object's identification
     */
    public Client(String addressC, long phoneC, String emailC, City cityC, int codeP, int refP, String name, String lastName, long id) {
        super(codeP, refP, name, lastName, id);
        this.addressC = addressC;
        this.phoneC = phoneC;
        this.emailC = emailC;
        this.cityC = cityC;
    }

    public String getAddressC() {
        return addressC;
    }

    public void setAddressC(String addressC) {
        this.addressC = addressC;
    }

    public long getPhoneC() {
        return phoneC;
    }

    public void setPhoneC(long phoneC) {
        this.phoneC = phoneC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    public City getCityC() {
        return cityC;
    }

    public void setCityC(City cityC) {
        this.cityC = cityC;
    }

    public String getNameCity() {
        if (cityC == null) {
            return "";
        } else {
            return cityC.getNameCi();
        }
    }

    @Override
    public int compareTo(Client o) {
        return this.getNameLN().compareToIgnoreCase(o.getNameLN());
    }
}
