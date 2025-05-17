package org.example;

import org.junit.jupiter.api.Test;

import javax.xml.datatype.Duration;
import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    @Test
    void crearReunion() {
        Reunion reunion = new ReunionPresencial(new Date(1000000), Instant.now(), TipoReunion.MARKETING);

        reunion.iniciar();

        reunion.crear_invitacion(new Empleado("empleado1", "Villalobos", "Khristian", "kvillalobos2024@udec.cl"));
        reunion.crear_invitacion(new Empleado("empleado2", "Toledo", "Alonso", "AToledo2024@udec.cl"));

        reunion.agregarNota(new Nota(1, "Objetivos"));
        reunion.agregarNota(new Nota(2, "Desafíos"));

        reunion.finalizar();

        reunion.elaborarInforme("Sala A3");
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