package org.example;

import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public String getEnlace() {
        return enlace;
    }

    public ReunionVirtual() {}

    public ReunionVirtual(Date fecha, Instant horaPrevista, TipoReunion tipoReunion) {
        super(fecha, horaPrevista, tipoReunion);
    }

    @Override
    public Modalidad getModalidad() { return Modalidad.Virtual; }

    @Override
    public String toString() {
        return "Reunión virtual en el enlace: " + enlace;
    }
}
