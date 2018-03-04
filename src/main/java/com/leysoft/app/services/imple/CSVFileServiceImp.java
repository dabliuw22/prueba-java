package com.leysoft.app.services.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.app.entitys.CSVFile;
import com.leysoft.app.repositorys.CSVFileRepository;
import com.leysoft.app.services.inter.CSVFileService;

@Service @Transactional
public class CSVFileServiceImp implements CSVFileService {

	@Autowired
	private CSVFileRepository csvFileRepository; 
	
	@Transactional
	@Override
	public void save(CSVFile csvFile) {
		csvFileRepository.save(csvFile);
	}

	@Transactional(readOnly = true)
	@Override
	public CSVFile findById(Long id) {
		return csvFileRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	@Override
	public CSVFile findByName(String name) {
		return csvFileRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CSVFile> findAll() {
		return (List<CSVFile>) csvFileRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public long count() {
		return csvFileRepository.count();
	}

	@Transactional
	@Override
	public void update(CSVFile csvFile) {
		csvFileRepository.save(csvFile);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		CSVFile csvFile = findById(id);
		if(csvFile != null) {
			csvFileRepository.delete(id);
		}
	}
}