package com.icai.practicas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.icai.practicas.model.DNI;

import org.junit.jupiter.api.Test;

public class DniTest {
    
    @Test
    public void testDni() {
        DNI dniTestTrue = new DNI("12345678Z");
		DNI dniTestFalse = new DNI("00000001R");

		boolean resultadoDniTrue = dniTestTrue.validar();
		boolean resultadoDniFalse = dniTestFalse.validar();

		assertEquals(true, resultadoDniTrue);
		assertEquals(false, resultadoDniFalse);

    }
}
