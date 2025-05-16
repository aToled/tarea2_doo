package org.example;

public class Nota {
    private final String contenido;
    private final int Numero_Nota;
    public Nota(int num, String contenido){
        this.Numero_Nota=num;
        this.contenido=contenido;
    }

    @Override
    public String toString() {
        return "Nota "+Numero_Nota+": " + contenido;
    }
}
