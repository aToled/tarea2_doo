package org.example;

import java.util.ArrayList;

public class Departamento implements Invitable {
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    private String nombre;
    // TODO: Obtener número de empleados
    public int obtenerCantidadEmpleados() { return empleados.size(); }

    public String getNombre() {
        return nombre;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + " / Emleados: " + obtenerCantidadEmpleados();
    }
}