package org.example;

import java.util.ArrayList;

public class Departamento implements Invitable {
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private final String nombre;

    public Departamento(String nombre, ArrayList<Empleado> empleados){
        this.nombre=nombre;
        this.empleados=empleados;
    }

    // TODO: Obtener número de empleados
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void invitar(Invitacion invitacion) {
        for (Empleado empleado : empleados) {
            invitacion.reunion.invitacionAceptada(invitacion, empleado);
        }
    }

    public ArrayList<Empleado> getEmpleados() { return empleados; }

    @Override
    public String toString() {
        return "Departamento: " + nombre + " / Emleados: " + obtenerCantidadEmpleados();
    }
}