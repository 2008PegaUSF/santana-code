package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestHelper {
	
	/*
	 * RequstHelper acts as a table of contents, it will specify what classes and methods are invoked depending on what request URL we use. 
	 */

	public static void direction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println(request.getRequestURI());
		
		String s = request.getRequestURI();
		
		HttpSession ses = request.getSession();
	
		switch(s) {
		
		case "/HouseAdventure/api/forward":
			if(ses.getAttribute("previous").equals("Lobby")) {
				System.out.println(ses.getAttribute("previous"));
				ses.setAttribute("previous", "Foyer");
				RoomController.getFoyerPage(request, response);
			}
			else if(ses.getAttribute("position").equals("Foyer")) {
				ses.setAttribute("previous", "Living");
				RoomController.getLivingPage(request, response);
			}
			else if(ses.getAttribute("position").equals("Living")) {
				ses.setAttribute("previous", "Kitchen");
				RoomController.getKitchenPage(request, response);
			}
			
			break;
			
		case "/HelloFrontController/api/back":
			if(ses.getAttribute("position").equals("Kitchen")) {
				ses.setAttribute("previous", "Kitchen");
				RoomController.getLivingPage(request, response);
			}
			else if(ses.getAttribute("position").equals("Living")) {
				RoomController.getFoyerPage(request, response);
			}
			else if(ses.getAttribute("position").equals("Bathroom")) {
				RoomController.getBedroomPage(request, response);
			}
			break;
			
		//In this case, the endpoint "home" will invoke the home method inside of HomeController, giving us the homepage. 
		case "/HelloFrontController/api/left":
			if(ses.getAttribute("position").equals(""))
			break;
			
		case "/HelloFrontController/api/right":
			//RoomController.getLivingPage(request,response);
			break;
			
		default:
			ses.setAttribute("previous", "Lobby");
			RoomController.getLobbyPage(request, response);
		}
		
		
			
	}

}
