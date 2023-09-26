package main;

public class RegistroDeNotas {
	
	//atributo
	private Integer dniAlumno;
	private Integer nota;

	//constructores
	public RegistroDeNotas(Integer dniAlumno) {
		this.setDniAlumno(dniAlumno);
		this.setNota(0);
	}
	
	//metodos
	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		if(nota>=0 && nota<=10){
			this.nota = nota;
		}
		
	}
	
	public boolean aprobado() {
		boolean aprobado = false;
		if(this.nota>=4) {
			aprobado = true;
		}
		return aprobado;
	}
	
}
