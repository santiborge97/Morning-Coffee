package aiss.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils;

import aiss.model.gmail.Message;
import aiss.model.gmail.MessageList;
import aiss.model.resource.GmailResource;

public class GmailMessageListController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GmailMessageListController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken=(String)req.getSession().getAttribute("Gmail-token");
		if(accessToken!=null && !"".equals(accessToken)){
			GmailResource gmResource=new GmailResource(accessToken);
			MessageList messageList = gmResource.getListMessages(req.getParameter("nuevoToken"));
			List<Message> listMessage=messageList.getMessages();
			List<Message> listaMesDef=new ArrayList<>();
			for(Message m: listMessage){
				String id = m.getId();
				Message message = gmResource.getMessageOfList(id);
				if(message!=null
						&& message.getLabelIds()!=null
						&& !message.getLabelIds().contains("SPAM")
						&& !message.getLabelIds().contains("TRASH")
						&& !message.getLabelIds().contains("SENT")
						&& !message.getLabelIds().contains("DRAFT")
						&& !message.getLabelIds().contains("CATEGORY_SOCIAL")
						&& !message.getLabelIds().contains("CATEGORY_PROMOTIONS")){
					
					if(message.getPayload().getParts()!=null && message.getPayload().getParts().get(0).getBody().getData()!=null){
						String decoded = new String(StringUtils.newStringUtf8(DatatypeConverter.parseBase64Binary(message.getPayload().getParts().get(0).getBody().getData())));
						message.getPayload().getParts().get(0).getBody().setData(decoded);
					}else if(message.getPayload().getParts()==null){
						String decoded = new String(StringUtils.newStringUtf8(DatatypeConverter.parseBase64Binary(message.getPayload().getBody().getData())));
						message.getPayload().getBody().setData(decoded);
					}
						listaMesDef.add(message);
				}
				
			}
		
			if(messageList!=null){
				req.setAttribute("messageList", messageList);
				req.setAttribute("listaMesDef", listaMesDef);
				req.getRequestDispatcher("/GmailMessageListing.jsp").forward(req,resp);
				
			}else{
				log.info("The messages returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("index.jsp").forward(req,resp);
			}
		}else{
			log.info("Trying to acces to gmail without an access token, redirecting to OAuth servlet");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}

