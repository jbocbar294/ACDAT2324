package ej2;

import java.io.File;

public class agendaApp {

    public static void main(String[] args) {

    String vcard="res" + File.separator + "contactos.vcard";

    GestionaAgenda.obtenerLista(vcard);

    }
}
