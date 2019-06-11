<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Morning Coffee 2.0 | Actualizar tarea</title>
</head>
<body>
<a href="index.jsp"><div style="text-align:center;" ><img src="./images/logo.png" width = 60% height= 200px></div></a>
	
	<ul id="nav_menu">
		<li id="gmail_tab"><a href="/GmailMessageListing">Gmail</a></li> 
		<li id="events_tab"><a class="active" href="/EventsView">Eventos</a></li>
	</ul>
	
	<h1>Editar tarea</h1>

<div id="div_task_update" style="text-align:center;">
	<form action="/UpdateTask" method="post">
	<input class="oculto" name="task_id" type="text" value="${param['task_id']}" hidden>
	<input class="oculto" name="revision" type="text" value="${param['revision']}" hidden>
	Nueva tarea: <input name="task_title" type="text" value="${param['task_title']}" required>
	<br><input class="confirm_button" type="submit" value="Actualizar tarea">
	</form>
</div>
	
</body>
</html>