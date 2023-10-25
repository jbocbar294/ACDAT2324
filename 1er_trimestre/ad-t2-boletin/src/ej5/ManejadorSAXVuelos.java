package ej5;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorSAXVuelos extends DefaultHandler {

    private String xmlResult;

    FileWriter fw;

    {
        try {
            fw = new FileWriter(new File("res" + File.separator + "vuelos.html"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ManejadorSAXVuelos() {
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
                    "   <h1>LISTADO DE SALIDA DE VUELOS</h1>\n" +
                    "       <table border=1>\n" +
                    "           <tr>\n" +
                    "               <th>ORIGEN</th>\n" +
                    "               <th>DESTINO</th>\n" +
                    "           <tr>\n"
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            fw.write("</table>\n</body>\n</html>");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {

        try {
            if (elemento.equals("Vuelo")) {
                fw.write("<tr>\n");
            }
            if (elemento.equals("origen")) {
                fw.write("<td>");
            }
            if (elemento.equals("destino")) {
                fw.write("<td>");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {

        try {
            if (elemento.equals("Vuelo")) {
                fw.write("</tr>\n");
            }
            if (elemento.equals("origen")) {
                fw.write("</td>\n");
            }
            if (elemento.equals("destino")) {
                fw.write("</td>\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {

        try {
            fw.write(new String(cadena, posinicio, longitud));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void ignorableWhitespace(char[] cadena, int posinicio, int longitud) throws SAXException {
        // System.out.println("Es un blanco");
    }

}
