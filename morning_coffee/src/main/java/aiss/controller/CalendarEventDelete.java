package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.GoogleCalendarResource;

public class CalendarEventDelete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarEventDelete.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		if(id!=null && !"".equals(id)){
			String accessToken=(String)req.getSession().getAttribute("GoogleCalendar-token");
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleCalendarResource gcResource=new GoogleCalendarResource(accessToken);
				gcResource.deleteEvent(id);
				log.info("Event with id '"+id+"' deleted!");
				req.getRequestDispatcher("/event_success.jsp").forward(req,resp);
			}else{
				log.info("Trying to acces to google calendar without an acces token, redirecting to index");
				req.getRequestDispatcher("index.jsp").forward(req,resp);
			}
		}else{
			log.warning("Invalid id for delete!");
			req.getRequestDispatcher("/GoogleCalendarList").forward(req,resp);
		}
	}
}
