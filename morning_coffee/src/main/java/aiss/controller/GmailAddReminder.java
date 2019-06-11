package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.calendar.End;
import aiss.model.calendar.Item;
import aiss.model.calendar.Start;
import aiss.model.resource.GoogleCalendarResource;
import aiss.model.resource.WunderlistResource;
import aiss.model.wunderlist.Task;
import aiss.model.wunderlist.WunderList;

public class GmailAddReminder extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GmailAddReminder.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessTokenCalendar = (String) req.getSession().getAttribute("GoogleCalendar-token");
		String accessTokenWunderlist = (String) req.getSession().getAttribute("Wunderlist-token");
		if (accessTokenCalendar != null && !"".equals(accessTokenCalendar) && accessTokenWunderlist != null
				&& !"".equals(accessTokenWunderlist)) {
			// Creamos recursos de Wunderlist y Google Calendar
			GoogleCalendarResource gcResource = new GoogleCalendarResource(accessTokenCalendar);
			WunderlistResource wlResource = new WunderlistResource(accessTokenWunderlist);

			// Sacamos el id del inbox y el título de la tarea
			Long inbox_id = (Long) req.getSession().getAttribute("wunderlist_inbox_id");
			String title = req.getParameter("title");

			// Si el id del inbox es null, se busca en el recurso
			if (inbox_id == null) {
				List<WunderList> lists = wlResource.getLists();
				inbox_id = lists.get(0).getId().longValue();
				// Lo metemos en la sesión, para posteriores llamadas a la API
				req.getSession().setAttribute("wunderlist_inbox_id", inbox_id);
			}

			// Creamos la tarea con las dos propiedades

			Task new_task = new Task();
			new_task.setTitle(title);
			new_task.setListId(inbox_id);

			Task task_response = wlResource.createTask(new_task);

			/*
			 * Sacamos las variables de fecha inicio y fin, creamos un objeto
			 * Start y End al que le hacemos un set de Date(que es lo necesario
			 * para hacer un post)
			 */
			String inicio = (String) req.getParameter("startDate");
			Start start = new Start();
			start.setDate(inicio);
			String fin = (String) req.getParameter("endDate");
			End end = new End();
			end.setDate(fin);

			// Creamos un objeto Item (que es un evento) al cual le asignamos
			// las variables anteriores
			Item item = new Item();
			item.setSummary(title);
			item.setStart(start);
			item.setEnd(end);

			// Se obtiene el evento creado
			Item event_response = gcResource.createEvent(item);

			if (event_response != null && task_response != null) {
				req.getRequestDispatcher("/event_success.jsp").forward(req, resp);
			} else if (event_response == null) {
				log.info(
						"The calendar returned is null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} else if (task_response == null) {
				log.info(
						"The tasks returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} else if (accessTokenCalendar == null || "".equals(accessTokenCalendar)) {
			log.info("Trying to acces Google Calendar without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else if (accessTokenWunderlist == null || "".equals(accessTokenWunderlist)) {
			log.info("Trying to acces to wunderlist without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
