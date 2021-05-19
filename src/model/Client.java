package model;

public class Client extends Person{
    
    private String addressC;
    private long phoneC;
    private String emailC;
    private City cityC;

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
}
