package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    private Persona persona;
    private Instant HoraAceptacion;

    @BeforeEach
    @DisplayName("Inicializo la persona a testear")
    void setUp() {
        persona = new Persona("ID123","Soto","Juan","JS@gmail.com");
    }


    @Test
    @DisplayName("resolver_invitacion(true) asigna a HoraAceptacion valor no nulo")
    void resolver_invitacion_true() {
        persona.resolver_invitacion(true);
        HoraAceptacion = persona.getHora_de_aceptacion_invitacion();
        assertNotNull(HoraAceptacion);
    }

    @Test
    @DisplayName("resolver_invitacion(false) asigna a HoraAceptacion valor nulo")
    void resolver_invitacion_false() {
        persona.resolver_invitacion(false);
        HoraAceptacion = persona.getHora_de_aceptacion_invitacion();
        assertNull(HoraAceptacion);
    }

    // https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("invitar() Imprime mensaje correcto en consola")
    void invitar() {
        Reunion reunion = new ReunionPresencial(new Date(), Instant.now(), TipoReunion.OTRO, Duration.ZERO, "Sala Test");
        Invitacion invitacion = new Invitacion(reunion);
        persona.invitar(invitacion);
        /// +\r\n porque el println usa ese separador en mi sistema. (Windows 11)
        assertEquals(invitacion +"recibida por "+persona.toString()+"\r\n", outContent.toString());
    }

    @DisplayName("A continuación los tests de los getters y ToString de la clase Persona")

    @Test
    void getId() {
        assertEquals("ID123",persona.getId());
    }

    @Test
    void getApellidos() {
        assertEquals("Soto",persona.getApellidos());
    }

    @Test
    void getNombre() {
        assertEquals("Juan",persona.getNombre());
    }

    @Test
    void getCorreo() {
        assertEquals("JS@gmail.com",persona.getCorreo());
    }

    @Test
    void testToString() {
        assertEquals("Persona: Juan Soto, ID: ID123, Correo: JS@gmail.com",persona.toString());
    }
}