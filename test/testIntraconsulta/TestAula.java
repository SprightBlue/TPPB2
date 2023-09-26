package testIntraconsulta;

import org.junit.Test;

import main.Aula;

import static org.junit.Assert.*;

public class TestAula {
	
	@Test
	public void queSePuedaCrearAula() {
		Aula aula = new Aula(40);
		
		assertNotNull(aula);
	}
	
}
