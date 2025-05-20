package org.example;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Representa una reunion con la fecha de su creación, la hora prevista de inicio, duración prevista,
 * su hora real de inicio, hora de finalización, si la de reunion es virtual o presencial, y de qué tipo es (técnica, marketing, otro).
 * Esta clase también contiene listas de las personas que fueron invitadas, que asistieron, que se retrasaron, que se ausentaron,
 * y de las posibles notas tomadas durante la reunion por su anfitrión. (a la vez contiene parte de la lógica para recopilar tales datos)
 * Además maneja el reparto de invitaciones.
 */
public abstract class Reunion {
    private final Date fecha;
    private final Instant horaPrevista;
    private final Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private final TipoReunion tipoDeReunion;
    private final ArrayList<Persona> lista_invitados = new ArrayList<>();
    private final ArrayList<Asistencia> asistencias = new ArrayList<>();
    private final ArrayList<Persona> ausencias = new ArrayList<>();
    private final ArrayList<Retraso> retrasos = new ArrayList<>();
    private final ArrayList<Nota> notas = new ArrayList<>();

    /**
     * Crea la Reunion.
     * @param fecha: fecha de creación.
     * @param horaPrevista: hora prevista en la que debería iniciar la reunion.
     * @param tipoDeReunion: tipo(técnica, marketing, otro).
     * @param duracionPrevista: duración prevista que debería durar la reunion.
     */
    public Reunion(Date fecha, Instant horaPrevista, TipoReunion tipoDeReunion, Duration duracionPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.tipoDeReunion = tipoDeReunion;
        this.duracionPrevista=duracionPrevista;
    }

    /**
     * @return la lista de invitados.
     */
    public List<Persona> obtenerInvitados() { return lista_invitados; }

    /**
     * @return la lista de asistencias.
     */
    public List<Asistencia> obtenerAsistencias() { return asistencias; }

    /**
     * @return la lista de ausencias.
     */
    public List<Persona> obtenerAusencias() { return ausencias; }

    /**
     * @return la lista de retrasos.
     */
    public List<Retraso> obtenerRetrasos() { return retrasos; }

    /**
     * @return la lista de notas.
     */
    public List<Nota> obtenerNotas() { return notas; }

    /**
     * @return el porcentaje de asistencia mediante el cociente entre el total de ausencias y el total de invitados.
     */
    public float obtenerPorcentajeAsistencia() {
        if(!lista_invitados.isEmpty()) {
            return (float) (asistencias.size()+retrasos.size()) / lista_invitados.size();
        }else
            return 100f;
    }

    /**
     * Agrega una nota al final de la lista de notas de la reunion.
     * @param nota: nota a ser agregada a la lista de notas.
     */
    public void agregarNota(Nota nota) {
        nota.setNumeroNota(notas.size()+1);
        notas.add(nota);
    }

    /**
     * Quita la nota indicada por el índice, pero primero verifica que el índice ingresado sea válido.
     * @param indice: índice que indica que nota quitar de la lista.
     */
    public void quitarNota(int indice) {
        if (indice < 0 || indice >= notas.size()) return;
        else {notas.remove(indice);}
    }

    /**
     * Calcula el tiempo entre la hora de fin de la reunion y el inicio asi resultando en el tiempo que duro realmente.
     * @return tiempo en minutos.
     */
    public float calcularTiempoReal() {
        return ChronoUnit.MINUTES.between(horaFin, horaInicio);
    }

    /**
     * Inicia la reunion indicando la hora de inicio como el instante en que se utilizo el método.
     */
    public void iniciar(){
        horaInicio =Instant.now();
    }

    /**
     * Finaliza la reunion indicando la hora de fin como el instante en que se utilizo el método.
     */
    public void finalizar(){
        horaFin=Instant.now();
    }

    /**
     * Devuelve la fecha en que se creó la reunion.
     * @return tal fecha.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Devuelve la hora en la que estaba previsto que iniciara la reunion.
     * @return tal hora
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Devuelve la duración prevista de la reunion.
     * @return tal duración.
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * Devuelve el instante en el que se creó la reunion.
     * @return tal instante.
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /**
     * Devuelve el instante en el que se terminó la reunion.
     * @return tal instante.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Devuelve el tipo de reunion creada.
     * @return tal tipo.
     */
    public TipoReunion getTipoDeReunion() { return tipoDeReunion; }

    /**
     * Devuelve la modalidad de la reunion.
     * @return tal modalidad.
     */
    abstract protected Modalidad getModalidad();

    /**
     * Crea la invitación e invita a una persona.
     * @param persona: la persona a invitar a la reunion.
     */
    public void crear_invitacion(Persona persona) {
        Invitacion invitacion = new Invitacion(this);
        persona.invitar(invitacion);
        lista_invitados.add(persona);
    }

    /**
     * Verifica de la lista de personas invitadas si esta se unió a tiempo, con atraso, o si directamente no se unió.
     * al primero verificar que la hora en que se aceptó la invitación es no nula (acepto la invitación) para posteriormente
     * comparar la diferencia entre la hora que se unió (hora de aceptación) y la hora de inicio. (si es una diferencia negativa o igual a 0 significa que se
     * unió antes o justo a tiempo, si es positiva significa que se unió después de que inicio la reunion, por lo tanto, atrasado)
     */
    public void invitaciones_Aceptadas() {
        if (horaInicio == null) {
            return;
        }
        for (Persona invitado : lista_invitados) {
            Instant aceptacion = invitado.getHora_de_aceptacion_invitacion();

            if (aceptacion != null) {
                if (aceptacion.compareTo(horaInicio) <= 0) {
                    asistencias.add(new Asistencia(invitado));
                } else if (aceptacion.compareTo(horaInicio) > 0 && aceptacion.compareTo(horaFin) <= 0) {
                    retrasos.add(new Retraso(invitado));
                }
            } else {
                ausencias.add(invitado);
            }
        }
    }

    /**
     * @return información relevante a las fechas y horas de la reunion.
     */
    @Override
    public String toString() {
        return "Reunión a las " + fecha.toString() +
                "\nhora prevista: " + horaPrevista +
                "\nduración prevista: " + duracionPrevista +
                "\nhora inicio: " + horaInicio.toString() +
                "\nhora fin: " + horaFin.toString();
    }
}
