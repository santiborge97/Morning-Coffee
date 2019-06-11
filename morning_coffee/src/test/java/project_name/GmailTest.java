package project_name;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;



import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.gmail.Header;
import aiss.model.gmail.Message;
import aiss.model.gmail.MessageList;
import aiss.model.resource.GmailResource;

public class GmailTest {
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
//			  access_token = "ya29.GltRBP0WZ5iQts0ZxPQWTl9LxHsr5i2y40gHoDEwceGrsUldtVb-KXME0JBznzjCY334TmxG1hm14KXRUpW69gMOaUCk7t0OGZmvxaVauOY0d4sZB15GBMVUslIJ";
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
//	public void TestGetListMessages() {
//		GmailResource gr = new GmailResource(access_token);
//		MessageList messageList = null;
//		
//		try{
//			messageList = gr.getListMessages(null);
//		}catch(Exception e){
//			e.getMessage();
//		}
//		
//		System.out.println("=================== Mensajes (sólo los id) ==================");
//		
//		for (Message message : messageList.getMessages()) {
//			
//			System.out.println("Id: " + message.getId());
//			
//		}
//		System.out.println("\n\n");
//		
//		assertNotNull("The list of messages is null",messageList);
//	}
//	
//	@Test
//	public void TestGetMessageOfList() {
//		GmailResource gr = new GmailResource(access_token);
//		Message message = null;
//		MessageList messageList = gr.getListMessages(null);
//		
//		try{
//			message = gr.getMessageOfList(messageList.getMessages().get(0).getId());
//		}catch(Exception e){
//			e.getMessage();
//		}
//		
//		System.out.println("=================== Mensaje ==================");
//		
//		
//		for (Header header : message.getPayload().getHeaders()) {
//			
//			if(header.getName().equals("Subject")) System.out.println("Asunto: " + header.getValue());
//			if(header.getName().equals("From")) System.out.println("From: " + header.getValue());
//			if(header.getName().equals("To")) System.out.println("To: " + header.getValue());
//			
//			
//		}
//		System.out.println("\n\n");
//		
//		assertNotNull("Message is null",message);
//	}
//	
//	@Test
//	public void testSendMessage() {
//		GmailResource gr = new GmailResource(access_token);
//		boolean success = false;
//		
//		try{
//			success = gr.sendMessage("angelmarmolfernandez@gmail.com", "proyectomorningcoffee@gmail.com", "Mensaje de prueba", "Mensaje de prueba JUnit");
//		}catch(Exception e){
//			e.getMessage();
//		}
//		
//		System.out.println("=================== Mensajes Enviado ==================");
//		
//		
//		assertTrue("Message not sent",success);
//	}
	
	
	
}
