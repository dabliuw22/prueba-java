package com.leysoft.app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.app.models.Persona;
import com.leysoft.app.services.inter.ReadFileService;

@RestController
public class APIController {
	
	@Autowired 
	private ReadFileService readFileService;
	
	@GetMapping(value = "/rest/informe")
	public List<Persona> getPersonas() {
		List<Persona> personas = new ArrayList<>();
		try {
			personas = readFileService.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personas;
	}
}