package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
/**
 * Clase cuyo único propósito es generar un informe de la reunion.
 */
public class Informe {

    /**
     * Mediante varios métodos proporcionados por la implementación de java se genera un informe con toda la información necesaria de la reunion.
     * Primero le asigna el nombre al informe dándole el formato de Año/Mes/Dia/Hora/Minuto, después usando java.io.File crea el archivo
     * y verifica si se creó sin errores para posteriormente abrir el archivo y añadirle los datos relevantes usando las variables propias de la reunion
     * finalmente si se logro escribir toda la información con éxito el archivo se cierra y el método termina.
     * @param reunion: la reunion en cuestión.
     */
    public static void elaborarInforme(Reunion reunion) {
        // todas las notas relacionadas con la reunión (ordenadas cronológicamente)
        SimpleDateFormat formatoString = new SimpleDateFormat("yyyy-MM-dd_HH-mm");

        String nombreInforme = "reunion " + formatoString.format(reunion.getFecha());

        // Crear archivo
        try {
            File myObj = new File("reuniones/" + nombreInforme + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("reuniones/" + nombreInforme + ".txt");

            // write the string to the file
            fw.write("Fecha: " + reunion.getFecha() + "\n");
            fw.write("Hora prevista: " + reunion.getHoraPrevista() + "\n");
            fw.write("Hora inicio: " + reunion.getHoraInicio() + "\n");
            fw.write("Hora final: " + reunion.getHoraFin() + "\n");
            int diferenciaMinutos = (int)reunion.calcularTiempoReal();
            int diferenciaHoras = diferenciaMinutos / 60;
            diferenciaMinutos -= (diferenciaHoras * 60);

            fw.write("Duración Prevista: "+reunion.getDuracionPrevista().toHours()+" horas con "+reunion.getDuracionPrevista().toMinutes()%60+" minutos\n");
            fw.write("Duración Real: " + diferenciaHoras + " horas con " + diferenciaMinutos + " minutos\n");

            switch (reunion.getTipoDeReunion()) {
                case TECNICA:
                    fw.write("Tipo de reunión: técnica\n");
                    break;
                case MARKETING:
                    fw.write("Tipo de reunión: marketing\n");
                    break;
                default:
                    fw.write("Tipo de reunión: otro\n");
                    break;
            }

            if (reunion.getModalidad() == Reunion.Modalidad.Presencial||reunion.getModalidad() == Reunion.Modalidad.Virtual) {
                fw.write(reunion.toString());
            } else {
                fw.write("Sala o enlace desconocido\n");
            }

            // Redondeo a 1 decimal después de la coma
            float porcentaje = Math.round(reunion.obtenerPorcentajeAsistencia() * 10.0f) / 10.0f;
            fw.write("Porcentaje de asistencias: " + porcentaje + "\n");

            fw.write("Participantes:\n");
            List participantes = reunion.obtenerAsistencias();
            for (int i = 0; i < reunion.obtenerTotalAsistencia(); i++) {
                fw.write((i+1) + ") " + participantes.get(i).toString() + "\n");
            }

            fw.write("\n");
            fw.write("Retrasos:\n");
            List retrasos = reunion.obtenerRetrasos();
            for (int i = 0; i < reunion.obtenerTotalRetrasos(); i++) {
                fw.write((i+1) + ") " + retrasos.get(i).toString() + "\n");
            }

            fw.write("\n");
            fw.write("Ausencias:\n");
            List ausencias = reunion.obtenerAusencias();
            for (int i = 0; i < reunion.obtenerTotalAusencias(); i++) {
                fw.write((i+1) + ") " + ausencias.get(i).toString() + "\n");
            }

            fw.write("\n");
            fw.write("Notas de la reunión:\n");
            List<Nota> notas = reunion.obtenerNotas();
            for (Nota nota : notas) {
                fw.write("-" + nota.toString() + "\n");
            }

            // close the writer
            fw.close();

            System.out.println("Informe generado exitosamente");

        } catch (IOException e) {
            System.out.println("Error al tratar de escribir informe: " + e);
        }
    }
}
