package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompaniaDTO;
import com.example.demo.entidad.Compania;
import com.example.demo.entidad.Persona;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.CompaniaService;
import com.example.demo.service.PersonaService;

@RestController
public class CompaniaController {

	@Autowired
	private CompaniaService companiaService;

	@GetMapping("/companias")
	
	public List<CompaniaDTO> obtenerCompanias(){
		//Defino mi variable de retorno
		List<CompaniaDTO> response = new ArrayList<CompaniaDTO>();
		//Obtengo las compañias del service
		Iterable<Compania> listado = companiaService.obtenerCompanias();
		//Defino la instancia del modelMapper
		ModelMapper modelMapper = new ModelMapper();
		//Recorro mis listado y agrego a mi variable de retorno
		listado.forEach(compania -> {
			response.add(modelMapper.map(compania, CompaniaDTO.class));
		});
		return response;
	}
	
	
	
//	@RequestMapping("/personas")
//	public List<Persona> getPersona() {
//		return personaService.obtenerPersonas();
//	}

//	@Value("${palabra}")
//	String palabra;
//	
//	@RequestMapping("/palabra")
//	public String obtenerPalabra() {
//		return "La palabra obtenida es: " + palabra;
//	}
}