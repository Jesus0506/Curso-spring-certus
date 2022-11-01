package com.certus.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.models.Personaje;
import com.certus.spring.service.PersonajeService;

@Controller
@RequestMapping("/app")
public class HomeController {
	
	@Value("${title.generic}")
	private String titlePage;

	@GetMapping({"/home","/inicio","/","/Home","/Inicio"})
	public String HolaMundo(Model model) {   
		
		//Instanciamos un personaje2 de tipo Personje
		Personaje personaje1 = new Personaje();
		
		//Agregando datos a los atrinutos de personaje1
		personaje1.setNombre("Luffy");
		personaje1.setAlias("Luffy Alias");
		personaje1.setTipoFruta("Luffy Tipo Fruta");
		personaje1.setHabilidad("Luffy Habilidad");
		personaje1.setTripulacion("Luffy Tripulacion");
		personaje1.setRecompensa("414 123 344");
		
		//Instanciando una lista del tipo List del tipo Personaje
		List<Personaje> listita = new ArrayList<>();
		
		//Instanciamos un personaje2 del tipo Personaje
		Personaje personaje2 = new Personaje();
		
		//Agregando datos a los atrinutos de personaje2
		personaje2.setNombre("Luffy 2");
		personaje2.setAlias("Luffy Alias 2");
		personaje2.setTipoFruta("Luffy Tipo Fruta 2");
		personaje2.setHabilidad("Luffy Habilidad 2");
		personaje2.setTripulacion("Luffy Tripulacion 2");
		personaje2.setRecompensa("567 445 345 654");
		
		
		//Agregando un personaje a la lista
		listita.add(personaje1);
		listita.add(personaje2);
		
		//PesonajeService personaje3 = new PersonajeService();
		
		
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("Titulo", "Seccion J98");
		model.addAttribute("Listita", listita);
		
		return "Home";
		
	}
}
