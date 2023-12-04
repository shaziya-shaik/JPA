package com.RestFul.DemoRest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("aliens")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces(MediaType.APPLICATION_XML)
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AlienResource {
	
	AlienRepository repo=new AlienRepository();
	@GET
	
	public List<Alien> getAliens() throws SQLException {
		System.out.println("hello");
		
		return repo.getAliens();
	}
	@POST
	@Path("alien")

	public  Alien createAlien(Alien a1) throws SQLException {
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	@GET
	@Path("alien/{id}")
	public Alien getAlien(@PathParam("id") int id) throws SQLException {
		
		return repo.getAlien(id);
}
	
	@PUT
	@Path("alien")

	public  Alien updateAlien(Alien a1) throws SQLException {
		System.out.println(a1);
		if(repo.getAlien(a1.getId()).getId()==0)
			repo.create(a1);
			
		else
		repo.update(a1);
		
		return a1;
	}
	
	@DELETE
	@Path("alien/{id}")
	public Alien DeleteAlien(@PathParam("id") int id) throws SQLException {
		Alien a= repo.getAlien(id);
		if(a.getId()!=0)
			repo.delete(id);
		return a;
	}

}
