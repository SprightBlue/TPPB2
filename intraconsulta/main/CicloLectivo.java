package main;

import java.time.LocalDate;

public class CicloLectivo {
	
	//atributos
	private static Integer idGeneral = 1;
	private Integer id;
	private LocalDate inicio;
	private LocalDate fin;
	private LocalDate inicioInscripcion;
	private LocalDate finInscripcion;
	
	//constructores
	public CicloLectivo(String inicio, String fin, String inicioInscripcion, String finInscripcion) {
		this.setId();
		this.setInicio(inicio);
		this.setFin(fin);
		this.setInicioInscripcion(inicioInscripcion);
		this.setFinInscripcion(finInscripcion);
	}
	
	//metodos	
	public Integer getId() {
		return id;
	}

	private void setId() {
		this.id = idGeneral;
		idGeneral++;
	}	

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = LocalDate.parse(inicio);
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = LocalDate.parse(fin);
	}

	public LocalDate getInicioInscripcion() {
		return inicioInscripcion;
	}

	public void setInicioInscripcion(String inicioInscripcion) {
		this.inicioInscripcion = LocalDate.parse(inicioInscripcion);
	}

	public LocalDate getFinInscripcion() {
		return finInscripcion;
	}

	public void setFinInscripcion(String finInscripcion) {
		this.finInscripcion = LocalDate.parse(finInscripcion);
	}

}
