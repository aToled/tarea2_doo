package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EmpleadoTest {
    private Empleado empleado1;
    @BeforeEach
    void setUp() {
        empleado1=new Empleado("123","Doe","John","jd@gmail.com");
    }

    @Test
    @DisplayName("Tests getters/toString")
    void getId() {
        assertEquals("123", empleado1.getId());
    }

    @Test
    void getApellidos() {
        assertEquals("Doe", empleado1.getApellidos());
    }

    @Test
    void getNombre() {
        assertEquals("John", empleado1.getNombre());
    }

    @Test
    void getCorreo() {
        assertEquals("jd@gmail.com", empleado1.getCorreo());
    }

    @Test
    void testToString() {
        assertEquals("Empleado: John Doe, ID: 123, Correo: jd@gmail.com", empleado1.toString());
    }
}