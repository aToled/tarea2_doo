package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    @Test
    void crearReunion() throws InterruptedException {
        Reunion reunion = new ReunionPresencial(new Date(1000000), Instant.now(), TipoReunion.MARKETING, Duration.ofMinutes(90),"A3");
        Empleado e1=new Empleado("empleado1", "Villalobos", "Khristian", "kvillalobos2024@udec.cl");
        Empleado e2=new Empleado("empleado2", "Toledo", "Alonso", "itoledo2024@udec.cl");
        Empleado e3=new Empleado("empleado3", "Toledo", "Ignacio", "itoledo2024@udec.cl");
        reunion.crear_invitacion(e1);
        reunion.crear_invitacion(e2);
        reunion.crear_invitacion(e3);
        e1.resolver_invitacion(true);
        e2.resolver_invitacion(false);
        reunion.iniciar();
        TimeUnit.SECONDS.sleep(1);
        e3.resolver_invitacion(true);
        TimeUnit.SECONDS.sleep(1);

        reunion.agregarNota(new Nota(1, "Objetivos"));
        reunion.agregarNota(new Nota(2, "Desafíos"));

        reunion.finalizar();

        reunion.invitaciones_Aceptadas();
        Informe.elaborarInforme(reunion);
    }

    @Test
    void obtenerAsistencias() {
    }

    @Test
    void obtenerAusencias() {
    }

    @Test
    void obtenerRetrasos() {
    }

    @Test
    void obtenerNotas() {
    }

    @Test
    void obtenerTotalAsistencia() {
    }

    @Test
    void obtenerTotalAusencias() {
    }

    @Test
    void obtenerTotalRetrasos() {
    }

    @Test
    void obtenerTotalNotas() {
    }

    @Test
    void obtenerPorcentajeAsistencia() {
    }

    @Test
    void agregarNota() {
    }

    @Test
    void quitarNota() {
    }

    @Test
    void calcularTiempoReal() {
    }

    @Test
    void iniciar() {
    }

    @Test
    void finalizar() {
    }

    @Test
    void getFecha() {
    }

    @Test
    void getHoraPrevista() {
    }

    @Test
    void getDuracionPrevista() {
    }

    @Test
    void getHorainicio() {
    }

    @Test
    void getHoraFin() {
    }

    @Test
    void getTipoDeReunion() {
    }

    @Test
    void getModalidad() {
    }

    @Test
    void elaborarInforme() {
    }

    @Test
    void invitar() {
    }

    @Test
    void invitaciones_Aceptadas() {
    }

    @Test
    void testToString() {
    }
}