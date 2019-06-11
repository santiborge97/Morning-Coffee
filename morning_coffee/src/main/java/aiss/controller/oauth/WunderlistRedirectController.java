package aiss.controller.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.restlet.resource.ClientResource;


import aiss.WunderlistRequest;
import aiss.WunderlistToken;



public class WunderlistRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendRedirect("https://www.wunderlist.com/oauth/authorize?client_id=4017379b2bb52043c811&redirect_uri=http://proyecto-morning-coffee.appspot.com/Wunderlist&state=RANDOM");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
		
	}

		
}
