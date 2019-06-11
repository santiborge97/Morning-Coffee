<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Morning Coffee 2.0 | Eventos</title>
</head>
<body>

	<a href="index.jsp"><div style="text-align: center;">
			<img src="./images/logo.png" width=40% height=200px>
		</div></a>

	<ul id="nav_menu">
		<li id="gmail_tab"><a href="/GmailMessageListing">Gmail</a></li> 
		<li id="events_tab"><a class="active" href="/EventsView">Eventos</a></li>
	</ul>

	<div id="div_tareas">


		<h1>Tareas:</h1>
		<form action="/NewTask" method="post">
			Nueva tarea: <input name="title" type="text" required> <input
				type="submit" value="Crear tarea">
		</form>
		<ul>
			<c:forEach items="${requestScope.tasks}" var="tasks">
				<p><li>
					<c:out value="${tasks.title}" /><br>
					<a href="/DeleteTask?task_id=${tasks.id}&revision=${tasks.revision}"><button type="button">Borrar</button></a>
					<a href="/task_update.jsp?task_id=${tasks.id}&task_title=${tasks.title}&revision=${tasks.revision}"><button type="button">Editar</button></a><br>
				</li></p>
			</c:forEach>
		</ul>


	</div>

	<div id="div_eventos">
		<h1>Eventos:</h1>
		<form action="/CalendarEventInsert" method="get">
			<p><input name="summary" type="text" placeholder="Nuevo evento" required></p>
			<p>Inicio: <input name="inicio" type="date" placeholder="inicio" required></p>
			<p>Fin: <input name="fin" type="date" required></p>
			<p><input type="submit" value="Crear evento" class="submitbutton"></p>
		</form>
		
		<table id="events">
			<tr>
				<th>Título:</th>
				<th>Inicio:</th>
				<th>Fin:</th>
				<th>Editar</th>
				<th>Borrar</th>
			</tr>


			<c:forEach items="${requestScope.events.items}" var="event">
				<tr>
					<td><c:out value="${event.summary}"></c:out></td>
					<td><c:out value="${event.start.date}"></c:out></td>
					<td><c:out value="${event.end.date}"></c:out></td>
					<td><a
						href="event_update.jsp?id=${event.id}&startDate=${event.start.date}&endDate=${event.end.date}"><img
							src="./images/edit.png" width="30px"></a></td>
					<td><a href="CalendarEventDelete?id=${event.id}"><img
							src="./images/delete.png" width="30px"></a></td>
				</tr>
			</c:forEach>

		</table>

	</div>


</body>
</html>