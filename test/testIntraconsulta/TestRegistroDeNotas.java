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
		notas.setPrimerParcial(11);
		
		Integer notaEsperada = 0;
		assertEquals(notaEsperada, notas.getPrimerParcial());
	}
	
	@Test
	public void queSePuedaAsignarElPrimerParcial() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setPrimerParcial(7);
		
		Integer notaEsperada = 7;
		assertEquals(notaEsperada, notas.getPrimerParcial());
	}
	
	@Test
	public void queNoSePuedaVolverAsignarElMismoTipoDeNota() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setPrimerParcial(7);
		
		assertFalse(notas.setPrimerParcial(9));
	}
	
	@Test
	public void queSePuedaAsignarElSegundoParcial() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setSegundoParcial(7);
		
		Integer notaEsperada = 7;
		assertEquals(notaEsperada, notas.getSegundoParcial());
	}
	
	@Test
	public void queSePuedaAsignarElPrimerRecuperatorio() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setPrimerRecuperatorio(7);
		
		Integer notaEsperada = 7;
		assertEquals(notaEsperada, notas.getPrimerRecuperatorio());
	}
	
	@Test
	public void queSePuedaAsignarElSegundoRecuperatorio() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setSegundoRecuperatorio(7);
		
		Integer notaEsperada = 7;
		assertEquals(notaEsperada, notas.getSegundoRecuperatorio());
	}
	
	@Test
	public void queNoSePuedaAsignarLosDosRecuperatorios() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setPrimerRecuperatorio(7);
		
		assertFalse(notas.setSegundoRecuperatorio(8));
	}
	
	@Test
	public void queSePuedaAsignarLaNotaFinal() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		notas.setPrimerParcial(7);
		notas.setSegundoParcial(8);
		notas.setNotaFinal();
		
		Integer notaEsperada = (7+8)/2;
		assertEquals(notaEsperada, notas.getNotaFinal());
	}
	
	@Test
	public void queNoSePuedaAsignarLaNotaFinalSinTenerAprobadoLosParciales() {
		Alumno alumno = new Alumno("Rodolfo", "Gutierrez");
		RegistroDeNotas notas = new RegistroDeNotas(alumno.getDni());
		
		assertFalse(notas.setNotaFinal());
	}
	
}
