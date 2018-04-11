<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.curso.entidades.BO, java.text.SimpleDateFormat, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Gestão de BO</title>
		<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/>
		<script src="./resources/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>Departamento de Polícia Civil</h1>
		<hr></hr>
		<h2>Gestão de Boletim de Ocorrência</h2>
		
		<%
			String msg = (String)session.getAttribute("MESSAGE");
			session.setAttribute("MESSAGE", null);
			
			BO bAtual = (BO)session.getAttribute("BOATUAL");
			session.setAttribute("BOATUAL", null);
			
			List<BO> lista = (List<BO>)session.getAttribute("LISTA");
			session.setAttribute("LISTA", null);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			if (bAtual == null) { 
				bAtual = new BO();
			}
			if (msg != null) {
		%>
			<div class="alert alert-danger" role="alert">
	  			<%=msg%>
			</div>
		<% 	} %>
		<div class="container">
  		<!-- Content here -->
  			<form action="./BOController" method="post">
				<div class="row">
	    			<div class="col-sm">
						<label>ID</label>
					</div>
					<div class="col-sm">
						<input type="text" name="txtId" value="<%=bAtual.getId()%>"/>
					</div>
				</div>
				<div class="row">
	    			<div class="col-sm">
						<label>Numero</label>
					</div>
					<div class="col-sm">
						<input type="text" name="txtNumero" value="<%=bAtual.getNumero()%>"/>
					</div>
				</div>
				<div class="row">
	    			<div class="col-sm">
						<label>RG</label>
					</div>
					<div class="col-sm">					
						<input type="text" name="txtRg" value="<%=bAtual.getRg()%>"/>
					</div>
				</div>
				<div class="row">
	    			<div class="col-sm">
						<label>Nome Vitima</label>
					</div>
					<div class="col-sm">					
						<input type="text" name="txtNome" value="<%=bAtual.getNome()%>"/>
					</div>
				</div>					
				<div class="row">
	    			<div class="col-sm">
						<label>Data Ocorrência</label>
					</div>
					<div class="col-sm">					
						<input type="text" name="txtData" value="<%=sdf.format(bAtual.getDataOcorrencia())%>"/>
					</div>
				</div>					
				<div class="row">
	    			<div class="col-sm">
						<label>Tipo da Ocorrência</label>
					</div>
					<div class="col-sm">					
						<select name="txtTipo">
							<option selected="<%="Furto".equals(bAtual.getTipo())?"selected":""%>">Furto</option>
							<option>Roubo</option>
							<option>Assalto a mão armada</option>
							<option>Perda</option>
							<option>Dano ao patrimônio</option>
							<option>Briga</option>
						</select>
					</div>
				</div>					
				<div class="row">
	    			<div class="col-sm">
						<label>Local</label>
					</div>
					<div class="col-sm">					
						<input type="text" name="txtLocal" value="<%=bAtual.getLocal()%>"/>
					</div>
				</div>					
				<div class="row">
	    			<div class="col-sm">
						<label>Descrição</label>
					</div>
					<div class="col-sm">
						<textarea rows="10" cols="50" name="txtDescricao"><%=bAtual.getDescricao()%></textarea>
					</div>
				</div>
				<div class="row">
	    			<div class="col-sm">
						<button class="btn btn-danger" type="submit" name="cmd" value="adicionar">Adicionar</button>
						<button class="btn btn-danger" type="submit" name="cmd" value="pesquisar">Pesquisar</button>
					</div>
				</div>				
			</form>					
		</div>
		<% if (lista != null && lista.size() > 0) { %>
		<div class="container">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Numero</th>
						<th>RG</th>
						<th>Nome</th>
						<th>Data</th>
						<th>Tipo</th>
						<th>Local</th>
						<th>Descrição</th>
					</tr>
				</thead>
				<tbody>
				<%for (BO b : lista) { %>
					<tr>
						<td><%=b.getId()%></td>
						<td><%=b.getNumero()%></td>
						<td><%=b.getRg()%></td>
						<td><%=b.getNome()%></td>
						<td><%=b.getDataOcorrencia()%></td>
						<td><%=b.getTipo()%></td>
						<td><%=b.getLocal()%></td>
						<td><%=b.getDescricao()%></td>
					</tr>
				<% } %>
				</tbody>
			</table>
		</div>
		<% } %>
	</body>
</html>