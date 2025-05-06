import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public String getSala() { return sala; }

    public ReunionPresencial() {}

    public ReunionPresencial(Date fecha, Instant horaPrevista) {
        super(fecha, horaPrevista);
    }

    @Override
    public Modalidad getModalidad() { return Modalidad.Presencial; }

    @Override
    public String toString() {
        return "Reunión presencial en la sala: " + sala;
    }
}
