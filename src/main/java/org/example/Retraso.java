package org.example;

import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant hora;

    public Retraso(Persona persona) {
        super(persona);
        hora = Instant.now();
    }

    @Override
    public String toString() {
        return "Retraso a la/s " + hora + " hora/s";
    }
}
