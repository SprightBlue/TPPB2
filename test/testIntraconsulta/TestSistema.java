package testIntraconsulta;

import org.junit.Test;

import main.Alumno;
import main.Aula;
import main.CicloLectivo;
import main.Dia;
import main.Materia;
import main.Profesor;
import main.Sistema;
import main.TipoNota;
import main.Turno;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestSistema {
	
	@Test
	public void queSePuedaCrearSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		
		assertNotNull(sistema);
	}
	
	@Test
	public void queSePuedaAgregarLaMateriaAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		
		assertTrue(sistema.agregarMateria(materia));
	}
	
	@Test
	public void queNoSePuedaAgregarLaMismaMateriaAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		
		assertFalse(sistema.agregarMateria(materia));
	}
	
	@Test
	public void queSePuedaAgregarAlumnoAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		
		assertTrue(sistema.agregarAlumno(alumno));
	}
	
	@Test
	public void queNoSePuedaAgregarElMismoAlumnoAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		
		assertFalse(sistema.agregarAlumno(alumno));
	}
	
	@Test
	public void queSePuedaAgregarElCicloLectivoAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		
		assertTrue(sistema.agregarCicloLectivo(fechas));
	}
	
	@Test
	public void queNoSePuedaAgregarElMismoCicloLectivoAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		
		assertFalse(sistema.agregarCicloLectivo(fechas));
	}
	
	@Test
	public void queNoSePuedaAgregarUnCicloLectivoConLasMismasFechasAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		CicloLectivo primerCuatrimestre = new CicloLectivo("2023-03-27", "2023-07-15", "2023-03-03", "2023-03-23");
		sistema.agregarCicloLectivo(primerCuatrimestre);
		CicloLectivo primerCuatrimestreDuplicado = new CicloLectivo("2023-03-27", "2023-07-15", "2023-03-03", "2023-03-23");
		
		assertFalse(sistema.agregarCicloLectivo(primerCuatrimestreDuplicado));
		
		CicloLectivo segundoCuatrimestre = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		
		assertTrue(sistema.agregarCicloLectivo(segundoCuatrimestre));
	}
	
	@Test
	public void queSePuedaCrearComision() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		
		assertNotNull(sistema.buscarComision(idComision));
	}
	
	@Test
	public void queNoSeAgregarUnaComisionConLaMismaMateriaCicloYTurno() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Integer idComisionDuplicada = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		
		assertNull(sistema.buscarComision(idComisionDuplicada));
		
		Integer idComisionAgregable = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.NOCHE, Dia.MIERCOLES);
		
		assertNotNull(sistema.buscarComision(idComisionAgregable));
	}
	
	@Test
	public void queSePuedaAgregarProfesorAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Profesor profesor = new Profesor("Juan", "Bautista");
		
		assertTrue(sistema.agregarProfesor(profesor));
	}
	
	@Test
	public void queNoSePuedaAgregarElMismoProfesorAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Profesor profesor = new Profesor("Juan", "Bautista");
		sistema.agregarProfesor(profesor);
		
		assertFalse(sistema.agregarProfesor(profesor));
	}
	
	@Test
	public void queSePuedaAsignarProfesorALaComision() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Profesor profesor = new Profesor("Juan", "Bautista");
		sistema.agregarProfesor(profesor);
		
		assertTrue(sistema.asignarProfesorAComision(idComision, profesor.getDni()));
	}
	
	@Test
	public void queNoSePuedaAsignarElMismoProfesorALaMismaComision() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Profesor profesor = new Profesor("Juan", "Bautista");
		sistema.agregarProfesor(profesor);
		sistema.asignarProfesorAComision(idComision, profesor.getDni());
		
		assertFalse(sistema.asignarProfesorAComision(idComision, profesor.getDni()));
	}
	
	@Test
	public void queSePuedaAgregarCorrelativa() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		
		assertTrue(sistema.agregarCorrelativa(pb2.getId(), pb1.getId()));
	}
	
	@Test
	public void queNoSePuedaAgregarCorrelativaNuevamente() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		sistema.agregarCorrelativa(pb2.getId(), pb1.getId());
		
		assertFalse(sistema.agregarCorrelativa(pb2.getId(), pb1.getId()));
	}
	
	@Test
	public void queNoSePuedaAgregarCorrelativaQueNoEsteEnElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		Materia pb1 = new Materia("Programacion Basica I");
		
		assertFalse(sistema.agregarCorrelativa(pb2.getId(), pb1.getId()));
	}
	
	@Test
	public void queSePuedaEliminarCorrelativa() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		sistema.agregarCorrelativa(pb2.getId(), pb1.getId());
		
		assertTrue(sistema.eliminarCorrelativa(pb2.getId(), pb1.getId()));
	}
	
	@Test
	public void queNoSePuedaEliminarCorrelativaNuevamente() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		sistema.agregarCorrelativa(pb2.getId(), pb1.getId());
		sistema.eliminarCorrelativa(pb2.getId(), pb1.getId());
		
		assertFalse(sistema.eliminarCorrelativa(pb2.getId(), pb1.getId()));
	}
	
	@Test
	public void queNoSePuedaEliminarCorrelativaQueNoEstaEnElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		Materia pb1 = new Materia("Programacion Basica I");
		pb2.agregarCorrelativa(pb1.getId());
		
		assertFalse(sistema.eliminarCorrelativa(pb2.getId(), pb1.getId()));
	}
	
	@Test
	public void queSePuedaAgregarAulaAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Aula aula = new Aula(40);
		
		assertTrue(sistema.agregarAula(aula));
	}
	
	@Test
	public void queNoSePuedaAgregarElMismoAulaAElSistema() {
		Sistema sistema = new Sistema("Intraconsulta");
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		
		assertFalse(sistema.agregarAula(aula));
	}
	
	@Test
	public void queSePuedaAsignarAulaALaComision() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		
		assertTrue(sistema.asignarAulaAComision(idComision, aula.getId()));
	}
	
	@Test
	public void queSePuedaAsignarAlumnoALaComision() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		
		assertTrue(sistema.asignarAlumnoAComision(idComision, alumno.getDni()));
	}
	
	@Test
	public void queNoSePuedaAsignarAlumnoConCorrelativaNoAprobada() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		sistema.agregarCorrelativa(pb2.getId(), pb1.getId());
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(pb2.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		
		assertFalse(sistema.asignarAlumnoAComision(idComision, alumno.getDni()));
	}
	
	@Test
	public void queNoSePuedaAsingarAlumnoSiEstaFueraDeLaFechaDeInscripcion() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		
		assertFalse(sistema.asignarAlumnoAComision(idComision, alumno.getDni()));
	}
	
	@Test
	public void queNoSePuedaAsignarAlumnoSiExcedeLaCantidadDeAlumnosPermitidosEnElAula() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica I");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(2);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno rodo = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(rodo);
		sistema.asignarAlumnoAComision(idComision, rodo.getDni());
		Alumno simi = new Alumno("Federico", "Simi");
		sistema.agregarAlumno(simi);
		sistema.asignarAlumnoAComision(idComision, simi.getDni());
		Alumno fede = new Alumno("Federico", "Vazquez");
		sistema.agregarAlumno(fede);
		assertFalse(sistema.asignarAlumnoAComision(idComision, fede.getDni()));
	}
	
	@Test
	public void queNoSePuedaAsignarAlumnoSiCursoOtraComisionEnElMismoHorario() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComisionPb2 = sistema.agregarComision(pb2.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula1 = new Aula(40);
		sistema.agregarAula(aula1);
		sistema.asignarAulaAComision(idComisionPb2, aula1.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idComisionPb2, alumno.getDni());
		Materia pw = new Materia("Programacion Web");
		sistema.agregarMateria(pw);
		Integer idComisionPw = sistema.agregarComision(pw.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula2 = new Aula(50);
		sistema.agregarAula(aula2);
		sistema.asignarAulaAComision(idComisionPw, aula2.getId());
		
		assertFalse(sistema.asignarAlumnoAComision(idComisionPw, alumno.getDni()));
	}
	
	@Test
	public void queNoSePuedaAsignarAlumnoQueHayAprobadoLaMateriaPreviamente() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComisionAprobada = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComisionAprobada, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idComisionAprobada, alumno.getDni());
		sistema.registrarNota(idComisionAprobada, alumno.getDni(), 7, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idComisionAprobada, alumno.getDni(), 7, TipoNota.SEGUNDOPARCIAL);
		sistema.obtenerNotaFinal(idComisionAprobada, alumno.getDni());
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.NOCHE, Dia.MARTES);
		
		assertFalse(sistema.asignarAlumnoAComision(idComision, alumno.getDni()));
	}
	
	@Test
	public void queNoSePuedaAsignarProfesorSiSuperaLaCantidadPorAlumno() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2023-08-14", "2023-12-02", "2023-07-27", "2023-08-11");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Profesor juan = new Profesor("Juan", "Bautista");
		sistema.agregarProfesor(juan);
		sistema.asignarProfesorAComision(idComision, juan.getDni());
		Profesor agustin = new Profesor("Agustin", "Rizzo");
		sistema.agregarProfesor(agustin);
		
		assertFalse(sistema.asignarProfesorAComision(idComision, agustin.getDni()));
	}
	
	@Test
	public void queSePuedaRegistrarLaNotaDelPrimerParcial() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idComision, alumno.getDni());
		
		assertTrue(sistema.registrarNota(idComision, alumno.getDni(), 7, TipoNota.PRIMERPARCIAL));
	}
	
	@Test
	public void queNoSePuedaRegistrarUnaNotaFueraDelRango() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idComision, alumno.getDni());
		
		assertFalse(sistema.registrarNota(idComision, alumno.getDni(), 11, TipoNota.PRIMERPARCIAL));
	}
	
	@Test
	public void queNoSePuedaRegistrarNotaDeLosDosRecuperatorios() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idComision, alumno.getDni());
		
		assertTrue(sistema.registrarNota(idComision, alumno.getDni(), 7, TipoNota.PRIMERRECUPERATORIO));
		
		assertFalse(sistema.registrarNota(idComision, alumno.getDni(), 5, TipoNota.SEGUNDORECUPERATORIO));
	}
	
	@Test
	public void queSePuedaObtenerLaNotaFinalDelAlumno() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idComision, alumno.getDni());
		sistema.registrarNota(idComision, alumno.getDni(), 7, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idComision, alumno.getDni(), 7, TipoNota.SEGUNDOPARCIAL);
		
		Integer notaEsperada = 7;
		assertEquals(notaEsperada, sistema.obtenerNotaFinal(idComision, alumno.getDni()));
	}
	
	@Test
	public void queLaNotaFinalSea0PorNoTenerAprobadosLosExamenes() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia materia = new Materia("Programacion Basica II");
		sistema.agregarMateria(materia);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(materia.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idComision, alumno.getDni());
		sistema.registrarNota(idComision, alumno.getDni(), 2, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idComision, alumno.getDni(), 2, TipoNota.SEGUNDOPARCIAL);
		
		Integer notaEsperada = 0;
		assertEquals(notaEsperada, sistema.obtenerNotaFinal(idComision, alumno.getDni()));
	}
	
	@Test
	public void queSePuedaObtenerMateriasAprobadasPorElAlumno() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idPb1Comision = sistema.agregarComision(pb1.getId(), fechas.getId(), Turno.NOCHE, Dia.MARTES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idPb1Comision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idPb1Comision, alumno.getDni());
		sistema.registrarNota(idPb1Comision, alumno.getDni(), 7, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idPb1Comision, alumno.getDni(), 7, TipoNota.SEGUNDOPARCIAL);
		sistema.obtenerNotaFinal(idPb1Comision, alumno.getDni());
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		sistema.agregarCorrelativa(pb2.getId(), pb1.getId());
		Integer idPb2Comision = sistema.agregarComision(pb2.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idPb2Comision, aula.getId());
		sistema.asignarAlumnoAComision(idPb2Comision, alumno.getDni());
		sistema.registrarNota(idPb2Comision, alumno.getDni(), 4, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idPb2Comision, alumno.getDni(), 4, TipoNota.SEGUNDORECUPERATORIO);
		sistema.obtenerNotaFinal(idPb2Comision, alumno.getDni());
		ArrayList<Materia> aprobadas = sistema.materiasAprobadasPorUnAlumno(alumno.getDni());
		
		assertTrue(aprobadas.contains(pb1));
		assertTrue(aprobadas.contains(pb2));
		
		Materia pw = new Materia("Programacion Web");
		
		assertFalse(aprobadas.contains(pw));
	}
	
	@Test
	public void queSeObtengaElPromedioDelAlumno() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idPb1Comision = sistema.agregarComision(pb1.getId(), fechas.getId(), Turno.NOCHE, Dia.MARTES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idPb1Comision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idPb1Comision, alumno.getDni());
		sistema.registrarNota(idPb1Comision, alumno.getDni(), 7, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idPb1Comision, alumno.getDni(), 7, TipoNota.SEGUNDOPARCIAL);
		sistema.obtenerNotaFinal(idPb1Comision, alumno.getDni());
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		sistema.agregarCorrelativa(pb2.getId(), pb1.getId());
		Integer idPb2Comision = sistema.agregarComision(pb2.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idPb2Comision, aula.getId());
		sistema.asignarAlumnoAComision(idPb2Comision, alumno.getDni());
		sistema.registrarNota(idPb2Comision, alumno.getDni(), 4, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idPb2Comision, alumno.getDni(), 4, TipoNota.SEGUNDORECUPERATORIO);
		sistema.obtenerNotaFinal(idPb2Comision, alumno.getDni());
		
		Integer promedioEsperado = (7+4)/2;
		assertEquals(promedioEsperado, sistema.calcularPromedio(alumno.getDni()));
	}
	
	@Test
	public void queSeObtengaLasMateriasQueFaltanCursarAlAlumno() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idComision = sistema.agregarComision(pb1.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idComision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		ArrayList<Materia> materias = sistema.obtenerMateriasQueFaltanCursarParaElAlumno(alumno.getDni());
		
		assertTrue(materias.contains(pb1));
		assertTrue(materias.contains(pb2));
	}
	
	@Test
	public void queNoTengaMateriasPorCursarElAlumno() {
		Sistema sistema = new Sistema("Intraconsulta");
		Materia pb1 = new Materia("Programacion Basica I");
		sistema.agregarMateria(pb1);
		CicloLectivo fechas = new CicloLectivo("2024-08-14", "2024-12-02", "2023-06-01", "2023-12-31");
		sistema.agregarCicloLectivo(fechas);
		Integer idPb1Comision = sistema.agregarComision(pb1.getId(), fechas.getId(), Turno.NOCHE, Dia.MARTES);
		Aula aula = new Aula(40);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idPb1Comision, aula.getId());
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		sistema.agregarAlumno(alumno);
		sistema.asignarAlumnoAComision(idPb1Comision, alumno.getDni());
		sistema.registrarNota(idPb1Comision, alumno.getDni(), 7, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idPb1Comision, alumno.getDni(), 7, TipoNota.SEGUNDOPARCIAL);
		sistema.obtenerNotaFinal(idPb1Comision, alumno.getDni());
		Materia pb2 = new Materia("Programacion Basica II");
		sistema.agregarMateria(pb2);
		sistema.agregarCorrelativa(pb2.getId(), pb1.getId());
		Integer idPb2Comision = sistema.agregarComision(pb2.getId(), fechas.getId(), Turno.MAÑANA, Dia.MIERCOLES);
		sistema.agregarAula(aula);
		sistema.asignarAulaAComision(idPb2Comision, aula.getId());
		sistema.asignarAlumnoAComision(idPb2Comision, alumno.getDni());
		sistema.registrarNota(idPb2Comision, alumno.getDni(), 4, TipoNota.PRIMERPARCIAL);
		sistema.registrarNota(idPb2Comision, alumno.getDni(), 4, TipoNota.SEGUNDORECUPERATORIO);
		sistema.obtenerNotaFinal(idPb2Comision, alumno.getDni());
		ArrayList<Materia> materias = sistema.obtenerMateriasQueFaltanCursarParaElAlumno(alumno.getDni());
		
		assertFalse(materias.contains(pb1));
		assertFalse(materias.contains(pb2));
	}
	
}
