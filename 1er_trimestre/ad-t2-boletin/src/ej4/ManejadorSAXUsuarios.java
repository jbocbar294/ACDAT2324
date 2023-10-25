package ej4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorSAXUsuarios extends DefaultHandler {

    private boolean anyadirSN = false;

    private String xmlResult;

    FileWriter fw;

    {
        try {
            fw = new FileWriter(new File("res" + File.separator + "usuarios.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ManejadorSAXUsuarios() {
        xmlResult = "";
    }

    public String getXMLResult() {
        return xmlResult;
    }


    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        if (elemento.equals("username") || elemento.equals("password")) {
            anyadirSN = true;
        } else {
            anyadirSN = false;
        }
    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {

        if (elemento.equals("username")) {
            try {
                fw.write(":");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (elemento.equals("password")) {
            try {
                fw.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {

        if (anyadirSN) {
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
