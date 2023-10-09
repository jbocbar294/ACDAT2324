package ej2;

import java.io.*;
import java.util.ArrayList;
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

            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
                try {
                    // Pausa el programa durante 3 segundos (3000 milisegundos)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Maneja la excepción si se interrumpe la pausa
                    e.printStackTrace();
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
