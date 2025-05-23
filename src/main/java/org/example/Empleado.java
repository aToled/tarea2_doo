package org.example;
/**
 * Representa a un empleado perteneciente a un departamento.
 */
public class Empleado extends Persona{
    /**
     * Inicializa a tal empleado con sus datos correspóndientes.
     * @param id: número identificador del empleado.
     * @param apellidos: apellidos del empleado.
     * @param nombre: nombre del empleado.
     * @param correo: correo del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo){
        super(id,apellidos,nombre,correo);
    }

    /**
     * @return la información relevante al empleado.
     */
    @Override
    public String toString(){
        return "Empleado: "+getNombre()+" "+getApellidos()+", ID: "+getId()+", Correo: "+getCorreo();
    }
}
