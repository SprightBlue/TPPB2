package testIntraconsulta;

import org.junit.Test;

import main.Aula;
import main.CicloLectivo;
import main.Comision;
import main.Dia;
import main.Materia;
import main.Turno;

import static org.junit.Assert.*;

public class TestComision {
	
	@Test
	public void queSePuedaCrearComision() {
		Materia materia = new Materia("Programacion Basica II");
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		Comision comision = new Comision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		
		assertNotNull(comision);
	}
	
	@Test
	public void queSePuedaAsignarAulaALaComision() {
		Materia materia = new Materia("Programacion Basica II");
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		Comision comision = new Comision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		comision.setIdAula(aula.getId());
		
		assertEquals(aula.getId(), comision.getIdAula());
	}
	
}
