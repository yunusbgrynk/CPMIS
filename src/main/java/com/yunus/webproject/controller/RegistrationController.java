package com.yunus.webproject.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.yunus.webproject.entity.User;
import com.yunus.webproject.registerUser.registerUser;
import com.yunus.webproject.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger=Logger.getLogger(getClass().getName()); //Logging is the structure used to record mobility in a system.
	
	// This method allows us to use the error validations made by ourselves
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
	
	//@ModelAttribute annotation specifies the property of the Model object and is used to prepare the model data.
	@GetMapping("/showRegistrationForm") 
	public String showMyLoginPage(Model theModel) {
		theModel.addAttribute("registerUser",new registerUser());
		return "registration-form";
	}
	//BindingResult Particular example: use a BindingResult object as an argument for a validate method of a 
	//Validator inside a Controller. From Spring MVC Form Validation with Annotations Tutorial: [ BindingResult ] 
	//is Spring's object that holds the result of the validation and binding and contains errors that may have occurred.

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
							@Valid @ModelAttribute("registerUser") registerUser theRegisterUser,
							BindingResult theBindingResult,
							Model theModel) {
		
		String userName=theRegisterUser.getUserName();
		logger.info("Processing registration form for: "+userName);
		
		//form validation
		if(theBindingResult.hasErrors()) {
			return "registration-form";
		}
		
		//check the database if user already exist
		User existing=userService.getUsernameFromDatabase(userName);
		
		if(existing!=null) {
			theModel.addAttribute("registrationError","User name already exists.");
			
			logger.warning("User name already exists.");
			return "registration-form";
		}
		
		userService.saveUser(theRegisterUser);
		
		logger.info("Successfully created user: " + userName);
        
        return "registration-confirmation";		
	}
}
