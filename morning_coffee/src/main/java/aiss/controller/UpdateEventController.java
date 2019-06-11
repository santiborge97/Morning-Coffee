package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.calendar.End;
import aiss.model.calendar.Item;
import aiss.model.calendar.Start;
import aiss.model.resource.GoogleCalendarResource;

public class UpdateEventController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarEventInsert.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
		if (accessToken != null && !"".equals(accessToken)) {
			GoogleCalendarResource gcResource = new GoogleCalendarResource(accessToken);
			
			//Sacamos la variable Summary e Id del formulario
			String summary = (String) req.getParameter("summary");
			String id = (String) req.getParameter("event_id");
			
			/*Sacamos las variables de fecha inicio y fin, creamos un objeto Start y End
			al que le hacemos un set de Date(que es lo necesario para hacer un post)*/
			String inicio = (String) req.getParameter("startDate");
			Start start = new Start();
			start.setDate(inicio);
			String fin = (String) req.getParameter("endDate");
			End end = new End();
			end.setDate(fin);
			
			//Creamos un objeto Item (que es un evento) al cual le asignamos las variables anteriores
			Item item = new Item();
			item.setSummary(summary);
			item.setStart(start);
			item.setEnd(end);
			
			//Se obtiene el evento creado
			boolean success = gcResource.updateEvent("primary", id, item);
			
			
			if (success) {
				req.getRequestDispatcher("event_success.jsp").forward(req, resp);
			} else {
				log.info(
						"The event returned is null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} else {
			log.info("Trying to acces Google Calendar without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
