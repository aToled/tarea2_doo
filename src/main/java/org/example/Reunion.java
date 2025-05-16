package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horainicio;
    private Instant horaFin;
    private TipoReunion tipoDeReunion;
    private ArrayList<Nota> notas;

    public Reunion() {}

    public Reunion(Date fecha, Instant horaPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
    }

    // TODO: Obtener una lista de asistencias, ausencias, retrasos y notas de alguna parte
    public List obtenerAsistencias() { return new ArrayList<>(); }
    public List obtenerAusencias() { return new ArrayList<>(); }
    public List obtenerRetrasos() { return new ArrayList<>(); }
    public List<Nota> obtenerNotas() { return notas; }
    public int obtenerTotalAsistencia() { return obtenerAsistencias().size(); }
    public int obtenerTotalAusencias() { return obtenerAusencias().size(); }
    public int obtenerTotalRetrasos() { return obtenerRetrasos().size(); }
    public int obtenerTotalNotas() { return obtenerNotas().size(); }
    public float obtenerPorcentajeAsistencia() {
        float asistencias = obtenerTotalAsistencia();
        float ausencias = obtenerTotalAusencias();

        return ausencias / (asistencias + ausencias);
    }

    public void agregarNota(Nota nota) { notas.add(nota); }
    public void quitarNota(int indice) { if (indice < 0 || indice >= notas.size()) return; else {notas.remove(indice);}}

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

    public TipoReunion getTipoDeReunion() { return tipoDeReunion; }

    abstract protected Modalidad getModalidad();

    public void elaborarInforme(String accesoReunion) {
        // todas las notas relacionadas con la reunión (ordenadas cronológicamente)
        String nombreInforme = "reunion" + fecha;

        // Crear archivo
        try {
            File myObj = new File("reuniones/" + nombreInforme + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("reuniones/" + nombreInforme + ".txt");

            // write the string to the file
            fw.write("Fecha: " + fecha + "\n");
            fw.write("Hora prevista: " + horaPrevista + "\n");
            fw.write("Hora inicio: " + horainicio + "\n");
            fw.write("Hora final: " + horaFin + "\n");
            int diferenciaMinutos = (int)calcularTiempoReal();
            int diferenciaHoras = diferenciaMinutos / 60;
            diferenciaMinutos -= (diferenciaHoras * 60);

            fw.write("Duración: " + diferenciaHoras + " horas con " + diferenciaMinutos + " minutos\n");
            fw.write("Tipo de reunión: " + getTipoDeReunion());

            if (getModalidad() == Modalidad.Presencial) {
                fw.write("Sala: " + accesoReunion + "\n");
            } else if (getModalidad() == Modalidad.Virtual) {
                fw.write("Enlace: " + accesoReunion + "\n");
            } else {
                fw.write("Sala o enlace desconocido\n");
            }

            // Redondeo a 1 decimal despues de la coma
            float porcentaje = Math.round(obtenerPorcentajeAsistencia() * 10.0f) / 10.0f;
            fw.write("Porcentaje de asistencias: " + porcentaje + "\n");

            fw.write("Participantes:\n");
            List participantes = obtenerAsistencias();
            for (int i = 0; i < obtenerTotalAsistencia(); i++) {
                fw.write((i+1) + ") " + participantes.get(i).toString() + "\n");
            }

            fw.write("\n");
            fw.write("Retrasos:\n");
            List retrasos = obtenerRetrasos();
            for (int i = 0; i < obtenerTotalRetrasos(); i++) {
                fw.write((i+1) + ") " + retrasos.get(i).toString() + "\n");
            }

            fw.write("\n");
            fw.write("Ausencias:\n");
            List ausencias = obtenerAusencias();
            for (int i = 0; i < obtenerTotalAusencias(); i++) {
                fw.write((i+1) + ") " + ausencias.get(i).toString() + "\n");
            }

            fw.write("\n");
            fw.write("Notas de la reunión:\n");
            List<Nota> notas = obtenerNotas();
            for (Nota nota : notas) {
                fw.write("-" + nota.toString() + "\n");
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
