<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Morning Coffee 2.0 | Éxito</title>
</head>
<body>
	<a href="index.jsp"><div style="text-align:center;" ><img src="./images/logo.png" width = 60% height= 200px></div></a>
	
	<ul id="nav_menu">
		<li id="gmail_tab"><a href="/GmailMessageListing">Gmail</a></li> 
		<li id="events_tab"><a class="active" href="/EventsView">Eventos</a></li>
	</ul>
	
	
	<h1 class="centrar">Operación exitosa</h1>
	
	<div id="div_event_success" style="text-align:center;">
	<a href="/EventsView"><button class="otherbuttons" type="button">Volver a los eventos</button></a>
	</div>
</body>
</html>