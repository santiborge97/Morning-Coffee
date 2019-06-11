package aiss.model.resource;


import java.util.logging.Logger;


import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.calendar.Events;
import aiss.model.calendar.Item;

public class GoogleCalendarResource {
	private static final Logger log=Logger.getLogger(GoogleCalendarResource.class.getName());
	
	private String uri = "https://www.googleapis.com/calendar/v3";
	private String access_token;

	public GoogleCalendarResource(String access_token) {
		this.access_token = access_token;
	}

	public GoogleCalendarResource() {
	}

	/**
	 * 
	 * @return Files
	 */
	
	public Events getEvents(String calendarId){
		ClientResource cr = null;
		Events events =  null;
		try{
			cr = new ClientResource(this.uri + "/calendars/" + calendarId + "/events" + "?access_token=" + access_token);
			events = cr.get(Events.class);
		} catch (ResourceException re) {
			log.warning("Error when retrieving calendar: " + cr.getResponse().getStatus());
		}
		
		return events;
	}
	
	public boolean deleteEvent(String id) {

		ClientResource cr = null;
		boolean result = true;
		try {
			cr = new ClientResource(uri + "/calendars/primary/events/" + id + "?access_token=" + access_token);
			cr.delete();
		} catch (ResourceException re) {
			log.warning("Error when deleting event: " + cr.getResponse().getStatus());
			result = false;
		}
		return result;
	}
	
	public Item createEvent(Item event){
		ClientResource cr = null;
		Item new_event = null;
		
		try {
			cr = new ClientResource(uri + "/calendars/primary/events" + "?access_token=" + access_token);
			new_event = cr.post(event, Item.class);
		} catch (ResourceException re) {
			log.warning("Error when creating event: " + cr.getResponse().getStatus());
		}
		return new_event;
	}
	
	public boolean updateEvent(String calendarId, String eventId, Item event){
		ClientResource cr = null;
		boolean success = true;
		try{
			cr = new ClientResource(this.uri + "/calendars/" + calendarId + "/events/" + eventId + "?access_token=" + access_token);
			cr.put(event);
		} catch (ResourceException re) {
			log.warning("Error when retrieving calendar: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}

}
