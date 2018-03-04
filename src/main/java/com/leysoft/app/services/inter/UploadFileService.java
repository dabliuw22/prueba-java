package com.leysoft.app.services.inter;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

	public String save(MultipartFile file) throws IOException;
	
	public boolean delete(String fileName);
}