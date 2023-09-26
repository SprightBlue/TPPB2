package testIntraconsulta;

import org.junit.Test;

import main.AsignacionComisionProfesor;
import main.CicloLectivo;
import main.Comision;
import main.Dia;
import main.Materia;
import main.Profesor;
import main.Turno;

import static org.junit.Assert.*;

public class TestAsignacionComisionProfesor {
	
	@Test
	public void queSePuedaCrearAsignacionComisionProfesor() {
		Materia materia = new Materia("Programacion Basica II");
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		Comision comision = new Comision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Profesor profesor = new Profesor("Juan", "Bautista");
		AsignacionComisionProfesor asignacion = new AsignacionComisionProfesor(comision.getId(), profesor.getDni());
		
		assertNotNull(asignacion);
	}

}
