package com.certus.spring.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.certus.spring.models.Personaje;
import com.certus.spring.service.IPersonajeService;
//import com.certus.spring.service.PersonajeService;


@Controller
@RequestMapping("/app")
public class HomeController {
	
	@Value("${title.generic}")
	private String titlePage;
	
	@Autowired //VE AL CONTENEDOR Y BUSCA PERSONAJESERVICE
	@Qualifier("servicio1")
	private IPersonajeService InterfacePersonaje1;
	
	
	@Autowired
	@Qualifier("servicio2")
	private IPersonajeService InterfacePersonaje2;
	//private PersonajeService personaje = new PersonajeService();

	@GetMapping({"/home","/inicio","/","/Home","/Inicio"})
	public String Home(Model model) {   
		
		//Instanciamos un personaje2 de tipo Personje
		
		
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("Titulo", "Seccion J98");
		
		//List<Personaje> listasUnidas = new ArrayList<>();
		
		if (InterfacePersonaje1.crearPersonaje().getEstado()) {
			
			model.addAttribute("Listita",InterfacePersonaje1.crearPersonaje().getData());
			
		}
		
		model.addAttribute("Estado",InterfacePersonaje1.crearPersonaje().getMensaje());
		
		Personaje personaje = new Personaje();
		
		String respuesta = InterfacePersonaje2.demoMetodo(personaje);		
		
		model.addAttribute("respuesta", respuesta);
		
		return "Home";
		
	}
	
	@GetMapping("/crear")
	public String Formulario(Model model) {
		
		model.addAttribute("TituloPagina",titlePage);
		model.addAttribute("titulo", "Crear Personaje");
		
		Personaje personaje = new Personaje();
		
		model.addAttribute("personaje", personaje);
		
		return "Formulario";
		
	}
	
	@PostMapping("/form")
	public String crear(@Valid Personaje Luffy, BindingResult result, Model model) {
		
		
		//Detectar errores (Si result tieneErrores)
		if (result.hasErrors()) {
			//model.addAttribute("Titulo","ERROR-69 -- Deja de ver nopor");
			
			Map<String, String> erroresPersonaje = new HashMap<>();	
			
			result.getFieldErrors().forEach(PersonajeErrores -> {
				
				erroresPersonaje.put(PersonajeErrores.getField(), PersonajeErrores.getDefaultMessage());
			});
			
			model.addAttribute("TituloPagina",titlePage);
			model.addAttribute("titulo", "PersonajeCreado");
			model.addAttribute("error",erroresPersonaje);
			model.addAttribute("personaje", Luffy);
			
			return "Formulario";
			
		}
		
		model.addAttribute("TituloPagina",titlePage);
		model.addAttribute("titulo", "PersonajeCreado");
		
		
		model.addAttribute("personaje", Luffy);
		
		
		return "Formulario";
	}
	
}
