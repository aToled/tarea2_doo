package org.example;
/**
 * La interfaz invitable la cual es implementada por Persona y Departamento. (porque ambas son entidades que pueden ser invitadas a una reunion)
 */
public interface Invitable {
    /**
     * @param invitacion: representa la invitación a una reunion.
     */
    void invitar(Invitacion invitacion);
}
