package com.certus.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.certus.spring.models.Personaje;

public interface IPersonaje extends CrudRepository<Personaje, Integer>{
	
}
