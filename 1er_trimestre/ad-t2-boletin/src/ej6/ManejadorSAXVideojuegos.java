package ej6;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManejadorSAXVideojuegos extends DefaultHandler {

    private String xmlResult;

    FileWriter fw;

    boolean escribir = false;
    boolean escribirJuegomesa = false;
    boolean escribirCaratula = false;

    ArrayList<String> contenido = new ArrayList<String>();

    {
        try {
            fw = new FileWriter(new File("res" + File.separator + "videojuegos.html"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ManejadorSAXVideojuegos() {
        xmlResult = "";
    }

    public String getXMLResult() {
        return xmlResult;
    }


    @Override
    public void startDocument() throws SAXException {
        try {
            fw.write("<!DOCTYPE html>\n" +
                    "<head>" +
                    "<style>" +
                    "table {" +
                    "border-collapse: collapse;" +
                    "margin: 0 auto;" +
                    "}\n" +
                    "td {" +
                    "text-align: center;" +
                    "vertical-align: middle;" +
                    "}" +
                    "</style>" +
                    "</head>" +
                    "<body>\n" +
                    "   <h1>CATÁLOGO DE VIDEOJUEGOS CLÁSICOS</h1>\n" +
                    "       <table border=1>\n" +
                    "           <tr>\n"
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            fw.write("</tr>\n</table>\n</body>\n</html>");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {

        try {
            if (elemento.equals("juegomesa")) {
                escribir = true;
                escribirJuegomesa = true;
            }
            if (elemento.equals("videojuego")) {
                fw.write("<td>\n");
            }
            if (elemento.equals("caratula")) {
                fw.write("<img src=\"../");
                escribir = true;
                escribirCaratula = true;
            }
            if (elemento.equals("titulo")) {
                contenido.add("<p><b>");
                escribir = true;
            }
            if (elemento.equals("plataforma")) {
                contenido.add("<p>Consola: ");
                escribir = true;
            }
            if (elemento.equals("stock") && !escribirJuegomesa) {
                contenido.add("<p>Stock actual: ");
                escribir = true;
            }
            if (elemento.equals("captura")) {
                escribirJuegomesa = true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {

        try {
            if (elemento.equals("juegomesa")) {
                escribirJuegomesa = false;
                escribir = true;
            }
            if (elemento.equals("videojuego")) {
                for (String i : contenido) {
                    fw.write(i);
                }
                fw.write("</td>\n");
                contenido.clear();
            }
            if (elemento.equals("caratula")) {
                fw.write("\">\n");
                escribir = false;
                escribirCaratula = false;
            }
            if (elemento.equals("titulo")) {
                contenido.add("</b></p>\n");
                escribir = false;
            }
            if (elemento.equals("plataforma")) {
                contenido.add("</p>\n");
                escribir = false;
            }
            if (elemento.equals("stock")) {
                contenido.add("</p>\n");
                escribir = false;
            }
            if (elemento.equals("captura")) {
                escribirJuegomesa = false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {

        if (escribir == true && !escribirJuegomesa && !escribirCaratula) {

            contenido.add(new String(cadena, posinicio, longitud));

        } else if (!escribirJuegomesa) {

            try {
                fw.write(cadena, posinicio, longitud);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }


    public void ignorableWhitespace(char[] cadena, int posinicio, int longitud) throws SAXException {
        // System.out.println("Es un blanco");
    }

}
