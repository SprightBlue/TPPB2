package testIntraconsulta;

import org.junit.Test;

import main.Alumno;
import main.AsignacionComisionAlumno;
import main.CicloLectivo;
import main.Comision;
import main.Dia;
import main.Materia;
import main.Turno;

import static org.junit.Assert.*;

public class TestAsignacionComisionAlumno {
	
	@Test
	public void queSePuedaCrearAsignacionComisionAlumno() {
		Materia materia = new Materia("Programacion Basica II");
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		Comision comision = new Comision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(comision.getId(), alumno.getDni());
		
		assertNotNull(asignacion);
	}

}
