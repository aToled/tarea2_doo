package org.example;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Reunion reunion = new ReunionPresencial(new Date(1000), Instant.now(), TipoReunion.MARKETING, Duration.ofMinutes(90),"A3");

        reunion.iniciar();

        reunion.finalizar();

        Informe.elaborarInforme(reunion);
    }
}
