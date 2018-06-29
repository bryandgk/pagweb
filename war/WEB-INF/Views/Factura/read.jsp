<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.entity.Facturar"  %>

<% 
	Facturar factura = (Facturar) request.getAttribute("facturas");
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Read (DEMO CRUD)</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="/CSS/estilo.css">
		<link rel="stylesheet" href="/CSS/estiloRead.css">
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
							<li class="btn form-control bg-success mx-auto"><a class="btn btn-success" href="/facturas/add">Add Access</a></li>
							<li class="btn form-control bg-success"><a class="btn btn-success" href="/facturas/update?userId=<%= factura.getId() %>">Update</a></li>
							<li class="btn form-control bg-success"><a class="btn btn-success" href="/facturas/delete?userId=<%= factura.getId() %>">Delete</a></li>
							<li class="btn form-control bg-success"><a class="btn btn-success" href="/facturas">List of Access</a></li>
					</ul>
					</div>
				</div>
				<div class="table col-md-6 large-9 medium-8 colums p-4 ">
					<h2>Sale with Id:  <%= factura.getId() %></h2>
					<table class="vertical-table">
						<tbody>
							
							<tr>
								<th scope="row">Product Code</th>
								<td><%= factura.getCodigoPro() %></td>
							</tr>
							<tr>
								<th scope="row">Quality</th>
								<td><%= factura.getCantidad() %></td>
								
							</tr>
							<tr>
								<th scope="row">Product Description</th>
								<td><%= factura.getDescripcion() %></td>
							</tr>
							<tr>
								<th scope="row">Price/Unity</th>
								<td><%= factura.getPrecioUnidad() %></td>
							</tr>
							<tr>
								<th scope="row">Total</th>
								<td><%= factura.getTotal() %></td>
							</tr>
							
						</tbody>
					</table>
					<a href="/facturas" class="btn btn-success"  role="button"  >Return to Invoice List</a>
				</div>
			</div>
		</div>
	</body>
</html>