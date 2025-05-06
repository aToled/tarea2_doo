public class ReunionPresencial extends Reunion {
    private String sala;

    public String getSala() { return sala; }

    @Override
    public Modalidad getModalidad() { return Modalidad.Presencial; }

    @Override
    public String toString() {
        return "Reunión presencial en la sala: " + sala;
    }
}
