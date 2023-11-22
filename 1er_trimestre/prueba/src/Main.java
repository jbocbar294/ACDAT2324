import java.io.*;

public class Main {
    public static void main(String[] args) {

        File f = new File("res" + File.separator + "file1.txt");
        File f2 = new File("res" + File.separator + "file2.txt");

        try {

            BufferedReader br = new BufferedReader(new FileReader(f));
            FileWriter fw = new FileWriter(f2, true);

            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line+"\n");
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