package com.leysoft.app.util;

import org.springframework.web.multipart.MultipartFile;

public class CSVFileModel {
	
	private MultipartFile file;

	public CSVFileModel() {}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}