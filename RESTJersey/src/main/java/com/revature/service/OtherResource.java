package com.revature.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.revature.models.Account;

@Path("/myresource")
public class OtherResource {
	
	
	@GET
	@Path("/greetings")
	@Produces("text/plain")
	public String greetings() {
		return "Hello";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String goodbye() {
		return "Goodbye";
	}
	
	
	@POST
	@Path("/planet")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Account getPlanet(MultivaluedMap<String,String> formParams) {
		
		String name = formParams.get("name").get(0);
		
		return new Account(name);
	}
	
	@GET
	@Path("/accounts")
	@Produces(MediaType.TEXT_PLAIN)
	public String get(@QueryParam UriInfo ui) {
	    MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	    
	    String name = queryParams.getFirst("name");
	    
		return "I hate you " + name;
	}
	
	@GET
	@Path("/accounts/{username}")
	public String nameCase(@PathParam("username") String name) {
		return "Hello, "+ name + ". I hate you for this challenge"; 
	}
	
	@GET
	@Path("/accounts/JSON")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccountInJSON() {

		Account person = new Account();
		person.setName("Ben");
		
		return person;

	}
	
	@POST
	@Path("/accounts/JSON")
	@Consumes(MediaType.APPLICATION_JSON)
	public Account makeName(String jsonRequest){       
	         Account accRequ = MapperUtil.readAsObjectOf(TQARequest.class, jsonRequest);
	    }
	
	
	
	/*
	 * Challenge:
	Retrieve information from the path url /accounts/ben --DONE
	Retrieve information from the path query /accounts?name=ben --DONE
	Retrieve information from sending a JSON --
	 * */
	
	
	
}