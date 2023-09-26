package testIntraconsulta;

import org.junit.Test;

import main.Alumno;
import main.RegistroDeNotas;

import static org.junit.Assert.*;

public class TestRegistroDeNotas {

	@Test
	public void queSeCreeElRegistroDeNotas() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		
		assertNotNull(notas);
	}
	
	@Test
	public void queNoSePuedaIngresarUnaNotaQueNoEsteDentroDelRango() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setNota(11);
		
		Integer notaEsperada = 0;
		assertEquals(notaEsperada, notas.getNota());
	}
	
	@Test
	public void queSeApruebeLaNota() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setNota(7);
		
		assertTrue(notas.aprobado());
	}
	
}
