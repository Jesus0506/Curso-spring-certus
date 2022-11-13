package com.certus.spring.controller;



//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

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
//import org.springframework.web.bind.annotation.RequestParam;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;
import com.certus.spring.service.IPersonajeService;
//import com.certus.spring.service.PersonajeService;


@Controller
@RequestMapping("/app")
public class HomeController {
	
	@Value("${title.generic}")
	private String titlePage;
	
	@Value("${mensaje}")
	private String mensaje;
	
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
		model.addAttribute("titulo", "Seccion J98-- Pagina Inicio");
		model.addAttribute("mensaje", mensaje);
		
		return "Home";
		
	}
	
	@GetMapping("/listar")
	public String ListarPersonaje(Model model) {
		
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Seccion J98--Listado");
		model.addAttribute("mensaje", mensaje);
		
		Response<Personaje> rspta= InterfacePersonaje1.listarPersonaje();
		
		
		model.addAttribute("Listita", rspta.getData());
		
		
		
		
		return "lista";
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
	public String crearPersonaje(@Valid Personaje Luffy, BindingResult result, Model model) {
		
		//Detectar errores (Si result tieneErrores)
		if (result.hasErrors()) {
			
			return "Formulario";
			
		}
		
		Response<Personaje> rspta= InterfacePersonaje1.crearPersonaje(Luffy);
		
		if(rspta.getEstado()) {
			return "redirect:lista";
		}else {
			model.addAttribute("mensaje", rspta.getMensaje());
			return "redirect:Error";
		}
		
		
	}
	
}
