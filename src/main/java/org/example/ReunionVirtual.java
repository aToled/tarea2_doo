package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
/**
 * Es una extension de la clase reunion que representa aquellas reuniones virtuales.
 */
public class ReunionVirtual extends Reunion{
    private String enlace;

    /**
     * @return el enlace en la que se realiza la reunion.
     */
    public String getEnlace() { return enlace; }

    /**
     * Inicializa la Reunion Virtual.
     * @param fecha: fecha de creación.
     * @param horaPrevista: hora prevista en la que debería iniciar la reunion.
     * @param tipoReunion: tipo(técnica, marketing, otro).
     * @param duracionPrevista: duración prevista que debería durar la reunion.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, TipoReunion tipoReunion, Duration duracionPrevista) {
        super(fecha, horaPrevista, tipoReunion, duracionPrevista);
    }

    /**
     * @return la modalidad de la reunion. (virtual en este caso)
     */
    @Override
    public Modalidad getModalidad() { return Modalidad.Virtual; }

    /**
     * @return información sobre el tipo de reunion y donde se realizó.
     */
    @Override
    public String toString() {
        return "Reunión virtual en el enlace: " + enlace;
    }
}
