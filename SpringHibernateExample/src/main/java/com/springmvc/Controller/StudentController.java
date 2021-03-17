package com.springmvc.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dao.StudentDao;
import com.springmvc.Model.Country;
import com.springmvc.Model.Student;
import com.springmvc.Service.StudentService;

@Controller
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;

	
	@RequestMapping(value = "/student",method = RequestMethod.GET)
	public ModelAndView getRegistrationForm(@ModelAttribute("student") Student student) {
		
		ModelAndView model = new ModelAndView("studentRegistration");
		List<Country> countryList =  studentService.findAllCountries();
		model.addObject("countryList", "countryList");
		return model;
	}
	
}
