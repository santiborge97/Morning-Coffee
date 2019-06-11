package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.WunderlistResource;
public class DeleteTaskController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TasksListController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken = (String) req.getSession().getAttribute("Wunderlist-token");
		if (accessToken != null && !"".equals(accessToken)) {
			WunderlistResource wlResource = new WunderlistResource(accessToken);

			// Sacamos el id del inbox y el título de la tarea
			String task_id = req.getParameter("task_id");
			String revision = req.getParameter("revision");

			if (task_id == null) {
				log.log(Level.SEVERE, "Error deleting task. Null id ");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}

			// La operación devolverá un boolean

			boolean success = wlResource.deleteTask(new Long(task_id), new Integer(revision));

			if (success) {
				req.getRequestDispatcher("event_success.jsp").forward(req, resp);
			}else{
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
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
