package org.example;

import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant hora;

    @Override
    public String toString() {
        return "Retraso a la/s " + hora + " hora/s";
    }
}
