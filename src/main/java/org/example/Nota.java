package org.example;
/**
 * Representa las notas creadas por el anfitrión durante una reunion.
 */
public class Nota {
    private final String contenido;
    private final int Numero_Nota;

    /**
     * Crea una nueva nota la cual puede ser almacenada en la lista de notas perteneciente a su reunion.
     * @param num: Identificador para la nota.
     * @param contenido: String del contenido de dicha nota.
     */
    public Nota(int num, String contenido){
        this.Numero_Nota=num;
        this.contenido=contenido;
    }

    /**
     * @return la información relevante a la nota.
     */
    @Override
    public String toString() {
        return "Nota "+Numero_Nota+": " + contenido;
    }
}
