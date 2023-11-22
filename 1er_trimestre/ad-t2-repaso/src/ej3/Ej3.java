package ej3;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.jaxen.JaxenException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ej3 {

    public static void main(String[] args) {

        File xml = new File("res" + File.separator + "mihtml.xml");

        if (xml.exists()) {
            try {
                // ej1
                System.out.println("--------------------------------\nEjercicio 1\n");
                String consulta = "count(//table)";
                System.out.println(consulta);
                System.out.println(ProcesadorXPath.consultaJaxen(xml, consulta));

                // ej2
                System.out.println("--------------------------------\nEjercicio 2\n");
                consulta = "//table/tr/td";
                System.out.println(consulta);
                List <Element> lista = (ArrayList<Element>) ProcesadorXPath.consultaJaxen(xml, consulta);
                for (Element elemento : lista) {
                    System.out.println(elemento.asXML());
                }

                // ej3
                System.out.println("--------------------------------\nEjercicio 3\n");
                consulta = "//table/tr[position()=1]";
                System.out.println(consulta);
                lista = (ArrayList<Element>) ProcesadorXPath.consultaJaxen(xml, consulta);
                for (Element elemento : lista) {
                    System.out.println(elemento.asXML());
                }

                // ej4
                System.out.println("--------------------------------\nEjercicio 4\n");
                consulta = "count(//table/tr[td='Celda B1'])";
                System.out.println(consulta);
                System.out.println(ProcesadorXPath.consultaJaxen(xml, consulta));

                // ej5
                System.out.println("--------------------------------\nEjercicio 5\n");
                consulta = "count(//table/tr[count(td)>=2])";
                System.out.println(consulta);
                System.out.println(ProcesadorXPath.consultaJaxen(xml, consulta));

            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (JaxenException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
