package ies.mm.ad.t2;

import javax.lang.model.element.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.jaxen.JaxenException;

public class CochesXPath {
    public static void main(String args[]) throws Exception {

        File xml = new File("res" + File.separator + "coches.xml");

        if (xml.exists()) {

            try {

                System.out.println("********************************");
                String exp="//coche[fabricante='Nissan']";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml, exp));

                System.out.println("********************************");
                exp="//coche[fabricante='Renault' and unidades>15]";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml, exp));

                System.out.println("********************************");
                exp="count(//coche)";
                System.out.println(exp);
                System.out.println(ProcesadorXPath.consulta(xml, exp));


                System.out.println("********************************");
                exp="//coche/nombre";
                System.out.println(exp);
                List<Element> lista = (ArrayList<Element>) ProcesadorXPath.consultaJaxen(xml, exp);

                for (Element elemento : lista) {
                    System.out.println(elemento.as);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}