import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horainicio;
    private Instant horaFin;
    private tipoReunion tipoDeReunion;

    public List obtenerAsistencias(){}
    public List obtenerAusencias(){}
    public List obtenerRetrasos(){}
    public List<Nota> obtenerNotas() {}
    public int obtenerTotalAsistencia() { return obtenerAsistencias().size(); }
    public int obtenerTotalAusencias() { return obtenerAusencias().size(); }
    public int obtenerTotalRetrasos() { return obtenerRetrasos().size(); }
    public int obtenerTotalNotas() { return obtenerNotas().size(); }
    public float obtenerPorcentajeAsistencia(){}
    public float calcularTiempoReal() {
        return ChronoUnit.MINUTES.between(horaFin, horainicio);
    }
    public void iniciar(){
        horainicio=Instant.now();
    }
    public void finalizar(){
        horaFin=Instant.now();
    }

    protected enum Modalidad {
        Presencial, Virtual;
    }

    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public Instant getHorainicio() {
        return horainicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public tipoReunion getTipoDeReunion() { return tipoDeReunion; }

    abstract protected Modalidad getModalidad();

    public void elaborarInforme(String accesoReunion) {
        // todas las notas relacionadas con la reunión (ordenadas cronológicamente)
        String nombreInforme = "reunion" + fecha.toString() + ":" + horainicio.toString();

        try {
            FileWriter fw = new FileWriter("reuniones/" + nombreInforme);

            // write the string to the file
            fw.write("Fecha: " + fecha);
            fw.write("Hora prevista: " + horaPrevista);
            fw.write("Hora inicio: " + horainicio);
            fw.write("Hora final: " + horaFin);
            int diferenciaMinutos = (int)calcularTiempoReal();
            int diferenciaHoras = diferenciaMinutos / 60;
            diferenciaMinutos -= (diferenciaHoras * 60);

            fw.write("Duración: " + diferenciaHoras + " horas con " + diferenciaMinutos + " minutos");
            fw.write("Tipo de reunión: " + getTipoDeReunion());

            if (getModalidad() == Modalidad.Presencial) {
                fw.write("Sala: " + accesoReunion);
            } else if (getModalidad() == Modalidad.Virtual) {
                fw.write("Enlace: " + accesoReunion);
            } else {
                fw.write("Sala o enlace desconocido");
            }

            // Redondeo a 1 decimal despues de la coma
            float porcentaje = Math.round(obtenerPorcentajeAsistencia() * 10.0f) / 10.0f;
            fw.write("Porcentaje de asistencias: " + porcentaje);

            fw.write("Participantes:");
            List participantes = obtenerAsistencias();
            for (int i = 0; i < obtenerTotalAsistencia(); i++) {
                fw.write((i+1) + ") " + participantes.get(i).toString());
            }

            fw.write("");
            fw.write("Retrasos:");
            List retrasos = obtenerRetrasos();
            for (int i = 0; i < obtenerTotalRetrasos(); i++) {
                fw.write((i+1) + ") " + retrasos.get(i).toString());
            }

            fw.write("");
            fw.write("Ausencias:");
            List ausencias = obtenerAusencias();
            for (int i = 0; i < obtenerTotalAusencias(); i++) {
                fw.write((i+1) + ") " + ausencias.get(i).toString());
            }

            fw.write("");
            fw.write("Notas de la reunión:");
            List<Nota> notas = obtenerNotas();
            for (Nota nota : notas) {
                fw.write("-" + nota.getContenido());
            }

            // close the writer
            fw.close();

            System.out.println("Informe generado exitosamente");

        } catch (IOException e) {
            System.out.println("Error al tratar de escribir informe: " + e);
        }
    }

    @Override
    public String toString() {
        return "Reunión a las " + fecha.toString() +
                "\nhora prevista: " + horaPrevista +
                "\nduración prevista: " + duracionPrevista +
                "\nhora inicio: " + horainicio.toString() +
                "\nhora fin: " + horaFin.toString();
    }
}
