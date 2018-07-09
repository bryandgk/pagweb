<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page 
	import= "java.util.List" 
	import= "model.entity.User"
%>
<%
	List<User> users = (List<User>) request.getAttribute("users");
%>

<!DOCTYPE html>
<html lang="en">
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
			<div class="col-md-3 p-4">
				<div class="mx-auto">
					<a class="btn btn-success" href="/users/add">Add User</a>
				</div>
			</div>
			<div class="col-md-9 p-4">
				<h1>Users</h1>
				<%
					if(!users.isEmpty() && users.size() > 0){
				%>
				<table class="table">
					<thead>
						<tr>
							<th>id</th>
							<th>email</th>
							<th>role</th>
							<th>gender</th>
							<th>status</th>
							<th>Actions</th>
						</tr>
					</thead>
					<% 	
						for (int i= 0; i<users.size() ; i++){
							User o = (User) users.get(i);
					%>
					<tbody>
						<tr>
							<td><%= o.getId()%></td>
							<td><%= o.getEmail()%></td>
							<td><%= o.getIdRole()%></td>
							<td><%= o.isGender()%></td>
							<td><%= o.isStatus()%></td>
							<td>
								<span><a href="/users/view?userId=<%=o.getId()%>">View</a></span>
								<span><a href="/users/delete?userId=<%=o.getId()%>">Delete</a></span>
								<span><a href="/users/update?userId=<%=o.getId()%>">Update</a></span>
							</td>
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
				<% 
					}else{
				%>
				<h4>Sin Usuarios</h4>
				<%} %>
			</div>
		</div>	
	</div>
	
	</body>
</html>
