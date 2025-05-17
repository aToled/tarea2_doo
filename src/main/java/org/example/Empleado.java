package org.example;

public class Empleado extends Persona implements Invitable {
    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;

    public Empleado(String id, String apellidos, String nombre, String correo) {
        super(id, apellidos, nombre, correo);
        this.id=id;
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.correo=correo;
    }

    public void invitar(Invitacion invitacion) {
        invitacion.reunion.invitacionAceptada(invitacion, this);
    }

    @Override
    public String toString(){
        return "Empleado: "+nombre+" "+apellidos+", ID: "+id+", Correo: "+correo;
    }
}
