public class ReunionVirtual extends Reunion{
    private String enlace;

    public String getEnlace() {
        return enlace;
    }

    @Override
    public Modalidad getModalidad() { return Modalidad.Virtual; }

    @Override
    public String toString() {
        return "Reunión virtual en el enlace: " + enlace;
    }
}
