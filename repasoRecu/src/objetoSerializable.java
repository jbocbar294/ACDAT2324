import java.io.*;
import java.util.ArrayList;

public class objetoSerializable {
    public static void main(String[] args) {
        File f = new File("res" + File.separator + "objetosSerializables.txt");

        if (f.exists()) {
            try {
                ArrayList<Usuario> lista = new ArrayList<>();
                Usuario objeto1 = new Usuario(1, "Juanma");
                Usuario objeto2 = new Usuario(2, "Paula");
                Usuario objeto3 = new Usuario(3, "Mohamed");
                Usuario objeto4 = new Usuario(4, "Nico");
                Usuario objeto5 = new Usuario(5, "Migue");

                lista.add(objeto1);
                lista.add(objeto2);
                lista.add(objeto3);
                lista.add(objeto4);
                lista.add(objeto5);

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeInt(lista.size());

                for (Usuario objeto : lista) {
                    oos.writeObject(objeto);
                }

                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se puede abrir el fichero " + f.getName());
        }
    }
}

