package com.certus.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity //MAPEAR
@Table(name = "personaje")//ASIGNAR NOMBRE A LA BASE
public class Personaje {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE.IDENTITY)   //EVITAR MANIPULACION DEL ID Y TENER SEGURIDAD DE Q NO SE REPITA
	private int idPersonaje;
	
	//Personaliza aviso con "message"
	@NotEmpty(message = "Completar el nombre del personaje")
	private String nombre;
	
	@Size(min = 5, message = "El alias debe contener al menos 5 caracteres")
	@NotEmpty(message="Completar el alias del personaje")
	private String alias;
	
	@NotEmpty
	private String tipoFruta;
	
	@NotEmpty
	private String habilidad;
	
	@NotEmpty
	private String tripulacion;
	
	@NotEmpty
	private String recompensa;
	
	@NotEmpty(message="Indicar la ruta de la imagen para el personaje")
	private String uriImagen;
	

	public int getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	public String getUriImagen() {
		return uriImagen;
	}
	public void setUriImagen(String uriImagen) {
		this.uriImagen = uriImagen;
	}
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
