package org.example;

public class Persona implements Invitable {
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

    public void invitar(Invitacion invitacion) {
        invitacion.reunion.invitacionAceptada(invitacion, this);
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
