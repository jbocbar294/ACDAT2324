import java.io.*;

public class A_fw_br {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("res" + File.separator + "archivo.txt"));
            FileWriter fw = new FileWriter("res" + File.separator + "archivo2.txt");

            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.isEmpty()) {
                    fw.write("vacia");
                } else {
                    fw.write(linea);
                }
                fw.write("\n");
            }

            br.close();
            fw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
