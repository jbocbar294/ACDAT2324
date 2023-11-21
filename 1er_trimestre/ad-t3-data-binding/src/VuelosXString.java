import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import modelo.Vuelo;
import modelo.Vuelos;

public class VuelosXString {

    public static void main(String[] args) {

        Vuelos vuelos = new Vuelos();

        // inicialización y agregación de objetos al contenedor
        vuelos.add(new Vuelo("Sevilla (SEV)", "Madrid (MAD)"));
        vuelos.add(new Vuelo("Madrid (MAD)", "Barcelona (BCN)"));

        // serialización/marshalling (memoria --> xml)
        System.out.println("XML: " + new VuelosXString().serializarXML(vuelos));

        // serialización/marshalling (memoria --> json)
        System.out.println("JSON: " + new VuelosXString().serializarJSON(vuelos));

    }

    public String serializarXML(Vuelos vuelos) {
        return serializar(vuelos, "xml");
    }

    public String serializarJSON(Vuelos vuelos) {
        return serializar(vuelos, "json");
    }

    private String serializar(Vuelos vuelos, String format) {

        String result = null;

        try {
            XStream contexto = null;
            switch (format) {
                case "xml":
                    // crea una instancia XStream (usando el parser StAX)
                    contexto = new XStream(new StaxDriver());
                    break;

                case "json":
                    // crea una instancia XStream (usando Jettison)
                    contexto = new XStream(new JettisonMappedXmlDriver());
                    break;
            }

            // 2. Vinculación de clases entre nombres de elementos
            contexto.alias("Vuelos", Vuelos.class);
            contexto.alias("Vuelo", Vuelo.class);

            // 3. Vinculación de la colección de objetos que contiene el atributo
            contexto.addImplicitCollection(Vuelos.class, "listaVuelos");

            // 4. serialización (marshall) de la colección de objetos
            result = contexto.toXML(vuelos);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

}
