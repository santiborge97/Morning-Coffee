package project_name;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;



import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.calendar.End;
import aiss.model.calendar.Events;
import aiss.model.calendar.Item;
import aiss.model.calendar.Start;
import aiss.model.resource.GoogleCalendarResource;

public class CalendarTest {
	private static String access_token;
	
//	@BeforeClass
//	public static void setUp() throws Exception {
//		try{
//			
//			 /*
//			  Scanner sc=new Scanner(System.in);
//			   
//			  System.out.print("Introduzca token de Wunderlist: ");
//			   */
//			  access_token = "ya29.GltRBFWQfLpQ2mDuFmvXJy0ZQFEj8JQPiUFkmMK4nvSzhuLAdD1NRokyaMgz48rdFTDoeZmY0TzH8TfI042itzI8g_DJX7cy2YdJMnFCqW4XAYkZ2Vk7NWwd9Kun";
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
//	public void TestGetEvents() {
//		GoogleCalendarResource gc = new GoogleCalendarResource(access_token);
//		Events events = null;
//		
//		try{
//			events = gc.getEvents("primary");
//		}catch(Exception e){
//			e.getMessage();
//		}
//		
//		System.out.println("=================== Events (solo el summary) ==================");
//		
//		for (Item item : events.getItems()) {
//			
//			System.out.println("Summary: " + item.getSummary());
//			
//		}
//		System.out.println("\n\n");
//		
//		assertNotNull("The list of events is null",events);
//	}
//	
//	@Test
//	public void TestCreateEvent() {
//		GoogleCalendarResource gc = new GoogleCalendarResource(access_token);
//		Item event = new Item();
//		event.setSummary("Evento prueba");
//		Start start = new Start();
//		start.setDateTime("2017-05-22T08:00:00+02:00");
//		event.setStart(start);
//		End end = new End();
//		end.setDateTime("2017-05-22T09:00:00+02:00");
//		event.setEnd(end);
//		Item new_event = null;
//		
//		try{
//			
//			new_event = gc.createEvent(event);
//		}catch(Exception e){
//			e.getMessage();
//		}
//		
//		System.out.println("=================== Evento Creado =================");
//		System.out.println("Summary: " + new_event.getSummary());
//		System.out.println("Start: " + new_event.getStart().getDateTime());
//		System.out.println("Start: " + new_event.getEnd().getDateTime());
//		System.out.println("\n\n");
//		
//		assertNotNull("The created event is null", new_event);
//	}
//	
//	@Test
//	public void TestUpdateEvent() {
//		GoogleCalendarResource gc = new GoogleCalendarResource(access_token);
//		
//		Item event = new Item();
//		event.setSummary("Evento prueba update");
//		Start start = new Start();
//		start.setDateTime("2017-05-22T08:00:00+02:00");
//		event.setStart(start);
//		End end = new End();
//		end.setDateTime("2017-05-22T09:00:00+02:00");
//		event.setEnd(end);
//		event=gc.createEvent(event);
//		
//		
//		Item item_toUpdate = null;
//		boolean success = false;
//		Events events = gc.getEvents("primary");
//		
//		for (Item item : events.getItems()) {
//			if(item.getSummary().equals(event.getSummary())) item_toUpdate = item;
//		}
//		
//		item_toUpdate.setSummary("Evento prueba updated!");
//		
//		try{
//			success = gc.updateEvent("primary", item_toUpdate.getId(), item_toUpdate);
//		}catch(Exception e){
//			e.getMessage();
//		}
//	
//		System.out.println("=================== Evento actualizado =================");
//		System.out.println("Summary: " + item_toUpdate.getSummary());
//		System.out.println("\n\n");
//		
//		assertTrue("The event was not updated", success);
//	}
//	
//	@Test
//	public void testDeleteEvent() {
//		GoogleCalendarResource gc = new GoogleCalendarResource(access_token);
//		Item item_toDelete = null;
//		boolean success = false;
//		
//		
//		Item event = new Item();
//		event.setSummary("Evento prueba delete");
//		Start start = new Start();
//		start.setDateTime("2017-05-22T08:00:00+02:00");
//		event.setStart(start);
//		End end = new End();
//		end.setDateTime("2017-05-22T09:00:00+02:00");
//		event.setEnd(end);
//		event=gc.createEvent(event);
//		
//		Events events = gc.getEvents("primary");
//		
//		for (Item item : events.getItems()) {
//			if(item.getSummary().equals(event.getSummary())) item_toDelete = item;
//		}
//		
//		try{
//			success = gc.deleteEvent(item_toDelete.getId());
//		}catch(Exception e){
//			e.getMessage();
//		}
//	
//		System.out.println("=================== Evento eliminado =================");
//		System.out.println(item_toDelete.getSummary());
//		System.out.println("\n\n");
//		
//		assertTrue("The event was not deleted", success);
//	}
//	
	
	
}
