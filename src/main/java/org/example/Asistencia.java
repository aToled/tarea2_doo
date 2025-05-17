package org.example;
/**
 * Representa una lista de asistencia, la cual es usada por la clase Reunion para mantener un registro de las Personas asistentes a una instancia de reunion.
 */
public class Asistencia {
    private final Persona persona;

    /**
     * Guarda la referencia de la persona presente.
     * @param persona: la persona en cuestión que se registra como presente.
     */
    public Asistencia(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return la persona registrada como presente en el método anterior.
     */
    public Persona getPersona() {
        return persona;
    }
}
