<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.entity.Resources" %>
<%@ page import="model.entity.Access" %>
<%@ page import="model.entity.Role" %>

<%@ page import="java.util.List" %>

<%
 	ArrayList<String> resource = (ArrayList<String>) request.getAttribute("resource");
	Access res = (Access) request.getAttribute("res");
	List<Role> roles = (List<Role>) request.getAttribute("roles"); 
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Access Update</title>
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
			<div class="opcion col-md-3 mx-auto p-4">
				<a class="btn btn-success" href="/access">Lists of Access</a>
			</div>
			<div class="derecha col-md-9">
				<h1 class="text-success border-bottom border-success">Update Access</h1><br>
				
				<form class="form-control" action="/access/update?userId=<%=res.getId() %>" method="post">
		
					<h2>Id <%= res.getId() %></h2>
					<p class="border-bottom border-danger">Rol usado: <span class="text-danger"> "<%= res.getIdRol() %>"</span></p>
					<div class="form-group">
						<h4>Busque y Modifique aqui Rol</h4>
					<select class="form-control w-50" name="rol">
								<%
									if(roles.size()>0){
										for(int i = 0; i<roles.size();i++){
											Role o = (Role) roles.get(i);
								%>
											<option value="<%= o.getId() %>"><%= o.getRoles() %></option>
								<% 			
										}
									}
								%>
					</select>	
					</div>
					<p class="border-bottom border-danger">Recurso usado:  <span class="text-danger">"<%= res.getResource() %>"</span></p>
					<div class="form-group">
						<h4>Busque y Modifique aqui Resource</h4>
					<select class="form-control w-50" name="resource">
								<%
									if(resource.size()>0){
										for(String i: resource){
								%>
											<option><%= i %></option>
								<% 			
										}
									}
								%>
					</select>	
					</div>
					
					<input  class="btn btn-success" type="submit" value="Actualizar"/>
				</form>
			</div>
		</div>
	</div>
	</body>
</html>
