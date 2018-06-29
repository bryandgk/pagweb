<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%
	UserService us = UserServiceFactory.getUserService();
	User user = us.getCurrentUser();
%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="cabeza">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="index.html">Muebleria Kelly</a>

			<!-- Links -->
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="index.html">Inicio</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Nosotros</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Tienda</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Contactenos</a>
				</li>
				<!-- Dropdown
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown">Catalogo</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Muebles</a> <a
							class="dropdown-item" href="#">Sillas</a> <a
							class="dropdown-item" href="#">Mesas</a> <a class="dropdown-item"
							href="#">Comedor</a>
					</div>
				</li>-->
				<li class="nav-item"><a class="nav-link" href="#">Roles</a>
				<li class="nav-item"><a class="nav-link" href="#">Usuarios</a>
				<li class="nav-item"><a class="nav-link" href="#">Recursos</a>
				<li class="nav-item"><a class="nav-link" href="#">Acceso</a>
				<li class="nav-item"><a class="nav-link" href="#">Productos</a>
			</ul>
			<div class="form-inline my-2 my-lg-0">
				<a class="btn btn-dark mr-sm-2" href="/sesion/login">Iniciar Sesión</a>
				<a class="btn btn-dark mr-sm-2" href="/sesion/logout">Cerrar Sesión</a>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<p>Acceso denegado</p>
			</div>
		</div>
	</div>
	
</body>
</html>