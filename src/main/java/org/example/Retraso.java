package org.example;
import java.time.Instant;
/**
 * Clase usada por Reunion para mantener un registro de aquellas personas que asistieron, pero que están atrasadas.
 */
public class Retraso extends Asistencia{
    private final Instant hora;

    /**
     * Guarda la referencia de la persona atrasada.
     * @param persona: la persona en cuestión que se registra como atrasada.
     */
    public Retraso(Persona persona) {
        super(persona);
        hora = Instant.now();
    }

    /**
     * @return la hora de ingreso a la reunion.
     */
    @Override
    public String toString() {
        return getPersona().toString()+ " con retraso a las " + Informe.formatear_hora(hora) + " horas";
    }
}
