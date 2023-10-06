import java.io.*;

public class escribeFicherosCaracteres {
    public static void main(String[] args) {
        //leer una ruta y volcar el contenido en la misma ruta, cada carácter es una linea.

        File file1 = new File ("res" + File.separator + "datos.txt");

        if (file1.exists()) {
            File file2 = new File("res" + File.separator + "volcado.txt");

            try {
                FileReader fr = new FileReader(file1);
                FileWriter fw = new FileWriter(file2, true);

                int caracter = fr.read();
                while (caracter != -1) {
                    fw.write(caracter);
                    fw.write('\n');
                    caracter=fr.read();
                }

                //prueba 4 commit

                fr.close();
                fw.close();

            } catch (IOException e) {
                System.err.println("Error.");
            }


        } else {
            System.out.println("El fichero no existe.");
        }

    }
}
