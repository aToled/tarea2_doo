package org.example;

import java.util.ArrayList;

public class Nota {
    private final String contenido;
    private final int numero_nota;
    private final ArrayList<Nota> arreglo_de_notas = new ArrayList<>();
    public Nota(int num, String contenido){
        this.numero_nota =num;
        this.contenido=contenido;
    }

    public void addNota(Nota nota){
        arreglo_de_notas.add(nota);
    }
    public Nota getNota(int i){
        return arreglo_de_notas.get(i);
    }

    @Override
    public String toString() {
        return "Nota "+ numero_nota+1 +": " + contenido;
    }
}
