package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RoomController {

	/*
	 * HomeController is a simple class, all it does is forward out home page. 
	 * By forwarding the resource (the html page) we hide the resource path.
	 */
	
//	public static void getHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		if(request.getSession(false) == null ) {
//			response.setStatus(476); //476--you really screwed up
//			response.sendRedirect("https://www.fbi.gov/");
//		} else {
//			
//			//To forward, we need use the request dispather
//			RequestDispatcher rd = request.getRequestDispatcher("/HomePage.html"); //What is the request dispather? What does it do?
//			
//			rd.forward(request, response); //We invoke the forward() method inside of request dispatcher. 
//			
//		}
//		
//		
//		
//		
//		
//	}
	
	public static void getLobbyPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/lobby.html"); //What is the request dispather? What does it do?
		
		rd.forward(request, response);
		HttpSession s = request.getSession();
		s.setAttribute("position", "Foyer");
		s.setAttribute("previous", "Lobby");
	}
	
	public static void getFoyerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/foyer.html"); //What is the request dispather? What does it do?
		
		rd.forward(request, response);
		HttpSession s = request.getSession();
		s.setAttribute("position", "Foyer");
	}
	
	public static void getLivingPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/living.html"); //What is the request dispather? What does it do?
		
		rd.forward(request, response);
		HttpSession s = request.getSession();
		s.setAttribute("position", "Living");
	}
	
	public static void getBedroomPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/bed.html"); //What is the request dispather? What does it do?
		
		rd.forward(request, response);
		HttpSession s = request.getSession();
		s.setAttribute("position", "Bedroom");
	}
	
	public static void getBathroomPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/bath.html"); //What is the request dispather? What does it do?
		
		rd.forward(request, response);
		HttpSession s = request.getSession();
		s.setAttribute("position", "Bathroom");
	}
	
	public static void getKitchenPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/kitchen.html"); //What is the request dispather? What does it do?
		
		rd.forward(request, response);
		HttpSession s = request.getSession();
		s.setAttribute("position", "Kitchen");
	}


}
