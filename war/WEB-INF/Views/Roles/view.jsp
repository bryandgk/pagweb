<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import = "model.entity.Role" %>

<%
	Role roles = (Role) request.getAttribute("roles");
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Usuarios</title>
		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>		
	</head>
	<body>
		<div class="cabeza">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="/index.html">Muebleria Kelly</a>

			<!-- Links -->
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item">
					<a class="nav-link" href="/index.html">Inicio</a>
				</li>
				<!-- Dropdown -->
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Catalogo</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Muebles</a>
						<a class="dropdown-item" href="#">Sillas</a>
						<a class="dropdown-item" href="#">Mesas</a>
						<a class="dropdown-item" href="#">Comedor</a>
					</div>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/roles">Roles</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/users">Usuarios</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/resources">Recursos</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/access">Accesos</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/facturas">Factura</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/sesion/login">Login</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/sesion/logout">Logout</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0" action="/#">
    			<input class="form-control mr-sm-2" type="text" placeholder="Search">
    			<button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
  			</form>
		</nav>
	</div>
	<div class="container">
		<div class="row">
			<div class=" col-md-3 p-4"> 
				<div class="">
					<h1 class="text-center text-success font-weight-bold">Actions</h1>
					<ul >
						<li class="btn form-control bg-success mx-auto"><a class="btn btn-success" href="/roles/add">Add Access</a></li>
						<li class="btn form-control bg-success"><a class="btn btn-success" href="/roles/update?userId=<%= roles.getId() %>">Update</a></li>
						<li class="btn form-control bg-success"><a class="btn btn-success" href="/roles/delete?userId=<%= roles.getId() %>">Delete</a></li>
						<li class="btn form-control bg-success"><a class="btn btn-success" href="/roles">List of Access</a></li>
					</ul>
				</div>
			</div>
			<div class="table col-md-9 large-9 medium-8 colums p-4"> 
				<h2 class="text-success border-bottom border-success">User with Id:  <%= roles.getId() %></h2>
					<table class="vertical-table">
						<tbody>
							<tr>
								<th scope="row">Role</th>
								<td><%=roles.getRoles() %></td>
							</tr>
							<tr>
								<th scope="row">Role</th>
								<td><%= roles.isStatus()%></td>
							</tr>
						</tbody>
					</table>
			</div>
		</div>
	</div>
	</body>
</html>