package org.example;
/**
 * Representa las notas creadas por el anfitrión durante una reunion.
 */
public class Nota {
    private final String contenido;
    private int numero_nota = 0;

    /**
     * Crea una nueva nota la cual puede ser almacenada en la lista de notas perteneciente a su reunion.
     * @param contenido: String del contenido de dicha nota.
     */
    public Nota(String contenido) {
        this.contenido=contenido;
    }

    /**
     * Se establece el identificador para la nota en base a la última nota añadida a la reunión.
     * @param numero_nota: Identificador para la nota.
     */
    public void setNumeroNota(int numero_nota) {
        this.numero_nota = numero_nota;
    }

    /**
     * @return la información relevante a la nota.
     */
    @Override
    public String toString() {
        return "Nota "+numero_nota+": " + contenido;
    }
}
