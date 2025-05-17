package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
/**
 * Es una extension de la clase reunion que representa aquellas reuniones presenciales.
 */
public class ReunionPresencial extends Reunion {
    private String sala;

    /**
     * @return la sala en la que se realiza la reunion.
     */
    public String getSala() { return sala; }

    /**
     * Inicializa la Reunion Presencial.
     * @param fecha: fecha de creación.
     * @param horaPrevista: hora prevista en la que debería iniciar la reunion.
     * @param tipoReunion: tipo(técnica, marketing, otro).
     * @param duracionPrevista: duración prevista que debería durar la reunion.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, TipoReunion tipoReunion, Duration duracionPrevista) {
        super(fecha, horaPrevista, tipoReunion, duracionPrevista);
    }

    /**
     * @return la modalidad de la reunion. (presencial en este caso)
     */
    @Override
    public Modalidad getModalidad() { return Modalidad.Presencial; }

    /**
     * @return información sobre el tipo de reunion y donde se realizó.
     */
    @Override
    public String toString() {
        return "Reunión presencial en la sala: " + sala;
    }
}
