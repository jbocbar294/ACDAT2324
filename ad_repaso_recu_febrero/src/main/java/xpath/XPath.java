package xpath;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.tree.DefaultAttribute;
import org.jaxen.JaxenException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XPath {
    public static void main(String[] args) {
        File f = new File("res" + File.separator + "instituto.xml");

        if (f.exists()) {
            try {
                // Ej 1: Nombre del instituto
                // Busca un solo elemento
                String consulta1 = "//nombre";
                List<Element> elemento = (List<Element>) ProcesadorXPath.consultaJaxen(f, consulta1);
                System.out.println("Consulta 1:\n" + elemento.get(0).getText());
                System.out.println("====================================");

                // Ej 2: Página web del instituto
                String consulta2 = "//web";
                elemento = (List<Element>) ProcesadorXPath.consultaJaxen(f, consulta2);
                System.out.println("Consulta 2:\n" + elemento.get(0).getText());
                System.out.println("====================================");

                // Ej 3: Nombre de los ciclos formativos
                String consulta3 = "//ciclo/nombre";
                elemento = (List<Element>) ProcesadorXPath.consultaJaxen(f, consulta3);
                System.out.println("Consulta 3:");
                for (Element element : elemento) {
                    System.out.println(element.getText());
                }
                System.out.println("====================================");

                // Ej 4: siglas de los ciclos
                String consulta4 = "//@id";
                List<DefaultAttribute> atributo = (List<DefaultAttribute>) ProcesadorXPath.consultaJaxen(f, consulta4);
                System.out.println("Consulta 4:");
                for (DefaultAttribute atribut: atributo) {
                    System.out.println(atribut.getText());
                }
                System.out.println("====================================");

                // Ej 5: Años en los que se publicaron los decretos de título de los Ciclos Formativos
                String consulta5 = "//@año";
                atributo = (List<DefaultAttribute>) ProcesadorXPath.consultaJaxen(f, consulta5);
                System.out.println("Consulta 5:");
                for (DefaultAttribute atribut : atributo) {
                    System.out.println(atribut.getText());
                }
                System.out.println("====================================");

                // Ej 6: Ciclos Formativos de Grado Medio (se trata de obtener el elemento <ciclo> completo)
                String consulta6 = "//ciclo[grado=\"Medio\"]";
                elemento = (List<Element>) ProcesadorXPath.consultaJaxen(f, consulta6);
                System.out.println("Consulta 6:");
                for (Element element : elemento) {
                    System.out.println(element.asXML());
                }
                System.out.println("====================================");

                // Ej 7: Nombre de los Ciclos Formativos de Grado Superior
                String consulta7 = "//ciclo[grado=\"Superior\"]/nombre";
                elemento = (List<Element>) ProcesadorXPath.consultaJaxen(f, consulta7);
                System.out.println("Consulta 7:");
                for (Element element : elemento) {
                    System.out.println(element.getText());
                }
                System.out.println("====================================");

                // Ej 8: Nombre de los Ciclos Formativos anteriores a 2010
                String consulta8 = "//decretoTitulo[@año<2010]/../nombre";
                elemento = (List<Element>) ProcesadorXPath.consultaJaxen(f, consulta8);
                System.out.println("Consulta 8:");
                for (Element element : elemento) {
                    System.out.println(element.getText());
                }
                System.out.println("====================================");

                // Ej 9: Nombre de los Ciclos Formativos de 2008 o 2010
                String consulta9 = "//decretoTitulo[@año=2008 or @año=2010]/../nombre";
                elemento = (List<Element>) ProcesadorXPath.consultaJaxen(f, consulta9);
                System.out.println("Consulta 9:");
                for (Element element : elemento) {
                    System.out.println(element.getText());
                }
                System.out.println("====================================");

            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (JaxenException e) {
                throw new RuntimeException(e);
            }
        }
    }
}