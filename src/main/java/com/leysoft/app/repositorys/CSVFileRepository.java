package com.leysoft.app.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.leysoft.app.entitys.CSVFile;

public interface CSVFileRepository extends CrudRepository<CSVFile, Long> {
	
	public CSVFile findByName(String name);
}
