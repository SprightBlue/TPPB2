package main;

public class AsignacionComisionAlumno {
	
	//atributos
	private Integer idComision;
	private Integer dniAlumno;
	private RegistroDeNotas notasAlumno;
	
	//constructores
	public AsignacionComisionAlumno(Integer idComision, Integer dniAlumno) {
		this.setIdComision(idComision);
		this.setDniAlumno(dniAlumno);
		this.setNotasAlumno(dniAlumno);
	}

	//metodos
	public Integer getIdComision() {
		return idComision;
	}
	
	private void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	private void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public RegistroDeNotas getNotasAlumno() {
		return notasAlumno;
	}

	private void setNotasAlumno(Integer dniAlumno) {
		this.notasAlumno = new RegistroDeNotas(dniAlumno);
	}
	
}
