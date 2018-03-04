package com.leysoft.app.services.inter;

import java.io.IOException;
import java.util.List;

import com.leysoft.app.models.Persona;

public interface ReadFileService {
	
	public List<Persona> read() throws IOException;
}