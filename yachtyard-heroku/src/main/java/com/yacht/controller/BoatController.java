package com.yacht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yacht.data.BoatDataService;
import com.yacht.model.BoatModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/boats")
public class BoatController
{
	//dependency injection for repository
	@Autowired
	private BoatDataService boatDataService;
	
	//constructor injection to inject repository
	public BoatController(BoatDataService boatDataService)
	{
		this.boatDataService = boatDataService;
	}
	
	//Endpoint methods 
	
	@GetMapping("")
	public String showAllBoats(Model model)
	{
		model.addAttribute("boats", boatDataService.getAll());
		model.addAttribute("title", "All Boats");	
		return "allBoats";

	}
	
	@GetMapping("/oneBoat/{id}")
	public String showOneBoat(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("boat", boatDataService.getById(id));
		model.addAttribute("title", "One Boat");
		
		return "oneBoat";
	}
	
	@GetMapping("/editBoat/{id}")
	public String editBoat(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("boat", boatDataService.getById(id));
		model.addAttribute("title", "Edit Boat");
		return "editBoat";
	}
	
	@GetMapping("/processEdit")
	public String doUpdate(BoatModel boatModel, BindingResult br, Model model)
	{
		boatDataService.update(boatModel);
		return "redirect:/boats";
	}
	
	
	@GetMapping("/newBoat")
	public String NewBoat(Model model)
	{
		model.addAttribute("boat", new BoatModel());
		model.addAttribute("title", "New Boat");
		return "createBoat";
	}
	

	@PostMapping("/processCreate")
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
	
	@GetMapping("/deleteBoat/{id}")
	public String deleteBoat(@PathVariable("id") int id, Model model)
	{
		boatDataService.deleteById(id);
		return "redirect:/boats";
	}
	
	
	
}
