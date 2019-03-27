package com.yunus.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.yunus.webproject.entity.User;

import com.yunus.webproject.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String homePage() {
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeaders() {

		return "leaders";
	}

	@GetMapping("/systems")
	public String showSystems(Model theModel, String roles) {

		// get users from the service
		List<User> theUsers = userService.getUsers();
		theModel.addAttribute("user", theUsers);

		return "systems";
	}

	// With @RequestParam annotation we can access query parameter.
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("userId") int theId, Model theModel) {

		User theUser = userService.getUser(theId);
		theModel.addAttribute("user", theUser);

		return "update-user";
	}

	@PostMapping("/processUpdate")
	public String processUpdate(@ModelAttribute("user") User user) {

		userService.saveUser(user);

		return "redirect:/systems";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		userService.deleteUser(theId);
		return "redirect:/systems";
	}
}
