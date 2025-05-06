import java.time.Instant;

public class Invitacion {
    private Instant hora;

    public Instant getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Invitación a la/s " + hora + " hora/s";
    }
}
