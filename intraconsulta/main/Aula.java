package main;

public class Aula {
	
	//atributos
	private static Integer idGeneral = 1;
	private Integer id;
	private Integer capacidad;
	
	//constructores
	public Aula(Integer capacidad) {
		this.setId();
		this.setCapacidad(capacidad);
	}
	
	//metodos
	public Integer getId() {
		return id;
	}

	private void setId() {
		this.id = idGeneral;
		idGeneral++;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}	
	
}
