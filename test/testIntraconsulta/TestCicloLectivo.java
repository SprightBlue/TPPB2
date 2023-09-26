package testIntraconsulta;

import org.junit.Test;

import main.CicloLectivo;

import static org.junit.Assert.*;

public class TestCicloLectivo {
	
	@Test
	public void queSePuedaCrearCicloLectivo() {
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
	
		assertNotNull(fechas);
	}

}
