package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.RequestHelper;

public class MasterServlet extends HttpServlet{

	
	/*
	 * We want the doGet and doPost, we also want the sevice() method
	 *
	 * 
	 * That's why we don't use GenericServlet
	 * 
	 * Servlet(I) -> GenericServlet(AC) -> HttpServlet(AC)
	 * 
	 * Servlet:
	 * 		None of the methods are implemented 
	 * 
	 * GenericServlet:
	 * 		init(), destroy() are implemented
	 * 		service() is not implemented
	 * 
	 * HTTPServlet:
	 * 		all servlet methods are implemented 
	 * 		doGet, doPost, etc. are added to the servlet
	 * 		All the methods are implemented, but they're implemented with nothing
	 * 
	 */
	
	
	/*
	 * 
	 * MASTER SERVLET:
	 * 		It only handles requests and response.
	 * 		It passes the objects onto the RequestHelper.
	 * 			The RequestHelper is a class of our own making, it will dictate how the requests are handled. 
	 * 
	 * 		Why is having only one servlet better than having multiple servlets? 
	 * 
	 * 
	 */
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//We invoke the process method
		RequestHelper.direction(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestHelper.direction(request,response);
	}

	

}