package org.example;

public class Persona {
    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;

    public Persona(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString(){
        return "Persona: "+nombre+" "+apellidos+", ID: "+id+", Correo: "+correo;
    }
}
