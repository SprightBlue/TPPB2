package main;

public class RegistroDeNotas {
	
	//atributo
	private Integer dniAlumno;
	private Integer primerParcial;
	private Integer segundoParcial;
	private Integer primerRecuperatorio;
	private Integer segundoRecuperatorio;
	private Integer notaFinal;

	//constructores
	public RegistroDeNotas(Integer dniAlumno) {
		this.setDniAlumno(dniAlumno);
		this.primerParcial = 0;
		this.segundoParcial = 0;
		this.primerRecuperatorio = 0;
		this.segundoRecuperatorio = 0;
		this.notaFinal = 0;
	}
	
	//metodos
	public Integer getDniAlumno() {
		return dniAlumno;
	}

	private void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	
	public boolean aprobado() {
		boolean aprobado = false;
		if(this.notaFinal>=4) {
			aprobado = true;
		}
		return aprobado;
	}
	
	public boolean promociono() {
		boolean promociono = false;
		if(this.notaFinal>=7) {
			promociono = true;
		}
		return promociono;
	}
	
	public Integer getPrimerParcial() {
		return primerParcial;
	}

	public boolean setPrimerParcial(Integer nota) {
		boolean asignado = false;
		if(this.primerParcial==0 && nota>0 && nota<=10) {
			this.primerParcial = nota;
			asignado = true;
		}
		return asignado;
	}

	public Integer getSegundoParcial() {
		return segundoParcial;
	}

	public boolean setSegundoParcial(Integer nota) {
		boolean asignado = false;
		if(this.segundoParcial==0 && nota>0 && nota<=10) {
			this.segundoParcial = nota;
			asignado = true;
		}
		return asignado;
	}

	public Integer getPrimerRecuperatorio() {
		return primerRecuperatorio;
	}

	public boolean setPrimerRecuperatorio(Integer nota) {
		boolean asignado = false;
		if(this.primerRecuperatorio==0 && this.segundoRecuperatorio==0 && nota>0 && nota<=10) {
			this.primerRecuperatorio = nota;
			asignado = true;
		}
		return asignado;
	}

	public Integer getSegundoRecuperatorio() {
		return segundoRecuperatorio;
	}

	public boolean setSegundoRecuperatorio(Integer nota) {
		boolean asignado = false;
		if(this.primerRecuperatorio==0 && this.segundoRecuperatorio==0 && nota>0 && nota<=10) {
			this.segundoRecuperatorio = nota;
			asignado = true;
		}
		return asignado;
	}

	public Integer getNotaFinal() {
		return notaFinal;
	}

	public boolean setNotaFinal() {
		boolean asignado = false;
		if(this.primerParcial>=4 && this.segundoParcial>=4) {
			this.notaFinal = (this.primerParcial+this.segundoParcial)/2;
			asignado = true;
		}else if(this.primerRecuperatorio>=4 && this.segundoParcial>=4) {
			this.notaFinal = (this.primerRecuperatorio+this.segundoParcial)/2;
			asignado = true;
		}else if(this.primerParcial>=4 && this.segundoRecuperatorio>=4) {
			this.notaFinal = (this.primerParcial+this.segundoRecuperatorio)/2;
			asignado = true;
		}
		return asignado;
	}
	
}
