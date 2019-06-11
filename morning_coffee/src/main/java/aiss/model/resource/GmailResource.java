package aiss.model.resource;

import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


import aiss.model.gmail.Message;
import aiss.model.gmail.MessageList;
import aiss.model.gmail.MessageRaw;

public class GmailResource {
	private static final Logger log = Logger.getLogger(GmailResource.class.getName());

	private String uri = "https://www.googleapis.com/gmail/v1/users/me/messages";

	private String access_token;
	private String uri_send = "https://www.googleapis.com/gmail/v1/users/me/messages/send";

	public GmailResource(String access_token) {
		this.access_token = access_token;
	}

	
	public MessageList getListMessages(String nextPageToken) {

		ClientResource cr = null;
		MessageList messages = null;
		try {
			if (nextPageToken == null) {
				cr = new ClientResource(uri + "?maxResults=20&access_token=" + access_token);
				messages = cr.get(MessageList.class);
			} else {
				cr = new ClientResource(uri + "?pageToken=" + nextPageToken + "&maxResults=20&access_token=" + access_token);
				messages = cr.get(MessageList.class);

			}
		} catch (ResourceException re) {
			log.warning("Error when retrieving all Messages: " + cr.getResponse().getStatus());
		}

		return messages;

	}

	public Message getMessageOfList(String id) {

		ClientResource cr = null;
		Message message = null;
		try {
			cr = new ClientResource(uri + "/" + id + "?access_token=" + access_token);
			message = cr.get(Message.class);

		} catch (ResourceException re) {
			log.warning("Error when retrieving message: " + cr.getResponse().getStatus());
		}

		return message;

	}

	public boolean sendMessage(String to, String from, String subject, String body) {
		ClientResource cr = new ClientResource(uri_send + "?access_token=" + access_token);
		boolean success = true;
		try {
			String decoded = "From: " + from + "\r\n" + "To: " + to + "\r\n" + "Subject: " + subject + "\r\n\r\n"
					+ body;
			String encoded = DatatypeConverter.printBase64Binary(decoded.getBytes());
			encoded = encoded.replace('/', '_');
			encoded = encoded.replace('+', '-');
			encoded = encoded.replace("=", "");

			MessageRaw message = new MessageRaw();
			message.setRaw(encoded);

			cr.post(message);

		} catch (ResourceException re) {
			log.info("Error when sending message: " + cr.getResponse().getStatus());
			success = false;
		}

		return success;

	}

}
