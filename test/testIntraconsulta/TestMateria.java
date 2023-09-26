package testIntraconsulta;

import org.junit.Test;

import main.Materia;

import static org.junit.Assert.*;

public class TestMateria {
	
	@Test 
	public void queSePuedaCrearMateria() {
		Materia materia = new Materia("Programacion Basica II");
		
		assertNotNull(materia);
	}
	
	@Test
	public void queSePuedaAgregarCorrealtiva() {
		Materia pb2 = new Materia("Programacion Basica II");
		Materia pb1 = new Materia("Programacion Basica I");
		
		assertTrue(pb2.agregarCorrelativa(pb1.getId()));
	}
	
	@Test
	public void queNoSePuedaAgregarLaMismaCorrelativa() {
		Materia pb2 = new Materia("Programacion Basica II");
		Materia pb1 = new Materia("Programacion Basica I");
		pb2.agregarCorrelativa(pb1.getId());
		
		assertFalse(pb2.agregarCorrelativa(pb1.getId()));
	}
	
	@Test
	public void queSePuedaEliminarCorrelativa() {
		Materia pb2 = new Materia("Programacion Basica II");
		Materia pb1 = new Materia("Programacion Basica I");
		pb2.agregarCorrelativa(pb1.getId());
		
		assertTrue(pb2.eliminarCorrelativa(pb1.getId()));
	}
	
	@Test
	public void queNoSePuedaEliminarCorrelativaSiNoLaTiene() {
		Materia pb2 = new Materia("Programacion Basica II");
		Materia pb1 = new Materia("Programacion Basica I");
		
		assertFalse(pb2.eliminarCorrelativa(pb1.getId()));
	}

}
