package com.certus.spring.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Personaje {
	//Personaliza aviso con "message"
	@NotEmpty(message = "Completar el nombre del personaje")
	private String nombre;
	
	@Size(min = 5, message = "El alias debe contener al menos 5 caracteres")
	private String alias;
	
	@NotEmpty
	private String tipoFruta;
	
	@NotEmpty
	private String habilidad;
	
	@NotEmpty
	private String tripulacion;
	
	@NotEmpty
	private String recompensa;
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTipoFruta() {
		return tipoFruta;
	}
	public void setTipoFruta(String tipoFruta) {
		this.tipoFruta = tipoFruta;
	}
	public String getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
	public String getTripulacion() {
		return tripulacion;
	}
	public void setTripulacion(String tripulacion) {
		this.tripulacion = tripulacion;
	}
	public String getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(String recompensa) {
		this.recompensa = recompensa;
	}
	
	
	
}
