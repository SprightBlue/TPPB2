package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	
	//atributos
	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<CicloLectivo> fechas;
	private ArrayList<Comision> comisiones;
	private ArrayList<Profesor> profesores;
	private ArrayList<Aula> aulas;
	
	//constructores
	public Sistema(String nombre) {
		this.setNombre(nombre);
		this.materias = new ArrayList<Materia>();
		this.alumnos = new ArrayList<Alumno>();
		this.fechas = new ArrayList<CicloLectivo>();
		this.comisiones = new ArrayList<Comision>();
		this.profesores = new ArrayList<Profesor>();
		this.aulas = new ArrayList<Aula>();
	}
	
	//metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean agregarMateria(Materia materia) {
		boolean agregado = false;
		if(!this.materias.contains(materia)) {
			this.materias.add(materia);
			agregado = true;
		}
		return agregado;
	}
	
	public Materia buscarMateria(Integer idMateria) {
		Materia materia = null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i<this.materias.size()) {
			if(this.materias.get(i)!=null  && this.materias.get(i).getId().equals(idMateria)) {
				materia = this.materias.get(i);
				encontrado = true;
			}
			i++;
		}
		return materia;
	}
	
	public boolean agregarAlumno(Alumno alumno) {
		boolean agregado = false;
		if(!this.alumnos.contains(alumno)) {
			this.alumnos.add(alumno);
			agregado = true;
		}
		return agregado;
	}
	
	public Alumno buscarAlumno(Integer dniAlumno) {
		Alumno alumno = null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i<this.alumnos.size()) {
			if(this.alumnos.get(i)!=null && this.alumnos.get(i).getDni().equals(dniAlumno)) {
				alumno = this.alumnos.get(i);
				encontrado = true;
			}
			i++;
		}
		return alumno;
	}
	
	public boolean agregarCicloLectivo(CicloLectivo cicloLectivo) {
		boolean agregado = false;
		if(!this.fechas.contains(cicloLectivo) && this.verificarCicloLectivo(cicloLectivo)){
			this.fechas.add(cicloLectivo);
			agregado = true;
		}
		return agregado;
	}
	
	//este metodo es para verificar las fechas del ciclo lectivo que se desea agregar al sistema
	private boolean verificarCicloLectivo(CicloLectivo cicloLectivo) {
		boolean verificado = true;
		for(int i=0; i<this.fechas.size(); i++) {
			if( !this.fechas.get(i).getInicio().isAfter(cicloLectivo.getFin()) && 
					!cicloLectivo.getInicio().isAfter(this.fechas.get(i).getFin()) &&
					!this.fechas.get(i).getInicioInscripcion().isAfter(cicloLectivo.getFinInscripcion()) &&
					!cicloLectivo.getInicioInscripcion().isAfter(this.fechas.get(i).getFinInscripcion())){
				verificado = false;
			}
		}
		return verificado;
	}
	
	public CicloLectivo buscarCicloLectivo(Integer idCicloLectivo) {
		CicloLectivo cicloLectivo = null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i<this.fechas.size()) {
			if(this.fechas.get(i)!=null && this.fechas.get(i).getId().equals(idCicloLectivo)) {
				cicloLectivo = this.fechas.get(i);
				encontrado = true;
			}
			i++;
		}
		return cicloLectivo;
	}
	
	public Integer  agregarComision(Integer idMateria, Integer idCicloLectivo, Turno turno, Dia dia) {
		Comision comision = null;
		if(this.buscarMateria(idMateria)!=null && this.buscarCicloLectivo(idCicloLectivo)!=null && 
				this.verificarComision(idMateria, idCicloLectivo, turno)) {
			comision = new Comision(idMateria, idCicloLectivo, turno, dia);
			this.comisiones.add(comision);	
		}
		if(comision!=null) {
			return comision.getId();
		}else {
			return 0;
		}
	}
	
	
	//este metodo es para verificar que tanto la materia, ciclo lectivo y el turno no coincidan con los de otra comisio dentro del sistema
	private boolean verificarComision(Integer idMateria, Integer idCicloLectivo, Turno turno) {
		boolean verificado = true;
		for(int i=0; i<this.comisiones.size(); i++) {
			if(this.comisiones.get(i).getIdMateria().equals(idMateria) && this.comisiones.get(i).getIdCicloLectivo().equals(idCicloLectivo) && 
					this.comisiones.get(i).getTurno().equals(turno)) {
				verificado = false;
			}
		}
		return verificado;
	}
	
	public Comision buscarComision(Integer idComision) {
		Comision comision = null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i<this.comisiones.size()) {
			if(this.comisiones.get(i)!=null && this.comisiones.get(i).getId().equals(idComision)) {
				comision = this.comisiones.get(i);
				encontrado = true;
			}
			i++;
		}
		return comision;
	}
	
	public boolean agregarProfesor(Profesor profesor) {
		boolean agregado = false;
		if(!this.profesores.contains(profesor)) {
			this.profesores.add(profesor);
			agregado = true;
		}
		return agregado;
	}
	
	public Profesor buscarProfesor(Integer dniProfesor) {
		Profesor profesor = null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i<this.profesores.size()) {
			if(this.profesores.get(i)!=null && this.profesores.get(i).getDni().equals(dniProfesor)) {
				profesor = this.profesores.get(i);
				encontrado = true;
			}
			i++;
		}
		return profesor;
	}
	
	public boolean asignarProfesorAComision(Integer idComision, Integer dniProfesor) {
		Comision comision = this.buscarComision(idComision);
		boolean asignado = false;
		if(comision!=null && this.buscarProfesor(dniProfesor)!=null &&
				this.verificarAsignacionProfesorAComision(comision.getProfesoresAsignados(), dniProfesor)) {
			comision.asignarProfesor(dniProfesor);
			asignado = true;
		}
		return asignado;
	}
	
	//este metodo es para verificar que el profesor no se asigne nuevamente a la misma comision
	private boolean verificarAsignacionProfesorAComision(ArrayList<AsignacionComisionProfesor> profesoresAsignados, Integer dniProfesor) {
		boolean verificado = true;
		int i=0;
		while(verificado && i<profesoresAsignados.size()) {
			if(profesoresAsignados.get(i)!=null && profesoresAsignados.get(i).getDniProfesor().equals(dniProfesor)) {
				verificado = false;
			}
			i++;
		}
		return verificado;
	}
	
	public boolean agregarCorrelativa(Integer idMateria, Integer idCorrelativa) {
		boolean agregado = false;
		Materia materia = this.buscarMateria(idMateria);
		if(materia!=null && this.buscarMateria(idCorrelativa)!=null && !materia.tieneCorrelativa(idCorrelativa)) {
			materia.agregarCorrelativa(idCorrelativa);
			agregado = true;
		}
		return agregado;
	}
	
	public boolean eliminarCorrelativa(Integer idMateria, Integer idCorrelativa) {
		boolean eliminado = false;
		Materia materia = this.buscarMateria(idMateria);
		if(materia!=null && this.buscarMateria(idCorrelativa)!=null && materia.tieneCorrelativa(idCorrelativa)) {
			materia.eliminarCorrelativa(idCorrelativa);
			eliminado = true;
		}
		return eliminado;
	}
	
	public boolean asignarAlumnoAComision(Integer idComision, Integer dniAlumno) {
		Comision comision = this.buscarComision(idComision);
		boolean asignado = false;
		if(comision!=null && this.buscarAlumno(dniAlumno)!=null && this.correlativasAprobadas(this.buscarMateria(comision.getIdMateria()).getCorrelativas(), dniAlumno) && 
				this.verificarFechasDeInscripcion(this.buscarCicloLectivo(comision.getIdCicloLectivo())) &&
				this.quedaLugarEnElAula(comision.getIdAula(), comision.getAlumnoAsignados().size()) &&
				this.verificarDisponibilidad(comision.getIdCicloLectivo(), comision.getTurno(), comision.getDia(), dniAlumno) &&
				!this.materiaAprobada(comision.getIdMateria(), dniAlumno)) {
			comision.asignarAlumno(dniAlumno);
			asignado = true;
		}
		return asignado;
	}
	
	//este metodo es para verificar que el alumno tiene las correlativas aprobadas
	private boolean correlativasAprobadas(ArrayList<Integer> idCorrelativas, Integer dniAlumno) {
		boolean aprobado = true;
		int i=0;
		while(aprobado && i<idCorrelativas.size()) {
			if(!this.materiaAprobada(idCorrelativas.get(i), dniAlumno)) {
				aprobado = false;
			}
			i++;
		}
		return aprobado;
	}
	
	//este metodo verifica que la materia esta aprobada por el alumno
	private boolean materiaAprobada(Integer idMateria, Integer dniAlumno) {
		ArrayList<Materia> aprobadas = this.materiasAprobadasPorUnAlumno(dniAlumno);
		boolean aprobada = false;
		int i=0;
		while(!aprobada && i<aprobadas.size()) {
			if(aprobadas.get(i).getId().equals(idMateria)) {
				aprobada = true;
			}
			i++;
		}
		return aprobada;
	}
	
	public ArrayList<Materia> materiasAprobadasPorUnAlumno(Integer idAlumno){
		ArrayList<Materia> aprobadas = new ArrayList<Materia>();
		for(int i=0; i<this.comisiones.size(); i++) {
			if(this.comisiones.get(i).alumnoAproboCursada(idAlumno)) {
				aprobadas.add(this.buscarMateria(this.comisiones.get(i).getIdMateria()));
			}
		}
		return aprobadas;
	}
	
	//este metodo es para verificar que la asignacion del alumno no sea fuera de la fecha de inscripcion
	private boolean verificarFechasDeInscripcion(CicloLectivo cicloLectivo) {
		boolean verificado = false;
		if(!LocalDate.now().isBefore(cicloLectivo.getInicioInscripcion()) && 
				!LocalDate.now().isAfter(cicloLectivo.getFinInscripcion())) {
			verificado = true;
		}
		 
		return verificado;
	}
	
	//este metodo es para verificar la capacidad del aula
	private boolean quedaLugarEnElAula(Integer idAula, int cantidadAlumnos) {
		boolean verificado = false;
		Aula aula = this.buscarAula(idAula);
		if(aula!=null && aula.getCapacidad()>cantidadAlumnos) {
			verificado = true;
		}
		return verificado;
	}
	
	//este metodo verifica si el alumno no cursa otra materia el mismo turno y ciclo
	private boolean verificarDisponibilidad(Integer idCicloLectivo, Turno turno, Dia dia, Integer idAlumno) {
		boolean verificado = true;
		ArrayList<Comision> cursadas = this.comisionesCursadas(idAlumno);
		int i=0;
		while(verificado && i<cursadas.size()) {
			if(cursadas.get(i).getIdCicloLectivo().equals(idCicloLectivo) && cursadas.get(i).getTurno().equals(turno) &&
					cursadas.get(i).getDia().equals(dia)) {
				verificado = false;
			}
			i++;
		}
		return verificado;
	}
	
	//este metodo devuelve las materias cursadas por el alumno
	private ArrayList<Comision> comisionesCursadas(Integer idAlumno){
		ArrayList<Comision> cursadas = new ArrayList<Comision>();
		for(int i=0; i<this.comisiones.size(); i++) {
			if(this.comisiones.get(i).tieneAlumno(idAlumno)) {
				cursadas.add(this.comisiones.get(i));
			}
		}
		return cursadas;
	}
	
	public boolean agregarAula(Aula aula) {
		boolean agregado = false;
		if(!this.aulas.contains(aula)) {
			this.aulas.add(aula);
			agregado = true;
		}
		return agregado;
	}
	
	public Aula buscarAula(Integer idAula) {
		Aula aula = null;
		boolean encontrado = false;
		int i=0;
		while(!encontrado && i<this.aulas.size()) {
			if(this.aulas.get(i)!=null && this.aulas.get(i).getId().equals(idAula)) {
				aula = this.aulas.get(i);
				encontrado = true;
			}
			i++;
		}
		return aula;
	}
	
	public boolean asignarAulaAComision(Integer idComision, Integer idAula) {
		boolean asignado = false;
		Comision comision = this.buscarComision(idComision);
		if(comision!=null && this.buscarAula(idAula)!=null) {
			comision.setIdAula(idAula);
			asignado = true;
		}
		return asignado;
	}
	
	public boolean registrarNota(Integer idComision, Integer dniAlumno, Integer nota) {
		boolean registrado = false;
		Comision comision = this.buscarComision(idComision);
		if(nota>=0 && nota<=10 && comision.tieneAlumno(dniAlumno)) {
			comision.asignarNotaAlumno(dniAlumno, nota);
		}
		return registrado;
	}
	
}
