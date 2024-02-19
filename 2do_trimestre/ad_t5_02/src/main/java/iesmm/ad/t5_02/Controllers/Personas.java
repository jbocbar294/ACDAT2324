package iesmm.ad.t5_02.Controllers;

import iesmm.ad.t5_02.model.Persona;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/personas")
public class Personas {

    private List<Persona> personas;

    public Personas() {
        personas = new ArrayList<Persona>();
        personas.add(new Persona("Juanma", "Boca", 19));
        personas.add(new Persona("Nico", "Collado", 20));
        personas.add(new Persona("Mohamed", "Labib", 19));
    }

    @GetMapping(value = "/persona", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Persona getPersona() {
        return new Persona("maria", "sosa", 20);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Persona> getPersonas() {
        return this.personas;
    }

    @GetMapping(value = "/persona/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Persona getPersonaXML() {
        return new Persona("maria", "sosa", 20);
    }

    @GetMapping(value = "/personas/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<Persona> getPersonasXML() {
        return this.personas;
    }

}