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

public class NewTaskController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TasksListController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken = (String) req.getSession().getAttribute("Wunderlist-token");
		if (accessToken != null && !"".equals(accessToken)) {
			WunderlistResource wlResource = new WunderlistResource(accessToken);
			
			//Sacamos el id del inbox y el título de la tarea
			Long inbox_id = (Long) req.getSession().getAttribute("wunderlist_inbox_id");
			String title = req.getParameter("title");
			
			//Si el id del inbox es null, se busca en el recurso
			if(inbox_id == null){
				List<WunderList> lists = wlResource.getLists();
				inbox_id = lists.get(0).getId().longValue();
				//Lo metemos en la sesión, para posteriores llamadas a la API
				req.getSession().setAttribute("wunderlist_inbox_id", inbox_id);
			}
			
			//Creamos la tarea con las dos propiedades
			
			Task new_task = new Task();
			new_task.setTitle(title);
			new_task.setListId(inbox_id);
			
			Task task_response = wlResource.createTask(new_task);
			
			if (task_response != null) {
				req.getRequestDispatcher("event_success.jsp").forward(req, resp);
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
