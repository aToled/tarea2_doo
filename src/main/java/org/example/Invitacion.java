package org.example;
import java.time.Instant;

/**
 * Representa una invitación para una reunion ya sea virtual o presencial.
 */
public class Invitacion {
    public Reunion reunion;
    private final Instant hora;

    /**
     * Crea la invitación a la reunion especificada y almacena el momento de su creación.
     * @param reunion: la reunion a la que se quiere invitar.
     */
    public Invitacion(Reunion reunion) {
        this.reunion = reunion;
        hora = Instant.now();
    }

    /**
     * @return hora de creación de la invitación.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * @return la información relevante a la invitación con un formato legible para la hora.
     */
    @Override
    public String toString() {
        return "Invitación enviada a las " + Informe.formatear_hora(hora) + " horas ";
    }
}
