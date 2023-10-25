package ej3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorSAXEmpleados extends DefaultHandler {

    private String xmlResult;

    private static int contador = 0;

    public ManejadorSAXEmpleados() {
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

    }

    @Override
    public void startElement(String uri, String nombre, String elemento, Attributes atts) throws SAXException {
        if (elemento.equals("Empleado")) {
            xmlResult += "\n";
        }
    }

    @Override
    public void endElement(String uri, String nombre, String elemento) throws SAXException {
        if (elemento.equals("Empleado")) {
            contador++;
        }
    }

    @Override
    public void characters(char[] cadena, int posinicio, int longitud) throws SAXException {
        xmlResult += new String(cadena, posinicio, longitud) + " ";
    }


    public void ignorableWhitespace(char[] cadena, int posinicio, int longitud) throws SAXException {
        // System.out.println("Es un blanco");
    }

    public void imprimirContador() {
        System.out.println("Número de empleados: " + Integer.toString(contador));
    }

}
