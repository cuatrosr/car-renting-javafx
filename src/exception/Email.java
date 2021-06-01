package exception;

public class Email extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    private String email;

    public Email(String email) {
        super("El Email debe de contener una arroba ('@')");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
