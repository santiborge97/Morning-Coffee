<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Morning Coffee 2.0 | Añadir Recordatorio</title>
</head>
<body>
<a href="index.jsp"><div style="text-align:center;" ><img src="./images/logo.png" width = 60% height= 200px></div></a>

<ul id="nav_menu">
		<li id="gmail_tab"><a  class="active" href="/GmailMessageListing">Gmail</a></li> 
		<li id="events_tab"><a href="/EventsView">Eventos</a></li>
	</ul>

	<h1>Añadir recordatorio</h1>
	
<div id="div_add_reminder" style="text-align:center;">
	<form action="/GmailAddReminder" method="post">
	<input name="title" type="text" value="Recordatorio de correo -- ${param['title']}"><br>
	Fecha de inicio: <input name="startDate" type="date" ><br>
	Fecha de fin: <input name="endDate" type="date" ><br>
	<br><input class="confirm_button" type="submit" value="Añadir recordatorio">
	</form>
</div>
	

</body>
</html>