package org.example;
import java.time.Instant;
/**
 * Representa a una persona la cual es invitable a una reunion y puede o no pertenecer a un departamento.
 */
public class Persona implements Invitable {
    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;
    private Instant hora_de_aceptacion_invitacion;

    /**
     * Inicializa a tal persona con sus datos correspóndientes.
     * @param id: número identificador de la persona.
     * @param apellidos: apellidos de la persona.
     * @param nombre: nombre de la persona.
     * @param correo: correo de la persona.
     */
    public Persona(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Imprime en consola la invitación a la reunion recibida.
     * @param invitacion: representa la invitación a una reunion.
     */
    public void invitar(Invitacion invitacion) {
        System.out.println("Invitation: "+invitacion.toString()+"recibida por: "+this.toString());
    }

    /**
     * Es el método que permite a la persona unirse a la reunion y que almacena la hora en la que esta se unió.
     * @param estado_aceptacion: es la decision que tomo la persona si es que se unirá o no a la reunion.
     */
    public void resolver_invitacion(boolean estado_aceptacion){
        if(estado_aceptacion){
            this.hora_de_aceptacion_invitacion=Instant.now();
        }else{
            this.hora_de_aceptacion_invitacion=null;
        }
    }

    /**
     * Al ser llamado devuelve un string con el número identificador de la persona.
     * @return dicho identificador.
     */
    public String getId() {
        return id;
    }

    /**
     * Al ser llamado devuelve un string con los apellidos de la persona.
     * @return dichos apellidos.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Al ser llamado devuelve un string con el nombre de la persona.
     * @return dicho nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Al ser llamado devuelve un string con el correo de la persona.
     * @return dicho correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Al ser llamado devuelve el instante en el que la persona acepto la invitación a la reunion.
     * @return dicho instante.
     */
    public Instant getHora_de_aceptacion_invitacion() {
        return hora_de_aceptacion_invitacion;
    }

    /**
     * @return la información relevante a la persona.
     */
    @Override
    public String toString(){
        return "Persona: "+nombre+" "+apellidos+", ID: "+id+", Correo: "+correo;
    }
}
