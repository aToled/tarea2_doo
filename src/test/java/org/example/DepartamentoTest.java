package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {

    private Departamento departamento;
    private Empleado empleado1;
    private Empleado empleado2;
    private final ArrayList<Empleado> empleados=new ArrayList<>();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Departamento Test", empleados);
        empleado1 = new Empleado("ID001","Rojas","Benjamin","BR@gmail.com");
        empleado2 = new Empleado("ID002","Rozas","Maria","MR@gmail.com");
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Agregar varios empleados al departamento, y que se pueda identificar correctamente la cantidad de empleados en todo momento")
    void agregarEmpleado_obtenerCantidadEmpleados() {
        assertEquals(0, departamento.obtenerCantidadEmpleados());
        departamento.agregarEmpleado(empleado1);
        assertEquals(1, departamento.obtenerCantidadEmpleados());
        departamento.agregarEmpleado(empleado2);
        assertTrue(empleados.contains(empleado1));
        assertTrue(empleados.contains(empleado2));
        assertEquals(2, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void invitar() {
        Reunion reunion = new ReunionVirtual(new Date(), Instant.now(), TipoReunion.MARKETING, Duration.ZERO, "www.com");
        Invitacion invitacion = new Invitacion(reunion);
        departamento.agregarEmpleado(empleado1); departamento.agregarEmpleado(empleado2);
        departamento.invitar(invitacion);

        /// Separo los contenidos de la terminal usando el separador del sistema.
        String[] lineas = outContent.toString().split(System.lineSeparator());

        /// Verifico que se hayan impreso solo 2 líneas en la terminal.
        assertEquals(2,lineas.length);

        /// Verifico que el contenido de tales líneas sea correcto.
        for (int i=0;i<empleados.size();i++) {
            assertEquals(invitacion+"recibida por "+empleados.get(i).toString(), lineas[i]);
        }
    }

    @DisplayName("Getters/toString")
    @Test
    void getNombre() {
        assertEquals("Departamento Test",departamento.getNombre());
    }

    @Test
    void getEmpleados() {
        departamento.agregarEmpleado(empleado1); departamento.agregarEmpleado(empleado2);
        ArrayList<Empleado> empleadosEsperados = new ArrayList<>();
        empleadosEsperados.add(empleado1); empleadosEsperados.add(empleado2);
        assertEquals(empleadosEsperados,empleados);
    }
    @Test
    void testToString() {
        departamento.agregarEmpleado(empleado1);
        assertEquals("Departamento: Departamento Test / Empleados: ["+empleado1.toString()+"]",departamento.toString());
    }
}