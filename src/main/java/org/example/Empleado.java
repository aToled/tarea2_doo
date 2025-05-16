package org.example;

public class Empleado implements Invitable {
    private final Departamento departamento;
    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;
    public Empleado(Departamento departamento, String id, String apellidos, String nombre, String correo){
        this.departamento = departamento;
        departamento.agregarEmpleado(this);
        this.id=id;
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.correo=correo;
    }

    public void invitar(Invitacion invitacion) {
        invitacion.reunion.invitacionAceptada(invitacion, this);
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

    public Departamento getDepartamento() { return departamento; }

    @Override
    public String toString(){
        return "Empleado: "+nombre+" "+apellidos+", ID: "+id+",Correo: "+correo;
    }
}
