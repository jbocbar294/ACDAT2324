package modelo;

public class Vuelo {

    private String origen;
    private String destino;

    //constructor
    public Vuelo(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    // getters & setters
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
