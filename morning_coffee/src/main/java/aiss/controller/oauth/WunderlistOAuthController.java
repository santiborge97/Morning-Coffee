package aiss.controller.oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.restlet.resource.ClientResource;


import aiss.WunderlistRequest;
import aiss.WunderlistToken;



public class WunderlistOAuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String code = request.getParameter("code");
		ClientResource cr = new ClientResource("https://www.wunderlist.com/oauth/access_token");
		
		
	    WunderlistRequest json = new WunderlistRequest();
    	json.setClient_id("4017379b2bb52043c811");
		json.setClient_secret("f943802799f6516084619132c993e5c4c65dd934216bd52b2766a1b34f0a");
		json.setCode(code);
		WunderlistToken respuesta = cr.post(json, WunderlistToken.class);
		
		
		request.getSession().setAttribute("Wunderlist-token", respuesta.getAccess_token());
		request.getRequestDispatcher("/step_three.jsp").forward(request, response);
		

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
		
	}


		
}
