package exception;

public class Reference extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    private int ref;

    public Reference(int ref) {
        super("La referencias deben ser iguales a cero para eliminar correctamente");
        this.ref = ref;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }
}
