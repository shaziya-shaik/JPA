package com.Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {
	
@Autowired	
AlienRepository Repo;
@GetMapping("/aliens")
public List<Alien> getAlien() {
	List<Alien> aliens=(List<Alien>)Repo.findAll();
//	Alien a1=new Alien();
//	a1.setId(101);
//	a1.setName("shaziya");
//	a1.setPoint(89);
//	
//	Alien a2=new Alien();
//	a2.setId(102);
//	a2.setName("begum");
//	a2.setPoint(95);
//	aliens.add(a1);
//	aliens.add(a2);
	return aliens;
}
}
