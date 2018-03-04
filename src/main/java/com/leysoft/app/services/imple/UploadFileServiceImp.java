package com.leysoft.app.services.imple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.leysoft.app.services.inter.UploadFileService;

@Service
public class UploadFileServiceImp implements UploadFileService {

	@Override
	public String save(MultipartFile file) throws IOException {
		String name = UUID.randomUUID().toString() + file.getOriginalFilename();
		Path path = Paths.get("files").resolve(name).toAbsolutePath();
		Files.copy(file.getInputStream(), path);
		return name;
	}

	@Override
	public boolean delete(String fileName) {
		Path path = Paths.get("files").resolve(fileName).toAbsolutePath();
		if(path.toFile().exists() && path.toFile().canRead()) {
			path.toFile().delete();
			return true;
		}
		return false;
	}
}