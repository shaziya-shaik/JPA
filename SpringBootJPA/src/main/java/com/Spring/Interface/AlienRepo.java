package com.Spring.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	List<Alien> findByTech(String tech);
}
