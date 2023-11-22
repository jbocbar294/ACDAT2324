package ej1;

import java.io.*;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class Ej1 {

    public static File makeGlobalFile(String path) {
        File salida = null;
        File directorio = new File(path);

        try {
            if (directorio.exists()) {
                if (directorio.isDirectory()) {
                    File[] lista = directorio.listFiles();

                    boolean encontrado = false;
                    int i = 0;

                    while (i < lista.length && !encontrado) {
                        if (lista[i].getName().lastIndexOf(".xml") > 0) {
                            encontrado = true;
                        }
                        i++;
                    }

                    if (encontrado) {
                        salida = new File(directorio.getAbsolutePath() + File.separator + directorio.getName() + ".txt");
                        FileWriter fsalida = new FileWriter(salida);

                        String line;
                        for (File fichero : lista) {
                            if (fichero.getName().lastIndexOf(".xml") > 0) {
                                fsalida.write(fichero.getName() + "\n\n");
                                BufferedReader f1 = new BufferedReader(new FileReader(fichero));
                                while ((line = f1.readLine()) != null) {
                                    fsalida.write(line + "\n");
                                }
                                fsalida.write("\n----------------\n");
                                f1.close();
                            }
                        }
                        fsalida.close();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }

    public static void main(String[] args) {
        File f = Ej1.makeGlobalFile("res" + File.separator + "xmls");

        if (f != null) {
            System.out.println("Fichero generado en " + f.getAbsolutePath());
        }
    }

}