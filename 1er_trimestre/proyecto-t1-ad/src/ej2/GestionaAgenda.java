package ej2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionaAgenda {

    // Ej 2-A.1
    public static List<Contacto> obtenerLista(String fvcard) {

        File f = new File(fvcard);
        List<Contacto> lista = new ArrayList<>();

        if (f.exists()) {

            try {
                // BufferedReader para leer el archivo contactos.vcard
                FileReader fr = new FileReader(fvcard);
                BufferedReader br = new BufferedReader(fr);

                // String en el que se almacenará cada linea del archivo
                String linea;

                String nombre = "", apellido1 = "", apellido2 = "", email = "";
                int telhome = 0, telmovil = 0, extension = 0;

                while ((linea = br.readLine()) != null) {

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

                    // vuelve a comprarar de la misma forma que los anteriores ifs, pero en este caso la fvcard termina,
                    // por lo que crea un objeto contacto y lo añade a la lista
                    if (linea.equals("END:VCARD")) {
                        Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telhome, telmovil, extension);
                        lista.add(contacto);
                        extension = 000;
                    }
                }

                br.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El fichero no existe.");
        }

        return lista;
    }

    // Ej 2-A.2
    public static boolean generarFichero(String fvcard) {

        File f = new File("res" + File.separator + "contactos.dat");

        // comprueba si el archivo no existe, si es así devuelve false
        if (!f.exists()) {
            System.out.println("El fichero destino no existe.");
            return false;
        }

        try {
            // se usa para escribir datos binarios
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res" + File.separator + "contactos.dat"));

            //recorre la lista de contactos y comprueba que tengan extension
            for (Contacto i : obtenerLista(fvcard)) {
                if (i.getExtension() != 000) {
                    oos.writeObject(i);
                }
            }

            oos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }


    public static File toXML(File fvcard) {

        File fxml = new File("res" + File.separator + "contactos.dat");
        List<Contacto> lista = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(fvcard));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fxml));

            String nombre = "", apellido1 = "", apellido2 = "", email = "";
            int telhome = 0, telmovil = 0, extension = 0;

            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("FN:")) {
                    String[] arrayNombreApellidos = linea.substring(3).split(" ");
                    nombre = arrayNombreApellidos[0];
                    apellido1 = arrayNombreApellidos[1];
                    apellido2 = arrayNombreApellidos[2];
                }

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

                if (linea.equals("END:VCARD")) {
                    Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telhome, telmovil, extension);
                    lista.add(contacto);
                }

                //falta pasar la lista al fichero xml
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fxml;
    }

}
