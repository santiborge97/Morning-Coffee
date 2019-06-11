package aiss.model.resource;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import aiss.model.wunderlist.Task;
import aiss.model.wunderlist.WunderList;

public class WunderlistResource {
	private static final Logger log = Logger.getLogger(WunderlistResource.class.getName());

	private String uriLists = "http://a.wunderlist.com/api/v1/lists";
	private String uriTasks = "https://a.wunderlist.com/api/v1/tasks";
	private String access_token;

	public WunderlistResource(String access_token) {
		this.access_token = access_token;
	}

	public List<WunderList> getLists() {
		ClientResource cr = null;
		WunderList[] lists = null;

		try {
			cr = new ClientResource(uriLists);
			addHeader(cr, "X-Access-Token", access_token);
			addHeader(cr, "X-Client-ID", "4017379b2bb52043c811");

			lists = cr.get(WunderList[].class);
		} catch (ResourceException re) {
			log.info("Error when retrieving all files: " + cr.getResponse().getStatus());
		}
		return Arrays.asList(lists);
	}

	public List<Task> getTasks(Long list_id) {
		ClientResource cr = null;
		Task[] tasks = null;

		try {
			cr = new ClientResource(uriTasks + "?list_id=" + list_id);
			addHeader(cr, "X-Access-Token", access_token);
			addHeader(cr, "X-Client-ID", "4017379b2bb52043c811");

			tasks = cr.get(Task[].class);
		} catch (ResourceException re) {
			log.info("Error when retrieving all files: " + cr.getResponse().getStatus());
		}
		return Arrays.asList(tasks);
	}
	
	public Task getTask(Long task_id){
		ClientResource cr = null;
		Task task = null;

		try {
			cr = new ClientResource(uriTasks + "/"+task_id);
			addHeader(cr, "X-Access-Token", access_token);
			addHeader(cr, "X-Client-ID", "4017379b2bb52043c811");

			task = cr.get(Task.class);
		} catch (ResourceException re) {
			log.info("Error when retrieving all files: " + cr.getResponse().getStatus());
		}
		return task;
	}
	public Task createTask(Task new_task) {
		ClientResource cr = null;
		Task task = null;

		try {
			cr = new ClientResource(uriTasks);
			addHeader(cr, "X-Access-Token", access_token);
			addHeader(cr, "X-Client-ID", "4017379b2bb52043c811");

			task = cr.post(new_task, Task.class);
		} catch (ResourceException re) {
			log.info("Error when creating task: " + cr.getResponse().getStatus());
		}

		return task;
	}
	
	public boolean deleteTask(Long task_id, Integer revision) {
		ClientResource cr = null;
		boolean success = true;

		try {
			cr = new ClientResource(uriTasks+"/"+task_id+"?revision="+revision);
			addHeader(cr, "X-Access-Token", access_token);
			addHeader(cr, "X-Client-ID", "4017379b2bb52043c811");
			
			cr.delete();
		} catch (ResourceException re) {
			log.info("Error deleting task: " + cr.getResponse().getStatus());
			success = false;
		}

		return success;
	}
	

	@SuppressWarnings("unchecked")
	public void addHeader(ClientResource cr, String headerName, String headerValue) {
		Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
				.get(HeaderConstants.ATTRIBUTE_HEADERS);

		if (headers == null) {
			headers = new Series<Header>(Header.class);
			cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
		}
		headers.add(headerName, headerValue);
	}
}