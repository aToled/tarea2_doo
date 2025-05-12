package org.example;

public class Departamento implements Invitable {
    private String nombre;
    // TODO: Obtener número de empleados
    public int obtenerCantidadEmpleados() { return 0; }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + " / Emleados: " + obtenerCantidadEmpleados();
    }
}