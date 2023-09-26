package testIntraconsulta;

import org.junit.Test;

import main.Alumno;

import static org.junit.Assert.*;

public class TestAlumno {
	
	@Test
	public void queSePuedaCrearAlumno() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		
		assertNotNull(alumno);
	}
	
}
