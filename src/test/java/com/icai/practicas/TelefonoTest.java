package com.icai.practicas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.icai.practicas.model.Telefono;

import org.junit.jupiter.api.Test;

public class TelefonoTest {
    
    @Test
    public void testTelefono(){
        
        Telefono tlfnTrue = new Telefono("677817580");
        Telefono tlfnFalse = new Telefono("0000000000000");

        boolean resultadoTrue = tlfnTrue.validar();
        boolean resultadoFalse = tlfnFalse.validar();

        assertEquals(true, resultadoTrue);
        assertEquals(false, resultadoFalse);

    }
}
