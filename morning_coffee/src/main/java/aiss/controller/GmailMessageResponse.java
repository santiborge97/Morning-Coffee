package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.resource.GmailResource;

public class GmailMessageResponse extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GmailMessageResponse.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req, resp);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String to =req.getParameter("to");
		String from =req.getParameter("from");
		String subject =req.getParameter("subject");
		String body = req.getParameter("body");
		
		if(to!=null && !"".equals(to) && subject!=null && !"".equals(subject) && body!=null && !"".equals(body)){
			String accessToken=(String)req.getSession().getAttribute("Gmail-token");
			if(accessToken!=null && !"".equals(accessToken)){
				GmailResource gmResource=new GmailResource(accessToken);
				
				boolean success = gmResource.sendMessage(to, from, subject, body);
				if(success){
					req.getRequestDispatcher("/GmailSuccess.jsp").forward(req,resp);
				}else{
					req.getRequestDispatcher("/index.jsp").forward(req,resp);
				}
			}else{
				log.info("Trying to acces to gamil without an acces token, redirecting to OAuth servlet");
				req.getRequestDispatcher("index.jsp").forward(req,resp);
			}
		}else{
			log.warning("Invalid parameters for sending an email!");
			req.getRequestDispatcher("/error.jsp").forward(req,resp);
		}
	}
}
