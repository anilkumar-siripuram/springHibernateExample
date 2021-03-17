/*package com.springmvc.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.Model.FileBucket;

public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return FileBucket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 FileBucket file = (FileBucket) target;
         
	        if(file.getFile()!=null){
	            if (file.getFile().getSize() == 0) {
	                errors.rejectValue("file", "missing.file");
	            }
	        }

	}

}
*/