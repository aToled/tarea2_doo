package org.example;
/**
 * Representa a un empleado perteneciente a un departamento.
 */
public class Empleado extends Persona{
    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;

    /**
     * Inicializa a tal empleado con sus datos correspóndientes.
     * @param id: número identificador del empleado.
     * @param apellidos: apellidos del empleado.
     * @param nombre: nombre del empleado.
     * @param correo: correo del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo){
        super(id,apellidos,nombre,correo);
        this.id=id;
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.correo=correo;
    }

    /**
     * @return la información relevante al empleado.
     */
    @Override
    public String toString(){
        return "Empleado: "+nombre+" "+apellidos+", ID: "+id+", Correo: "+correo;
    }
}
