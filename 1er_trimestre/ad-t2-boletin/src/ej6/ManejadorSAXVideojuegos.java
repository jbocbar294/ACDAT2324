package ej6;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorSAXVideojuegos extends DefaultHandler {

    private String xmlResult;

    FileWriter fw;

    boolean escribir = false;
    boolean escribirJuegomesa = false;

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
                escribirJuegomesa = true;
            }
            if (elemento.equals("videojuego")) {
                fw.write("<td>\n");
            }
            if (elemento.equals("caratula")) {
                fw.write("<img src=\"");
                escribir = true;
            }
            if (elemento.equals("titulo")) {
                fw.write("<p><b>");
                escribir = true;
            }
            if (elemento.equals("plataforma")) {
                fw.write("<p>Consola: ");
                escribir = true;
            }
            if (elemento.equals("stock")) {
                fw.write("<p>Stock actual: ");
                escribir = true;
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
            }
            if (elemento.equals("videojuego")) {
                fw.write("</td>\n");
            }
            if (elemento.equals("caratula")) {
                fw.write("\">\n");
                escribir = false;
            }
            if (elemento.equals("titulo")) {
                fw.write("</b></p>\n");
                escribir = false;
            }
            if (elemento.equals("plataforma")) {
                fw.write("</p>\n");
                escribir = false;
            }
            if (elemento.equals("stock")) {
                fw.write("</p>\n");
                escribir = false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        if (escribir == true && escribirJuegomesa == false) {
            try {
                fw.write(new String(cadena, posinicio, longitud));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void ignorableWhitespace(char[] cadena, int posinicio, int longitud) throws SAXException {
        // System.out.println("Es un blanco");
    }

}
