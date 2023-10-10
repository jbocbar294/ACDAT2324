package ej1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenaArchivoTexto {

    public static void main(String[] args) throws FileNotFoundException {

        // fichero de entrada
        File f = new File("res" + File.separator + "archivo.txt");
        // fichero de salida
        File f2 = new File("res" + File.separator + "archivo.tmp");

        try {
            // control de errores
            if (f.exists() && f2.exists()) {

                sort(f, f2);

            } else {
                //excepción por si el archivo no existe
                throw new FileNotFoundException("El archivo no existe.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // método que ordena y borra las lineas en blanco
    public static void sort(File f, File f2) {

        ArrayList<String> lineas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String lineaActual;

            // bucle que usa el BufferedReader para leer el fichero completo
            while ((lineaActual = br.readLine()) != null) {
                // if que comprueba si la linea no está vacía, si la condición se cumple añade al arraylist lineas la linea actual
                if (!lineaActual.isEmpty()) {
                    lineas.add(lineaActual);
                }
            }

            // método de la clase Collections que ordena
            Collections.sort(lineas);

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
            // mediante el BufferedWriter y un bucle escribimos todas las lineas del array en el fichero
            for (String linea : lineas) {
                bw.write(linea);
                // después de cada linea inserta un salto de linea
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}