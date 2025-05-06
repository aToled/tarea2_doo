public class Departamento implements Invitable{
    private String nombre;
    public int obtenerCantidadEmpleados(){}

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + " / Emleados: " + obtenerCantidadEmpleados();
    }
}
