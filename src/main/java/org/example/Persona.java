package org.example;

import java.time.Instant;

public class Persona implements Invitable {
    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;
    private boolean invitacion_recepcionada;
    private Instant hora_de_aceptacion_invitacion;

    public Persona(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    public void invitar(Invitacion invitacion) {
        this.invitacion_recepcionada=true;
        System.out.println("Invitation: "+invitacion.toString()+"recibida por: "+this.toString());
    }

    public void resolver_invitacion(boolean invitacion_recepcionada, boolean estado_aceptacion){
        if(invitacion_recepcionada){
            if(estado_aceptacion){
                this.hora_de_aceptacion_invitacion=Instant.now();
            }else{
                this.hora_de_aceptacion_invitacion=null;
            }
        }
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

    public Instant getHora_de_aceptacion_invitacion() {
        return hora_de_aceptacion_invitacion;
    }

    @Override
    public String toString(){
        return "Persona: "+nombre+" "+apellidos+", ID: "+id+", Correo: "+correo;
    }
}
