package main;

import java.util.ArrayList;

public class Comision {
	
	//atributos
	private static Integer idGeneral = 1;
	private Integer id;
	private Integer idMateria;
	private Integer idCicloLectivo;
	private Turno turno;
	private Dia dia;
	private Integer idAula;
	private ArrayList<AsignacionComisionProfesor> profesoresAsignados;
	private ArrayList<AsignacionComisionAlumno> alumnosAsignados;
	
	//constructores
	public Comision(Integer idMateria, Integer idCicloLectivo, Turno turno, Dia dia) {
		this.setId();
		this.setIdMateria(idMateria);
		this.setIdCicloLectivo(idCicloLectivo);
		this.setTurno(turno);
		this.setDia(dia);
		this.idAula = 0;
		this.profesoresAsignados = new ArrayList<AsignacionComisionProfesor>();
		this.alumnosAsignados = new ArrayList<AsignacionComisionAlumno>();
	}
	
	//metodos
	public Integer getId() {
		return id;
	}

	private void setId() {
		this.id = idGeneral;
		idGeneral++;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public Integer getIdCicloLectivo() {
		return idCicloLectivo;
	}

	public void setIdCicloLectivo(Integer idCicloLectivo) {
		this.idCicloLectivo = idCicloLectivo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}	

	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}
	
	public void asignarAlumno(Integer dniAlumno) {
		AsignacionComisionAlumno asignado = new AsignacionComisionAlumno(this.getId(), dniAlumno);
		this.alumnosAsignados.add(asignado);
	}
	
	public ArrayList<AsignacionComisionAlumno> getAlumnoAsignados() {
		return this.alumnosAsignados;
	}
	
	public void asignarProfesor(Integer dniProfesor) {
		AsignacionComisionProfesor asignado = new AsignacionComisionProfesor(this.getId(), dniProfesor);
		this.profesoresAsignados.add(asignado);
	}
	
	public ArrayList<AsignacionComisionProfesor> getProfesoresAsignados(){
		return this.profesoresAsignados;
	}
	
	public boolean tieneAlumno(Integer idAlumno) {
		boolean curso = false;
		int i=0;
		while(!curso && i<this.alumnosAsignados.size()) {
			if(this.alumnosAsignados.get(i).getDniAlumno().equals(idAlumno)) {
				curso = true;
			}
			i++;
		}
		return curso;
	}
	
	public boolean alumnoAproboCursada(Integer dniAlumno) {
		boolean aprobo = false;
		int i=0;
		while(!aprobo && i<this.alumnosAsignados.size()) {
			if(this.alumnosAsignados.get(i).getDniAlumno().equals(dniAlumno) && this.alumnosAsignados.get(i).getNotasAlumno().aprobado()) {
				aprobo = true;
			}
			i++;
		}
		return aprobo;
	}
	
	public boolean alumnoPromocionoCursada(Integer dniAlumno) {
		boolean promociono = false;
		int i=0;
		while(!promociono && i<this.alumnosAsignados.size()) {
			if(this.alumnosAsignados.get(i).getDniAlumno().equals(dniAlumno) && this.alumnosAsignados.get(i).getNotasAlumno().promociono()) {
				promociono = true;
			}
			i++;
		}
		return promociono;
	}

	
	public RegistroDeNotas buscarNotasAlumno(Integer dniAlumno) {
		RegistroDeNotas notas = null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i<this.alumnosAsignados.size()) {
			if(this.alumnosAsignados.get(i).getDniAlumno().equals(dniAlumno)) {
				notas = this.alumnosAsignados.get(i).getNotasAlumno();
			}
			i++;
		}
		return notas;
	}
	
	public boolean vacantesProfesores() {
		boolean asignable = true;
		Integer cantidad = (this.alumnosAsignados.size()/20)+1;
		if(this.profesoresAsignados.size()>=cantidad) {
			asignable = false;
		}
		return asignable;
	}

	public boolean asignarNotaAlumno(Integer dniAlumno, Integer nota, TipoNota tipoNota) {
		boolean asignado = false;
		RegistroDeNotas notas = this.buscarNotasAlumno(dniAlumno);
		switch(tipoNota) {
		case PRIMERPARCIAL:
			asignado = notas.setPrimerParcial(nota);
			break;
		case SEGUNDOPARCIAL:
			asignado = notas.setSegundoParcial(nota);
			break;
		case PRIMERRECUPERATORIO:
			asignado = notas.setPrimerRecuperatorio(nota);
			break;
		case SEGUNDORECUPERATORIO:
			asignado = notas.setSegundoRecuperatorio(nota);
			break;
		}
		return asignado;
	}
	
	public Integer obtenerNotaFinalAlumno(Integer dniAlumno) {
		Integer notaFinal = 0;
		RegistroDeNotas notas = this.buscarNotasAlumno(dniAlumno);
		notas.setNotaFinal();
		notaFinal = notas.getNotaFinal();
		return notaFinal;
	}
	
}
