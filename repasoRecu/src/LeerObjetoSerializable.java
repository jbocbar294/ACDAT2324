import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeerObjetoSerializable {
    public static void main(String[] args) {
        File f = new File("res" + File.separator + "objetosSerializables.txt");

        if (f.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

                ArrayList<Usuario> lista = new ArrayList<>();
                while (true) {
                    try {
                        Usuario usuario = (Usuario) ois.readObject();
                        lista.add(usuario);
                    } catch (EOFException eofException) {
                        break;
                    }
                }


                for (Usuario usuario : lista) {
                    System.out.println("Objeto: " + usuario.toString());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        } else {
            System.out.println("No existe el fichero " + f.getName());
        }
    }
}
