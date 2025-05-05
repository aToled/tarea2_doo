import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horainicio;
    private Instant horaFin;

    public List obtenerAsistencias(){}
    public List obtenerAusencias(){}
    public List obtenerRetrasos(){}
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public float calcularTiempoReal(){}
    public void iniciar(){}
    public void finalizar(){}
}
