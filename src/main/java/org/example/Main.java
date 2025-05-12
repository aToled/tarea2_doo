package org.example;

import java.sql.Date;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Reunion reunion = new ReunionPresencial(new Date(1000), Instant.now());

        reunion.iniciar();

        reunion.finalizar();

        reunion.elaborarInforme("Sala A3");
    }
}
