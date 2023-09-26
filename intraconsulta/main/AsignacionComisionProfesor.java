package main;

public class AsignacionComisionProfesor {
	
	//atributos
	private Integer idComision;
	private Integer dniProfesor;
	
	//contructores
	public AsignacionComisionProfesor(Integer idComision, Integer dniProfesor) {
		this.setIdComision(idComision);
		this.setDniProfesor(dniProfesor);
	}
	
	//metodos
	public Integer getIdComision() {
		return idComision;
	}

	private void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public Integer getDniProfesor() {
		return dniProfesor;
	}

	private void setDniProfesor(Integer idProfesor) {
		this.dniProfesor = idProfesor;
	}

}
