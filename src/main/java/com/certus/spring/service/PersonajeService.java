package com.certus.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.repository.IPersonaje;

@Service
@Component("servicio1")
@Primary //declara la siguiente clase como la principal a usar por el InterfacePersonajeService
public class PersonajeService implements IPersonajeService{
	
	@Autowired
	IPersonaje personajeRepository;

	// CREANDO METODO CREARPERSONAJE
	public Response<Personaje> crearPersonaje(Personaje personajeRecibido) {
		
		Response<Personaje> response = new Response<>();
		
		//Personaje p = personajeRepository.save(personajeRecibido);
			
		try {
			Personaje p = personajeRepository.save(personajeRecibido);
			response.setEstado(true);
			response.setMensaje("Creado Correctamente");
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje(e.getMessage());
		}
		
		//Validacion de lista de personaje
		/*if(p != null) {
			response.setEstado(true);
			response.setMensaje("Creado Correctamente");
		}else {
			response.setEstado(false);
			response.setMensaje("Se produjo un error al crear los personajes");
		}*/

		return response;
	}

	public String editarPersonaje() {
		return "Se a editado un personaje";
		
	}
	
	
	@Override
	public Response<Personaje> listarPersonaje() {
		
		List<Personaje> listita = new ArrayList<>();
		
		Response<Personaje> response = new Response<>();

		Personaje personaje1 = new Personaje();
		// Agregando datos a los atrinutos de personaje1
		personaje1.setNombre("Luffy");
		personaje1.setAlias("Luffy Alias");
		personaje1.setTipoFruta("Luffy Tipo Fruta");
		personaje1.setHabilidad("Luffy Habilidad");
		personaje1.setTripulacion("Luffy Tripulacion");
		personaje1.setRecompensa("414 123 344");

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
		
		//Validando si hay un personaje
		

		// Agregando un personaje a la lista
		listita.add(personaje1);
		listita.add(personaje2);
		listita.add(personaje3);
		
		
		response.setEstado(true);
		response.setMensaje("Creado Correctamente");
		response.setData(listita);
		
		return response;
	}
	
}
