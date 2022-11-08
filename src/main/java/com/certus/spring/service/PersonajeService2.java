package com.certus.spring.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;

@Service
@Component("servicio2")
public class PersonajeService2 implements IPersonajeService{

	// CREANDO METODO CREARPERSONAJE
	public Response<Personaje> crearPersonaje() {

		Response<Personaje> response = new Response<>();

		boolean estadoCreacion = false;

		// Instanciando una lista del tipo List del tipo Personaje
		List<Personaje> listita = new ArrayList<>();

		Personaje personaje1 = new Personaje();
		// Agregando datos a los atrinutos de personaje1
		personaje1.setNombre("Luffy v2");
		personaje1.setAlias("Luffy Alias v2");
		personaje1.setTipoFruta("Luffy Tipo Fruta v2");
		personaje1.setHabilidad("Luffy Habilidad v2");
		personaje1.setTripulacion("Luffy Tripulacion v2");
		personaje1.setRecompensa("414 123 344  v2");

		// Instanciamos un personaje2 del tipo Personaje
		Personaje personaje2 = new Personaje();
		// Agregando datos a los atrinutos de personaje2
		personaje2.setNombre("Luffy 2");
		personaje2.setAlias("Luffy Alias 2");
		personaje2.setTipoFruta("Luffy Tipo Fruta 2");
		personaje2.setHabilidad("Luffy Habilidad 2");
		personaje2.setTripulacion("Luffy Tripulacion 2");
		personaje2.setRecompensa("567 445 345 654");

		Personaje personaje3 = new Personaje();
		personaje3.setNombre("Luffy 3");
		personaje3.setAlias("Luffy Alias 3");
		personaje3.setTipoFruta("Luffy Tipo Fruta 3");
		personaje3.setHabilidad("Luffy Habilidad 3");
		personaje3.setTripulacion("Luffy Tripulacion 3");
		personaje3.setRecompensa("567 445 323 244");

		// Agregando un personaje a la lista
		listita.add(personaje1);
		listita.add(personaje2);
		listita.add(personaje3);
		
		//Validacion de lista de personaje
		if(listita.size()>0) {
			estadoCreacion = true;
			response.setEstado(estadoCreacion);
			response.setMensaje("Creado Correctamente");
			response.setData(listita);
		}else {
			estadoCreacion = true;
			response.setEstado(estadoCreacion);
			response.setMensaje("Se produjo un error al crear los personajes");
		}
			
			
		
		return response;
	}

	public String editarPersonaje() {
		return "Se a editado un personaje";
		
	}
	
	public String demoMetodo(Personaje p) {
		String respuesta = "procesando";
		if (p != null) {
			respuesta = "Todo OK Servicio2";
		}
		
		return respuesta;
	}
	
}
