package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.WunderlistResource;
import aiss.model.wunderlist.Task;
import aiss.model.wunderlist.WunderList;



public class TasksListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TasksListController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken = (String) req.getSession().getAttribute("Wunderlist-token");
		if (accessToken != null && !"".equals(accessToken)) {
			WunderlistResource wlResource = new WunderlistResource(accessToken);
			//Sacamos el array con las listas, del cual sólo nos interesa el primer elemento (el inbox) y su id
			List<WunderList> lists = wlResource.getLists();
			Long inbox_id = lists.get(0).getId().longValue();
			//Lo metemos en la sesión, para posteriores llamadas a la API
			req.getSession().setAttribute("wunderlist_inbox_id", inbox_id);
			
			//Ahora sacamos las tareas del inbox, que son las que vamos a mostrar
			List<Task> tasks = wlResource.getTasks(inbox_id);
			
			if (tasks != null) {
				req.setAttribute("tasks", tasks);
				req.getRequestDispatcher("/EventsView.jsp").forward(req, resp);
			} else {
				log.info(
						"The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} else {
			log.info("Trying to acces to Wunderlist without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
