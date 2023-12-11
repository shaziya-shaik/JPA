package com.Spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Interface.AlienRepo;
import com.Spring.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	@GetMapping("/home")
	public String home() {
		return "home.jsp";
	}

	
	@PostMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		return "success.jsp";
	}

	@GetMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int id) {
		ModelAndView mv=new ModelAndView("show.jsp");
		//Optional<Alien> alien=repo.findById(id);
		
		Alien alien=repo.findById(id).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	@GetMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int id) {
	    repo.deleteById(id);
	    return "redirect:/home"; // Redirect to the home page or any other page after deletion
	}
	
	
	
	
}
