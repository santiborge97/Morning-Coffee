<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Morning Coffee 2.0 || Enviar email</title>
</head>
<body>
<a href="index.jsp"><div style="text-align:center;" ><img src="./images/logo.png" width = 60% height= 200px></div></a>

<ul id="nav_menu">
		<li id="gmail_tab"><a  class="active" href="/GmailMessageListing">Gmail</a></li> 
		<li id="events_tab"><a href="/EventsView">Eventos</a></li>
	</ul>

	<div id="div_response_email">			
		<form action="GmailMessageResponse" id="ResponseForm" method="post">
		<input class="oculto" type="text" name="from" value="${param['to']}" hidden>
			<input class="oculto" type="text" name="to" value="${param['from']}" hidden>
			<p><input type="text" name="subject" placeholder="Asunto"></p>
			<p><textarea rows="20" cols="50" form ="ResponseForm" name="body" placeholder="Cuerpo"></textarea></p>
			
			<button class="confirm_button" type="submit" class="button">Enviar</button>
		</form>
	</div>
</body>
</html>