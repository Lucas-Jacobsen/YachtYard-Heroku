package com.yacht.controller;

import javax.validation.Valid;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yacht.data.BoatDataService;
import com.yacht.data.UserDataService;
import com.yacht.model.BoatModel;
import com.yacht.model.UserModel;


@Controller
@RequestMapping("/")
public class BoatController
{
	//dependency injection for repository
	@Autowired
	private BoatDataService boatDataService;
	private UserDataService userDataService;
	
	//constructor injection to inject repository
	public BoatController(BoatDataService boatDataService, UserDataService userDataService)
	{
		this.boatDataService = boatDataService;
		this.userDataService = userDataService;
		
	}
	
	//Endpoint methods 

	@GetMapping("/")
    public String root() {
        return "login"; 
    }
	
	@GetMapping("/login")
    public String login() {
		
        return "login"; // Assuming "login.html" is in resources/templates.
    }
	@GetMapping("/signup")
    public String signup(Model model) {
		
		model.addAttribute("user", new UserModel());
        return "signup"; // Assuming "login.html" is in resources/templates.
    }
	@PostMapping("/doSignup")
    public String doSignup( @Valid UserModel newUser, BindingResult br, Model model) {
		
			if(br.hasErrors())
		{
			model.addAttribute("title", "New Boat");
			return "createBoat";
		}
		System.out.printf("IN CONTROLLER: id: %d\nusername: %s\npassword: %s\nrole: %s\nEnables: %d" ,newUser.getId(), newUser.getUsername(), newUser.getPassword(), newUser.getRole(), newUser.getEnabled());
		userDataService.create(newUser);
		return "redirect:/login";
    }
	@GetMapping("/boats")
	public String showAllBoats(Model model)
	{
		model.addAttribute("boats", boatDataService.getAll());
		model.addAttribute("title", "All Boats");	
		return "allBoats";

	}
	
	@GetMapping("boats/oneBoat/{id}")
	public String showOneBoat(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("boat", boatDataService.getById(id));
		model.addAttribute("title", "One Boat");
		
		return "oneBoat";
	}
	
	@GetMapping("/boats/editBoat/{id}")
	public String editBoat(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("boat", boatDataService.getById(id));
		model.addAttribute("title", "Edit Boat");
		return "editBoat";
	}
	
	@GetMapping("/boats/processEdit")
	public String doUpdate(BoatModel boatModel, BindingResult br, Model model)
	{
		boatDataService.update(boatModel);
		return "redirect:/boats";
	}
	
	
	@GetMapping("/boats/newBoat")
	public String NewBoat(Model model)
	{
		model.addAttribute("boat", new BoatModel());
		model.addAttribute("title", "New Boat");
		return "createBoat";
	}
	

	@PostMapping("/boats/processCreate")
	public String doCreate(@Valid BoatModel boatModel, BindingResult br, Model model)
	{
		if(br.hasErrors())
		{
			model.addAttribute("title", "New Boat");
			return "createBoat";
		}
		boatDataService.create(boatModel);
		return "redirect:/boats";
	}
	
	@GetMapping("/boats/deleteBoat/{id}")
	public String deleteBoat(@PathVariable("id") int id, Model model)
	{
		boatDataService.deleteById(id);
		return "redirect:/boats";
	}
	
	
	
}
