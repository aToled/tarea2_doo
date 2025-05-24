package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    @Test
    void crearReunion() throws InterruptedException {
        Reunion reunion = new ReunionPresencial(new Date(1000000), Instant.now(), TipoReunion.MARKETING, Duration.ofMinutes(90),"A3");
        Empleado e1=new Empleado("empleado1", "Villalobos", "Khristian", "kvillalobos2024@udec.cl");
        Empleado e2=new Empleado("empleado2", "Toledo", "Alonso", "itoledo2024@udec.cl");
        Empleado e3=new Empleado("empleado3", "Toledo", "Ignacio", "itoledo2024@udec.cl");
        Persona p1=new Persona("persona1", "John", "Cena", "andHisNameIsJohnCena@gmail.com");
        reunion.crear_invitacion(e1);
        reunion.crear_invitacion(e2);
        reunion.crear_invitacion(e3);
        reunion.crear_invitacion(p1);
        e1.resolver_invitacion(true);
        e2.resolver_invitacion(false);
        p1.resolver_invitacion(true);
        reunion.iniciar();
        TimeUnit.SECONDS.sleep(1);
        e3.resolver_invitacion(true);
        TimeUnit.SECONDS.sleep(1);

        reunion.agregarNota(new Nota("Objetivos"));
        reunion.agregarNota(new Nota("Desafíos"));

        reunion.finalizar();

        reunion.invitaciones_Aceptadas();

        assertEquals(2, reunion.obtenerAsistencias().size());
        assertEquals(1, reunion.obtenerAusencias().size());
        assertEquals(1, reunion.obtenerRetrasos().size());

        assertEquals(2, reunion.obtenerNotas().size());

        Informe.elaborarInforme(reunion);
    }

    @Test
    void verificar_asistencias_atrasos_e_inasistencias() throws InterruptedException {
        Reunion reunion = new ReunionPresencial(new Date(1000000), Instant.now(), TipoReunion.MARKETING, Duration.ofMinutes(90),"A3");
        Empleado e1=new Empleado("empleado1", "Villalobos", "Khristian", "kvillalobos2024@udec.cl");
        Empleado e2=new Empleado("empleado2", "Toledo", "Alonso", "itoledo2024@udec.cl");
        Empleado e3=new Empleado("empleado3", "Toledo", "Ignacio", "itoledo2024@udec.cl");
        Persona p1=new Persona("persona1", "John", "Cena", "andHisNameIsJohnCena@gmail.com");
        reunion.crear_invitacion(e1);
        reunion.crear_invitacion(e2);
        reunion.crear_invitacion(e3);
        reunion.crear_invitacion(p1);
        e1.resolver_invitacion(true);
        e2.resolver_invitacion(false);
        p1.resolver_invitacion(true);
        reunion.iniciar();
        TimeUnit.SECONDS.sleep(1);
        e3.resolver_invitacion(true);

        reunion.finalizar();

        reunion.invitaciones_Aceptadas();

        int asistencias = reunion.obtenerAsistencias().size();
        int retrasos = reunion.obtenerRetrasos().size();
        int ausencias = reunion.obtenerAusencias().size();

        assertEquals(2, asistencias);
        assertEquals(1, retrasos);
        assertEquals(1, ausencias);
        assertEquals(3.f/4.f, (float) (asistencias + retrasos) / (asistencias+retrasos+ausencias));
    }

    @Test
    void verificar_notas() {
        Reunion reunion = new ReunionPresencial(new Date(1000000), Instant.now(), TipoReunion.MARKETING, Duration.ofMinutes(90),"A3");
        reunion.iniciar();

        reunion.agregarNota(new Nota("abc"));
        reunion.agregarNota(new Nota("def"));
        reunion.agregarNota(new Nota("ghi"));

        reunion.finalizar();

        List<Nota> notas = reunion.obtenerNotas();
        assertEquals("Nota 1: abc", notas.get(0).toString());
        assertEquals("Nota 2: def", notas.get(1).toString());
        assertEquals("Nota 3: ghi", notas.get(2).toString());
    }
}