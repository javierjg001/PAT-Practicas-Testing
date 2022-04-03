package com.icai.practicas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.icai.practicas.model.DNI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainApplicationTests {

	@Test
	void contextLoads() {

		DNI dniTestTrue = new DNI("54364645M");
		DNI dniTestFalse = new DNI("00000001R");

		boolean resultadoDniTrue = dniTestTrue.validar();
		boolean resultadoDniFalse = dniTestFalse.validar();

		assertEquals(true, resultadoDniTrue);
		assertEquals(false, resultadoDniFalse);


	}

}
