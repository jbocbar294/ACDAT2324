import java.io.Serializable;

public class Usuario implements Serializable {
    private int numero;
    private String texto;

    public Usuario(int numero, String texto) {
        this.numero = numero;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "numero=" + numero +
                ", texto='" + texto + '\'' +
                '}';
    }
}