package ej2;

import java.io.Serializable;

public class Contacto implements Serializable {

    private String nombre, apellido1, apellido2, email;
    private int telhome, telmovil;
    private int extension;

    // constructor

    public Contacto(String nombre, String apellido1, String apellido2, String email, int telhome, int telmovil, int extension) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.telhome = telhome;
        this.telmovil = telmovil;
        this.extension = extension;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelhome() {
        return telhome;
    }

    public void setTelhome(int telhome) {
        this.telhome = telhome;
    }

    public int getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(int telmovil) {
        this.telmovil = telmovil;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }
}