package org.example;

import java.time.Instant;

public class Invitacion {
    public Reunion reunion;
    private Instant hora;

    public Invitacion(Reunion reunion) {
        this.reunion = reunion;
        hora = Instant.now();
    }

    public Instant getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Invitación a la/s " + hora + " hora/s";
    }
}
