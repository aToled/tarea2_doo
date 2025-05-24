package org.example;
import java.util.ArrayList;
/**
 * Representa un departamento específico de una empresa, Implementa la interfaz invitable, ya que departamentos enteros
 * pueden ser invitados a reuniones, contiene una lista de empleados que pertenecen a dicho departamento.
 */
public class Departamento implements Invitable {
    private final ArrayList<Empleado> empleados;
    private final String nombre;

    /**
     * Crea una instancia de un departamento con su respetivo nombre y empleados.
     * @param nombre: nombre del departamento.
     * @param empleados: lista de sus empleados.
     */
    public Departamento(String nombre, ArrayList<Empleado> empleados){
        this.nombre=nombre;
        this.empleados=empleados;
    }

    /**
     * Devuelve el número de empleados pertenecientes al departamento.
     * @return cantidad de empleados.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    /**
     * Devuelve el nombre del departamento.
     * @return nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Agrega un empleado al departamento.
     * @param empleado: empleado por ser agregado.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Realiza un ciclo que invita a todos los Empleados del departamento a una reunion.
     * @param invitacion: es la invitación a tal reunion.
     */
    public void invitar(Invitacion invitacion) {
        for (Empleado empleado : empleados) {
            empleado.invitar(invitacion);
        }
    }

    /**
     * Devuelve la lista de empleados pertenecientes al departamento.
     * @return la lista de empleados.
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @return la información relevante al departamento.
     */
    @Override
    public String toString() {
        return "Departamento: " + nombre + " / Empleados: " + getEmpleados().toString();
    }
}