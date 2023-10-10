package ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionaAgenda {

    // Ej 2-A.1
    public static List<Contacto> obtenerLista(String vcard) {

        File f = new File(vcard);
        List<Contacto> lista = new ArrayList<>();

        if (f.exists()) {

            try {
                // BufferedReader para leer el archivo contactos.vcard
                FileReader fr = new FileReader(vcard);
                BufferedReader bufferedReader = new BufferedReader(fr);

                // String en el que se almacenará cada linea del archivo
                String linea;

                String nombre = "", apellido1 = "", apellido2 = "", email = "";
                int telhome = 0, telmovil = 0, extension = 0;

                while ((linea = bufferedReader.readLine()) != null) {

                    // mientras lee el archivo va comparando cada línea, en caso de que inicie igual que en la comparación
                    // del if, con el substring eliminamos los primeros caracteres de la línea, luego
                    // haciendo uso del split inserta el nombre y apellidos del contacto en un array, después
                    // los pasa del array a las variables
                    if (linea.startsWith("FN:")) {
                        String[] arrayNombreApellidos = linea.substring(3).split(" ");
                        nombre = arrayNombreApellidos[0];
                        apellido1 = arrayNombreApellidos[1];
                        apellido2 = arrayNombreApellidos[2];
                    }

                    // el resto de ifs son parecidas, compara el inicio de la línea, haciendo uso del substring elimina
                    // los caracteres del principio de la línea y luego lo inserta en la variable
                    if (linea.startsWith("EMAIL")) {
                        email = linea.substring(30);
                    }

                    if (linea.startsWith("TEL;TYPE=VOICE,HOME")) {
                        telhome = Integer.parseInt(linea.substring(31));
                    }

                    if (linea.startsWith("TEL;TYPE=VOICE,CELL")) {
                        telmovil = Integer.parseInt(linea.substring(31));
                    }

                    if (linea.startsWith("TEL;TYPE=VOICE,WORK")) {
                        extension = Integer.parseInt(linea.substring(31));
                    }

                    // vuelve a comprarar de la misma forma que los anteriores ifs, pero en este caso la vcard termina,
                    // por lo que crea un objeto contacto y lo añade a la lista
                    if (linea.equals("END:VCARD")) {
                        Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telhome, telmovil, extension);
                        lista.add(contacto);
                    }
                }

                bufferedReader.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El fichero no existe.");
        }

        return lista;
    }

    // Ej 2-A.2
    public static boolean generarFichero(String vcard) {

        File f = new File(vcard);
        List<Contacto> lista = new ArrayList<>();

        if (f.exists()) {

            try {
                // BufferedReader para leer el archivo contactos.vcard
                FileReader fr = new FileReader(vcard);
                BufferedReader bufferedReader = new BufferedReader(fr);

                // String en el que se almacenará cada linea del archivo
                String linea;

                String nombre = "", apellido1 = "", apellido2 = "", email = "";
                int telhome = 0, telmovil = 0, extension = 0;

                while ((linea = bufferedReader.readLine()) != null) {

                    // mientras lee el archivo va comparando cada línea, en caso de que inicie igual que en la comparación
                    // del if, con el substring eliminamos los primeros caracteres de la línea, luego
                    // haciendo uso del split inserta el nombre y apellidos del contacto en un array, después
                    // los pasa del array a las variables
                    if (linea.startsWith("FN:")) {
                        String[] arrayNombreApellidos = linea.substring(3).split(" ");
                        nombre = arrayNombreApellidos[0];
                        apellido1 = arrayNombreApellidos[1];
                        apellido2 = arrayNombreApellidos[2];
                    }

                    // el resto de ifs son parecidas, compara el inicio de la línea, haciendo uso del substring elimina
                    // los caracteres del principio de la línea y luego lo inserta en la variable
                    if (linea.startsWith("EMAIL")) {
                        email = linea.substring(30);
                    }

                    if (linea.startsWith("TEL;TYPE=VOICE,HOME")) {
                        telhome = Integer.parseInt(linea.substring(31));
                    }

                    if (linea.startsWith("TEL;TYPE=VOICE,CELL")) {
                        telmovil = Integer.parseInt(linea.substring(31));
                    }

                    if (linea.startsWith("TEL;TYPE=VOICE,WORK")) {
                        extension = Integer.parseInt(linea.substring(31));
                    }

                    // vuelve a comprarar de la misma forma que los anteriores ifs, pero en este caso la vcard termina,
                    // por lo que crea un objeto contacto y lo añade a la lista
                    if (linea.equals("END:VCARD")) {
                        Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telhome, telmovil, extension);
                        lista.add(contacto);
                    }
                }

                bufferedReader.close();

                System.out.println("\n======== LISTA DE CONTACTOS ========\n");
                for (Contacto i : lista) {
                    System.out.println(i);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El fichero no existe.");
        }

        return true;
    }

}
