import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class B_json_gson {
    public static void main(String[] args) {
        Libro libro = new Libro("nombre1","autor1");

        Gson gson = new Gson();

        System.out.println(gson.toJson(libro));

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("res" + File.separator + "archivo4.json"));

            bw.write(gson.toJson(libro));

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

array

ois

       Libro libro = (clase) ois.readObject();ç

while (ois.ready)