public class ReunionPresencial extends Reunion {
    private String sala;

    public String getSala() {
        return sala;
    }

    @Override
    public String toString() {
        return "Reunión presencial en la sala: " + sala;
    }
}
