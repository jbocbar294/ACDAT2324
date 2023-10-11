package ej2;
import java.io.File;
public class AgendaApp {
    public static void main(String[] args) {
    String fvcard="res" + File.separator + "contactos.vcard";
    System.out.println("\nEjercicio 1:");
    System.out.println("\n======== LISTA DE CONTACTOS ========\n\n" + GestionaAgenda.obtenerLista(fvcard).toString() + "\n");
    System.out.println("------------------------\nEjercicio 2:\n");
    GestionaAgenda.generarFichero(fvcard);
    System.out.println("Fichero generado\n");
    System.out.println("------------------------\nEjercicio 3:\n");
    GestionaAgenda.toXML(new File(fvcard));
    System.out.println("Fichero generado\n");
    }
}