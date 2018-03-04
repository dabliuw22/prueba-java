package com.leysoft.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.leysoft.app.entitys.CSVFile;
import com.leysoft.app.services.inter.CSVFileService;
import com.leysoft.app.services.inter.UploadFileService;
import com.leysoft.app.util.CSVFileModel;
import com.leysoft.app.util.CSVFileValidator;

@Controller
public class IndexController {
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@Autowired
	private CSVFileService csvFileService;
	
	@Autowired
	private CSVFileValidator csvFileValidator;
	
	@GetMapping(value = {"/"})
	public String index(Model model) {
		model.addAttribute("size", csvFileService.count());
		model.addAttribute("file", new CSVFileModel());
		return "index";
	}
	
	@InitBinder("file")
	public void initBinderCSVFile(WebDataBinder binder) {
		binder.setValidator(csvFileValidator);
	}
	
	@PostMapping(value = {"/"})
	public String index(@Valid @ModelAttribute("file") CSVFileModel file, BindingResult errors) throws Exception {
		csvFileValidator.validate(file, errors);
		if(!errors.hasErrors()) {
			String fileName = uploadFileService.save(file.getFile());
			CSVFile csvFile = new CSVFile();
			csvFile.setName(fileName);
			csvFileService.save(csvFile);
			return "redirect:/";
		}
		return "index";
	}
}
