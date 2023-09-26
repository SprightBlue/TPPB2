package main;

public class Profesor {
	
	//atributos
	private static Integer idGeneral = 1;
	private Integer dni;
	private String nombre;
	private String apellido;
	
	//constructores
	public Profesor(String nombre, String apellido) {
		this.setDni();
		this.setNombre(nombre);
		this.setApellido(apellido);
	}
	
	//metodos
	public Integer getDni() {
		return dni;
	}

	private void setDni() {
		this.dni = idGeneral;
		idGeneral++;
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
