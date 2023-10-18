package vuelos;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorSAX extends DefaultHandler {

    private String xml;

    public ManejadorSAX() {
        xml = "";
    }

    public String getXmlResult() {
        return xml;
    }

    @Override
    public void startDocument() throws SAXException {
        xml += "Comienzo del documento XML \n";
    }

    @Override
    public void endDocument() throws SAXException {
        xml += "Fin del documento XML \n";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Comieno del elemento: "+ localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Fin del elemento: "+ localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // OPCIÓN 1
        xml += "Valor: " + new String(ch, start, length) + "\n";
    }
}
