package com.yunus.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.yunus.webproject.entity.Project;
import com.yunus.webproject.entity.ProjectInformation;
import com.yunus.webproject.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/1")
	public String project1(Model model,Model model2) {
		
		List<Project> theProject=projectService.getProjects();
		model.addAttribute("project",theProject);
		
		List<ProjectInformation> projectDetail=projectService.getProjectDetails();
		model2.addAttribute("project2",projectDetail);
		
		return "project1";
	}

	
	@GetMapping("/showInfoForm")
	public String showInfoForm(Model model,Model model2,Model model3) {
		model.addAttribute("projectInformation",new ProjectInformation());
		
		List<Project> theProject=projectService.getProjects();
		List<ProjectInformation> projectDetail=projectService.getProjectDetails();
		model2.addAttribute("project",theProject);
		model3.addAttribute("project2",projectDetail);
		return "update-project-detail";
	}
	
	@PostMapping("/processUpInfo")
	public String processUpdateInfo(@ModelAttribute("projectInformation") ProjectInformation projectInformation,
														Model model) {
		projectService.saveDetails(projectInformation);
		return "redirect:/project/1";
	}
	
	@GetMapping("/showProjectForm")
	public String showProjectForm(Model model) {
		
		model.addAttribute("project",new Project());
		
		
		return "test";
	}
	
	@PostMapping("/processSaveProject")
	public String saveProject(@ModelAttribute("project") Project project,
														Model model) {
		projectService.saveProject(project);
		return "redirect:/project/1";
	}

}
