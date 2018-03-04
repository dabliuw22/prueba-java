package com.leysoft.app.services.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.leysoft.app.models.Persona;
import com.leysoft.app.services.inter.ClientService;

@Service
public class ClientServiceImp implements ClientService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${client.rest.url}")
	private String urlClient;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getInforme() {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(urlClient); 
		return restTemplate.getForObject(uriBuilder.toUriString(), List.class);
	}

}
