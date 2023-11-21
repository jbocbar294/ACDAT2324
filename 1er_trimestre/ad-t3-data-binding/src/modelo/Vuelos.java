package modelo;

import java.util.ArrayList;
import java.util.List;

public class Vuelos {

    private List<Vuelo> listaVuelos;

    public Vuelos() {
        listaVuelos = new ArrayList<Vuelo>();
    }

    public void add(Vuelo vuelo) {
        listaVuelos.add(vuelo);
    }

}