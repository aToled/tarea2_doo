package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class InformeTest {
    @Test
    void crear_y_revisar_informe() {
        Reunion reunion = new ReunionPresencial(new Date(1000000), Instant.now(), TipoReunion.MARKETING, Duration.ofMillis(100), "A3");
        Empleado e1 = new Empleado("empleado1", "Villalobos", "Khristian", "kvillalobos2024@udec.cl");
        Empleado e2 = new Empleado("empleado2", "Toledo", "Alonso", "itoledo2024@udec.cl");
        Empleado e3 = new Empleado("empleado3", "Toledo", "Ignacio", "itoledo2024@udec.cl");
        Empleado e4 = new Empleado("empleado3", "Ignacio", "Toledo", "itoledo2024@udec.cl");
        Persona p1=new Persona("persona1", "John", "Cena", "andHisNameIsJohnCena@gmail.com");

        reunion.crear_invitacion(e1);
        reunion.crear_invitacion(e2);
        reunion.crear_invitacion(e3);
        reunion.crear_invitacion(e4);
        reunion.crear_invitacion(p1);
        e1.resolver_invitacion(true);
        e2.resolver_invitacion(false);
        p1.resolver_invitacion(true);
        reunion.iniciar();

        reunion.agregarNota(new Nota("Objetivos"));
        reunion.agregarNota(new Nota("Desafíos"));

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            fail();
        }

        e3.resolver_invitacion(true);

        reunion.finalizar();

        e3.resolver_invitacion(true);

        reunion.invitaciones_Aceptadas();
        Informe.elaborarInforme(reunion);

        String contenidoEsperado = "Fecha: 1969-12-31\n" +
                "Hora prevista: 13:33:56\n" +
                "Hora inicio: 13:33:56\n" +
                "Hora final: 13:33:57\n" +
                "Duración Prevista: 0 horas con 0 minutos\n" +
                "Duración Real: 0 horas con 0 minutos\n" +
                "Tipo de reunión: marketing\n" +
                "Reunión presencial en la sala: A3\n" +
                "\n" +
                "Invitados:\n" +
                "1) Empleado: Khristian Villalobos, ID: empleado1, Correo: kvillalobos2024@udec.cl\n" +
                "2) Empleado: Alonso Toledo, ID: empleado2, Correo: itoledo2024@udec.cl\n" +
                "3) Empleado: Ignacio Toledo, ID: empleado3, Correo: itoledo2024@udec.cl\n" +
                "4) Empleado: Toledo Ignacio, ID: empleado3, Correo: itoledo2024@udec.cl\n" +
                "5) Persona: Cena John, ID: persona1, Correo: andHisNameIsJohnCena@gmail.com\n" +
                "\n" +
                "Porcentaje de asistencias: 50.0%\n" +
                "\n" +
                "Asistentes:\n" +
                "1) Empleado: Khristian Villalobos, ID: empleado1, Correo: kvillalobos2024@udec.cl\n" +
                "2) Persona: Cena John, ID: persona1, Correo: andHisNameIsJohnCena@gmail.com\n" +
                "\n" +
                "Retrasos:\n" +
                "1) Empleado: Ignacio Toledo, ID: empleado3, Correo: itoledo2024@udec.cl con retraso a las 13:33:57 horas\n" +
                "\n" +
                "Ausencias:\n" +
                "1) Empleado: Alonso Toledo, ID: empleado2, Correo: itoledo2024@udec.cl\n" +
                "2) Empleado: Toledo Ignacio, ID: empleado3, Correo: itoledo2024@udec.cl\n" +
                "\n" +
                "Notas de la reunión:\n" +
                "-Nota 1: Objetivos\n" +
                "-Nota 2: Desafíos\n\n";

        try {
            String text = new String(Files.readAllBytes(Paths.get("reunion 1969-12-31_21-16.txt")), StandardCharsets.UTF_8);
            assertEquals(contenidoEsperado, text);
        } catch (Exception e) {
            //
        }
    }

    @Test
    void formatear_hora() {
        Instant ahora = Instant.now();
        String ahoraFormatoEsperado = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault()).format(ahora);
        String ahoraFormato = Informe.formatear_hora(ahora);
        assertEquals(ahoraFormatoEsperado, ahoraFormato);
    }
}