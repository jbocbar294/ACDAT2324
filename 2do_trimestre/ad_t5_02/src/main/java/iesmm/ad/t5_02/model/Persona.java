package iesmm.ad.t5_02.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "persona") // asi al entrar en la pagina que devuelve el xml, el primer elemento no es "Persona" sino "persona"
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    // Constructor por defecto
    public Persona() { }

    // Constructor copia
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.apellidos = persona.apellidos;
        this.edad = persona.edad;
    }

    // Constructor
    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean mayorEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        String datos = this.nombre + "\n";
        datos += this.apellidos + "\n";
        datos += this.edad + "\n";
        return datos;
    }
}