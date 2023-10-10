package ej2;

import java.io.File;

public class agendaApp {

    public static void main(String[] args) {

    String vcard="res" + File.separator + "contactos.vcard";

    System.out.println("\n======== LISTA DE CONTACTOS ========\n\n" + GestionaAgenda.obtenerLista(vcard).toString() + "\n\n\n");

    GestionaAgenda.generarFichero(vcard);

    GestionaAgenda.toXML(new File(vcard));

    }
}
