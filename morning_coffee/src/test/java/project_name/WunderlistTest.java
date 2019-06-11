package project_name;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.resource.WunderlistResource;
import aiss.model.wunderlist.Task;
import aiss.model.wunderlist.WunderList;

public class WunderlistTest {
//	private static String access_token;
//	
//	@BeforeClass
//	public static void setUp() throws Exception {
//		try{
//			
//			 /*
//			  Scanner sc=new Scanner(System.in);
//			   
//			  System.out.print("Introduzca token de Wunderlist: ");
//			   */
//			  access_token = "fe5b651a0025d94970f48d736a394aa5391d8c501db03ab25465e98aa9cb";
//			  
//			  
//			  
//			  //sc.close();
//		}catch(Exception e){
//			throw new Exception("Token no guardado.");
//		}
//	}
//
//	@Test
//	public void testGetLists() {
//		WunderlistResource wr = new WunderlistResource(access_token);
//		List<WunderList> lists = null;
//		
//		try{
//			lists = wr.getLists();
//		}catch(Exception e){
//			e.getMessage();
//		}
//		
//		System.out.println("=================== Listas ==================");
//		
//		for (WunderList list : lists) {
//			
//			System.out.println("Título: " + list.getTitle());
//			System.out.println("Id: " + list.getId());
//			System.out.println("\n\n");
//		}
//		
//		assertNotNull("The list of lists is null",lists);
//	}
//	
//	@Test
//	public void testGetTask() {
//		WunderlistResource wr = new WunderlistResource(access_token);
//		List<WunderList> lists = null;
//		List<Task> tasks = null;
//		
//		try{
//			lists = wr.getLists();
//			tasks = wr.getTasks(lists.get(0).getId().longValue());
//		}catch(Exception e){
//			e.getMessage();
//		}
//		
//		System.out.println("=================== Tareas =================");
//		for (Task task : tasks) {
//			
//			System.out.println("Título: " + task.getTitle());
//			System.out.println("Id: " + task.getId());
//			System.out.println("\n\n");
//		}
//		
//		assertNotNull("The list of tasks is null",tasks);
//	}
//	
//	@Test
//	public void testCreateTask() {
//		WunderlistResource wr = new WunderlistResource(access_token);
//		List<WunderList> lists = wr.getLists();
//		Task task = new Task();
//		task.setTitle("Tarea de prueba");
//		task.setListId(lists.get(0).getId().longValue());
//		Task new_task = null;
//		
//		try{
//			new_task = wr.createTask(task);
//		}catch(Exception e){
//			e.getMessage();
//		}
//	
//		System.out.println("=================== Tarea creada =================");
//		System.out.println("Título: " + new_task.getTitle());
//		System.out.println("Id: " + new_task.getId());
//		System.out.println("\n\n");
//		
//		
//		assertNotNull("The created task is null", new_task);
//	}
//	
//	@Test
//	public void testDeleteTask() {
//		WunderlistResource wr = new WunderlistResource(access_token);
//		List<WunderList> lists = wr.getLists();
//		
//		Task new_task = new Task();
//		new_task.setTitle("Tarea de prueba");
//		new_task.setListId(lists.get(0).getId().longValue());
//		wr.createTask(new_task);
//		
//		List<Task> tasks = wr.getTasks(lists.get(0).getId().longValue());
//		
//		Task task_toDelete = null;
//		boolean success = false;
//		
//		for (Task task : tasks) {
//			if(task.getTitle().equals(new_task.getTitle())) task_toDelete = task;
//		}
//		
//		
//		try{
//			success = wr.deleteTask(task_toDelete.getId(), task_toDelete.getRevision());
//		}catch(Exception e){
//			e.getMessage();
//		}
//	
//		System.out.println("=================== Tarea eliminada =================");
//		System.out.println("\n\n");
//		
//		
//		assertTrue("The task was not deleted", success);
//	}
//	
	
}
