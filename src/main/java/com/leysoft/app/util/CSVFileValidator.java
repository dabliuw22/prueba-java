package com.leysoft.app.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CSVFileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CSVFileModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CSVFileModel file = (CSVFileModel) obj;
		if(file != null) {
			if(file.getFile().isEmpty()) {
				errors.rejectValue("file", "file.file", "Debes cargar un fichero");
			}
			if(!file.getFile().getContentType().contains("csv")) {
				errors.rejectValue("file", "file.file", "Debes cargar un fichero .csv");
			}
		}
	}
}
