package testIntraconsulta;

import org.junit.Test;

import main.Profesor;

import static org.junit.Assert.*;

public class TestProfesor {
	
	@Test
	public void queSePuedaCrearProfesor() {
		Profesor profesor = new Profesor("Juan", "Bautista");
		
		assertNotNull(profesor);
	}

}
