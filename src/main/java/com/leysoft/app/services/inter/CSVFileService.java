package com.leysoft.app.services.inter;

import java.util.List;

import com.leysoft.app.entitys.CSVFile;

public interface CSVFileService {
	
	public void save(CSVFile csvFile);
	
	public CSVFile findById(Long id);
	
	public CSVFile findByName(String name);
	
	public List<CSVFile> findAll();
	
	public long count();
	
	public void update(CSVFile csvFile);
	
	public void delete(Long id);
}