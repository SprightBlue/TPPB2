package main;

import java.util.ArrayList;

public class Materia {
	
	//atributos
	private static Integer idGeneral = 1;
	private Integer id;
	private String nombre;
	private ArrayList<Integer> correlativas;
	
	//constructores
	public Materia(String nombre) {
		this.setId();
		this.setNombre(nombre);
		this.correlativas = new ArrayList<Integer>();
	}
	
	//metodos
	public Integer getId() {
		return id;
	}

	private void setId() {
		this.id = idGeneral;
		idGeneral++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean agregarCorrelativa(Integer idCorrelativa) {
		boolean agregado = false;
		if(!this.tieneCorrelativa(idCorrelativa)) {
			this.correlativas.add(idCorrelativa);
			agregado = true;
		}
		return agregado;
	}
	
	public boolean eliminarCorrelativa(Integer idCorrelativa) {
		return this.correlativas.remove(idCorrelativa);
	}
	
	public boolean tieneCorrelativa(Integer idCorrelativa) {
		return this.correlativas.contains(idCorrelativa);
	}
	
	public ArrayList<Integer> getCorrelativas(){
		return this.correlativas;
	}

}
