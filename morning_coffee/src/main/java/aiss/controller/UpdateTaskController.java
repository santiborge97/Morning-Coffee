package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.WunderlistResource;
import aiss.model.wunderlist.Task;



public class UpdateTaskController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TasksListController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken = (String) req.getSession().getAttribute("Wunderlist-token");
		if (accessToken != null && !"".equals(accessToken)) {
			WunderlistResource wlResource = new WunderlistResource(accessToken);
			
			//Sacamos el id del inbox, la revisión y el título de la tarea
			Long inbox_id = (Long) req.getSession().getAttribute("wunderlist_inbox_id");
			Long task_id = new Long(req.getParameter("task_id"));
			String task_title = req.getParameter("task_title");
			Integer revision = new Integer(req.getParameter("revision"));
			
			if(task_id == null || task_title == null || revision == null){
				log.log(Level.SEVERE, "Error deleting task. Null parameters");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				return;
			}
			
			//Simulamos actualización: Primero se borra la tarea
			
			boolean success = wlResource.deleteTask(task_id, revision);
			
			//A continuación, creamos una nueva con el título a "editar"
			
			Task task_To_Update = new Task();
			task_To_Update.setTitle(task_title);
			task_To_Update.setListId(inbox_id);
			
			//Creamos la tarea
			
			Task updated_task = wlResource.createTask(task_To_Update);
			
			if(success && updated_task!=null){
				req.getRequestDispatcher("event_success.jsp").forward(req, resp);
			} else{
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
