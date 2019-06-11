<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Morning Coffee 2.0</title>
    
    
  </head>

  <body>
  <h1 id="welcome">Bienvenido a...</h1>
  <a href="index.jsp"><div style="text-align:center;" ><img src="./images/logo.png" width = 60% height= 300px></div></a>
  
    
		<p id="subtitle">Empieza el día repasando tus correos, tareas y eventos acompañado de ese café mañanero.</p>

       <p id="register"><a href="step_one.jsp"><button class="indexbuttons">Ir al proceso de registro</button></a></p>
       <p id="singin"><a href="/GmailMessageListing"><button class="indexbuttons">Comenzar la mañana</button></a></p>
       <p id="singintext">¡Atención! Si no estás registrado, pulsar este botón te traerá de vuelta aquí.</p>
   <p><a href="./api_rest/a_html.html"><button>Documentación API REST</button></a>
  </body>
</html>