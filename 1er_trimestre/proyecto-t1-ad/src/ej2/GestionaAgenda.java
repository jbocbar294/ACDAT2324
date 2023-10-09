package ej2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionaAgenda {

    public static List<Contacto> obtenerLista (String vcard) {

        List<Contacto> lista = new ArrayList<Contacto>();

        String nombre = "", apellido1 = "", apellido2 = "", email = "";
        int telhome = 0, telmovil = 0, extension = 0;

        Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telhome, telmovil, extension);

        try {

            FileReader fr = new FileReader(vcard);
            BufferedReader bufferedReader = new BufferedReader(fr);

            String linea;
            String arrayNombreApellidosEmail[] = new String[3];
            while ((linea = bufferedReader.readLine()) != null) {

                if (linea.startsWith("FN:")) {
                    arrayNombreApellidosEmail = linea.substring(3).split(" ");
                    nombre=arrayNombreApellidosEmail[0];
                    apellido1=arrayNombreApellidosEmail[1];
                    apellido2=arrayNombreApellidosEmail[2];
                }

                if (linea.startsWith("EMAIL")) {
                    email = linea.substring(30);
                }
                
                if (linea.equals("")) {
                    // añadir objeto al arraylist
                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return lista;
    }



}
