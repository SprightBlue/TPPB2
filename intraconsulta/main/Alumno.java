package main;

public class Alumno {
	
	//atributos
	private static Integer dniGeneral = 1;
	private Integer dni;
	private String nombre;
	private String apellido;
	
	//constructores
	public Alumno(String nombre, String apellido) {
		this.setDni();
		this.setNombre(nombre);
		this.setApellido(apellido);
	}
	
	//metodos
	public Integer getDni() {
		return dni;
	}

	private void setDni() {
		this.dni = dniGeneral;
		dniGeneral++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
