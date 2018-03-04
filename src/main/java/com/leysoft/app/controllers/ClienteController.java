package com.leysoft.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.leysoft.app.services.inter.ClientService;


@Controller
public class ClienteController {
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping(value = "/informe", produces = MediaType.APPLICATION_JSON_VALUE)
	public String cliente(Model model) {
		model.addAttribute("response", clientService.getInforme());
		return "informe";
	}
}
