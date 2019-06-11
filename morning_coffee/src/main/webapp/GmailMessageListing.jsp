<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="aiss.model.gmail.Message" %>
<%@ page import="aiss.model.gmail.Header" %>
<%@ page import="javax.xml.bind.DatatypeConverter" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Morning Coffee 2.0 | Gmail</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>
</head>
<body>
	<script> 
		function cuerpo(div_id){
			var div_inicio = "div_mensaje_";
	  		var res = div_inicio.concat(div_id);
	  		var x = document.getElementById(res);
	  	    if (x.style.display === 'none') {
	  	        x.style.display = 'block';
	  	      	x.style.wordBreak = 'break-all';
	  	   	    x.style.width = '100%';
	  	        
	  	    } else {
	  	        x.style.display = 'none';
	  	    }
		}
	  </script>
	  
<c:set var="nextPageToken" value="${requestScope.messageList.nextPageToken}"></c:set>


<a href="index.jsp"><div style="text-align:center;" ><img src="./images/logo.png" width = 40% height= 200px></div></a>

<ul id="nav_menu">
		<li id="gmail_tab"><a  class="active" href="/GmailMessageListing">Gmail</a></li> 
		<li id="events_tab"><a href="/EventsView">Eventos</a></li>
	</ul>

<h1>Buzón de entrada
<a href="/GmailMessageListing?nuevoToken=${nextPageToken }"><button title="Siguiente página" id="next_page_button">></button></a>
</h1>

<table>
	<tr>
		<th>Asunto</th>
		<th>Enviado por</th>
		<th></th>
		<th>Acciones</th>
	</tr>
	<!-- -------------------------- -->
	<!--Recorremos los mensajes -->
	<!-- -------------------------- -->
	<c:forEach items="${requestScope.listaMesDef}" var="message">

	

	
	<!-- -------------------------------------------------------------- -->
	<!-- Recorremos los headers para sacar las cabeceras necesarias -->
	<!-- -------------------------------------------------------------- -->
		<c:forEach items="${message.payload.headers}" var="cabecera">
		
		
			<c:if test = "${cabecera.name == 'Subject'}">
				<!-- Si la cabecera tiene el nombre Subject (asunto), lo pasamos por pantalla -->
	        	<c:set var="subject_jsp" value="${cabecera.value}"></c:set>
	      	</c:if>
	      	
	     
	        <c:if test = "${cabecera.name == 'From'}">
	         	<!-- Si la cabecera tiene el nombre From (desde), lo pasamos por pantalla -->
	       		<c:set var="from1" value="${cabecera.value}"></c:set>
	       		<c:set var = "from_jsp" value = "${fn:replace(from1, '\"', '')}" />
	  
	    	</c:if>
	    	
	    	
	    	<c:if test = "${cabecera.name == 'To'}">
	    	<!-- Si la cabecera tiene el nombre To (para), creamos una variable con su valor que nos servirá en los controladores -->
	       		<c:set var="to" value="${cabecera.value}"></c:set>
	    	</c:if>
    	
		</c:forEach>
		
		<tr>
			<td><c:out value="${subject_jsp}"></c:out></td>
			<td><c:out value="${from_jsp}"></c:out></td>
			<td><button  onclick="cuerpo('${message.id}')">Mostrar cuerpo </button></td>
			<td> <a href="SendEmail.jsp?from=${from_jsp}&to=${to}"><img title="Responder correo" src="./images/responderEmail.png" width = 30px height= 30px class="responder" alt="Responder Email"></a>
			<a href="/GmailAddTask?title=${subject_jsp}"><img title="Tarea personalizada" src="./images/addTarea.png" width = 30px height= 30px class="añadirTarea" alt="Añadir Tarea"></a>
			<a href="gmail_add_reminder.jsp?title=${subject_jsp}""><img title="Recordatorio" src="./images/addRecordatorio.png" width = 30px height= 30px class="añadirRecordatorio" alt="Añadir Recordatorio"></a></td>
		</tr>
		
		<!-- Div del cuerpo del mensaje, que queremos expandir si el usuario hace click en el correo -->
		<tr><td  colspan="4">
		<div id= "div_mensaje_${message.id}" style="display:none;" >
		
			<c:forEach items="${message.payload.parts}" var="parte">
				<c:if test="${parte.mimeType == 'text/plain' }">
					<p><c:out value="${parte.body.data}"></c:out></p>	
		 	 	</c:if>
		    </c:forEach>
		    <p><c:out value="${message.payload.body.data}"></c:out></p>	
		   
		</div>
		</td></tr>

	
	
	</c:forEach>
	
	
</table>



</body>
</html>