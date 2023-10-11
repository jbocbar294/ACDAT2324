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

        try {

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

    // Ej 2-A.3
    public static File toXML(File fvcard) {

        File fxml = new File("res" + File.separator + "contactos.xml");
        ArrayList<Contacto> lista = new ArrayList<>();

        try {
            // con un BufferedReader leo las lineas del archivo
            BufferedReader br = new BufferedReader(new FileReader(fvcard));

            String nombre = "", apellido1 = "", apellido2 = "", email = "";
            int telhome = 0, telmovil = 0, extension = 0;

            String linea;

            // lee el archivo hasta que no quedan lineas
            while ((linea = br.readLine()) != null) {

                // al igual que el método obtenerLista, compara el inicio de la línea, en caso de que coincida inserta
                // el dato en la variable
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

                // este if comprueba si el contacto de la vcard ha terminado, en ese caso, crea un objeto de la clase
                // Contacto con las variables que se han creado antes y lo añade al arraylist que contiene los contactos
                if (linea.equals("END:VCARD")) {
                    Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telhome, telmovil, extension);
                    lista.add(contacto);
                }

            }

            Contacto aux;
            // método burbuja para ordenar los contactos por el campo extension
            // primer bucle for que ejecuta el segundo bucle tantas vecees como posiciones tenga el arraylist
            for (int i=0;i<lista.size()-1;i++) {

                // bucle que se ejecuta igual que el anterior
                for (int j=0;j<lista.size()-1;j++) {

                    // compara el campo extension de la posición j y j+1, en caso de que la extensión de la posición j
                    // sea mayor que la extensión de la posición j+1, intercambia estos dos objetos de sitio
                    if (lista.get(j).getExtension() > lista.get(j+1).getExtension()) {

                        // Almacena el valor en 'j' en una variable temporal
                        aux = lista.get(j);

                        // almacena en la posición j el valor de j+1
                        lista.set(j, lista.get(j+1));

                        // almacena en la posición j+1 el valor de aux
                        lista.set(j+1, aux);
                    }

                }

            }

            try {

                FileWriter fw = new FileWriter(fxml);

                // escribe en el fichero la cabecera del archivo xml
                fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n\n");
                fw.write("<contactos>\n\n");

                // bucle que escribe en el fichero tantas veces como posiciones tenga el arraylist,
                // escribe en el fichero una estructura xml y usando los getters escribe los campos del objeto que lee
                for (int i=0;i<lista.size();i++) {
                    fw.write("\t<contacto>\n\n");
                    fw.write("\t\t<nombre>" + lista.get(i).getNombre() + "</nombre>\n");
                    fw.write("\t\t<apellido1>" + lista.get(i).getApellido1() + "</apellido1>\n");
                    fw.write("\t\t<apellido2>" + lista.get(i).getApellido2() + "</apellido2>\n");
                    fw.write("\t\t<email>" + lista.get(i).getEmail() + "</email>\n");
                    fw.write("\t\t<telhome>" + lista.get(i).getTelhome() + "</telhome>\n");
                    fw.write("\t\t<telmovil>" + lista.get(i).getTelmovil() + "</telmovil>\n");
                    fw.write("\t\t<extension>" + lista.get(i).getExtension() + "</extension>\n\n");
                    fw.write("\t</contacto>\n\n");
                }

                fw.write("</contactos>");
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fxml;
    }

}
