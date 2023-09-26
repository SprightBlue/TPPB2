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
		this.setIdAula(0);
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
	
	public boolean alumnoAproboCursada(Integer idAlumno) {
		boolean aprobo = false;
		int i=0;
		while(!aprobo && i<this.alumnosAsignados.size()) {
			if(this.alumnosAsignados.get(i).getDniAlumno().equals(idAlumno) && this.alumnosAsignados.get(i).comisionAprobada()) {
				aprobo = true;
			}
			i++;
		}
		return aprobo;
	}

	public void asignarNotaAlumno(Integer dniAlumno, Integer nota) {
		RegistroDeNotas notas = this.buscarNotasAlumnoAsignado(dniAlumno);
		if(notas!=null) {
			notas.setNota(nota);
		}
	}
	
	public RegistroDeNotas buscarNotasAlumnoAsignado(Integer dniAlumno) {
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

}
