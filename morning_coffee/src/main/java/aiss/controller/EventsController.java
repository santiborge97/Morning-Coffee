package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.calendar.Events;
import aiss.model.resource.GoogleCalendarResource;
import aiss.model.resource.WunderlistResource;
import aiss.model.wunderlist.Task;
import aiss.model.wunderlist.WunderList;


public class EventsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8930513968667948676L;
	private static final Logger log = Logger.getLogger(EventsController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessTokenCalendar=(String)req.getSession().getAttribute("GoogleCalendar-token");
		String accessTokenWunderlist = (String) req.getSession().getAttribute("Wunderlist-token");
		if(accessTokenCalendar!=null && !"".equals(accessTokenCalendar) && accessTokenWunderlist!=null && !"".equals(accessTokenWunderlist)){
			//Creamos recursos de Wunderlist y Google Calendar
			GoogleCalendarResource gcResource=new GoogleCalendarResource(accessTokenCalendar);
			WunderlistResource wlResource = new WunderlistResource(accessTokenWunderlist);
			
			//Predefinimos la Id del calendario como primaria y se obtienen sus eventos (se pone así por si en un futuro queremos mostrar calendarios personalizados)
			String calendarId = "primary";
			Events events =gcResource.getEvents(calendarId);
			
			
			//Sacamos el array con las listas, del cual sólo nos interesa el primer elemento (el inbox) y su id
			List<WunderList> lists = wlResource.getLists();
			Long inbox_id = lists.get(0).getId().longValue();
			//Lo metemos en la sesión, para posteriores llamadas a la API
			req.getSession().setAttribute("wunderlist_inbox_id", inbox_id);
			
			//Ahora sacamos las tareas del inbox, que son las que vamos a mostrar
			List<Task> tasks = wlResource.getTasks(inbox_id);
			
			if(events!=null && tasks != null){
				req.setAttribute("events", events);
				req.setAttribute("tasks", tasks);
				req.getRequestDispatcher("/EventsView.jsp").forward(req,resp);
			}else if(events == null){
				log.info("The calendar returned is null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("index.jsp").forward(req,resp);
			}else if(tasks == null){
				log.info(
						"The tasks returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}else if(accessTokenCalendar==null || "".equals(accessTokenCalendar)){
			log.info("Trying to acces to google calendar without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}else if(accessTokenWunderlist==null || "".equals(accessTokenWunderlist)){
			log.info("Trying to acces to wunderlist without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}
