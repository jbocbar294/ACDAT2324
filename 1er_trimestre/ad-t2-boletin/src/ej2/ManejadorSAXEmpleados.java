package ej2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorSAXEmpleados extends DefaultHandler {

    private String xmlResult;

    public ManejadorSAXEmpleados() {
        xmlResult = "";
    }

    public String getXMLResult() {
        return xmlResult;
    }

    public void setXMLResult(String xmlResult) {
        this.xmlResult = xmlResult;
    }


    @Override
    public void startDocument() throws SAXException {
        //xmlResult += "COMIENZO DEL DOCUMENTO XML\n";
    }


    @Override
    public void endDocument() throws SAXException {
        //xmlResult += "FIN DEL DOCUMENTO XML\n";
    }


    @Override
    public void startElement(String uri, String nombre, String elemento,
                             Attributes atts) throws SAXException {
        if (elemento.equals("nombre")) {
            xmlResult += elemento.toUpperCase() + ": ";
        } else if (elemento.equals("x") | elemento.equals("y") | elemento.equals("z")) {
            xmlResult += "|_ "+elemento.toUpperCase() + ": ";
        }
    }


    @Override
    public void endElement(String uri, String nombre, String elemento)
            throws SAXException {
        //xmlResult += "\n";
    }


    @Override
    public void characters(char[] cadena, int posinicio, int longitud)
            throws SAXException {
        // OPCIÓN 1
        xmlResult += new String(cadena, posinicio, longitud)+"\n";

        // OPCIÓN 2
        // for (int i = start; i < length + start; i++)
        // result += Character.toString(cadena[i]);
    }


    public void ignorableWhitespace(char[] cadena, int posinicio, int longitud)
            throws SAXException {
        // System.out.println("Es un blanco");
    }

}
