<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList"  %>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de Clientes</title>
</head>
<body>
	<h1>Lista de Clientes</h1>
	<a href="novo.html">Novo Cliente</a>
	<table>
		<thead>
			<tr>
				<th>CPF</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>Senha</th>				
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0 ; i < lista.size() ; i++) { %>
				<tr>
					<td><%=lista.get(i).getCPF() %></td>
					<td><%=lista.get(i).getNomeCliente() %></td>
					<td><%=lista.get(i).getTelefone() %></td>
					<td><%=lista.get(i).getEmail() %></td>
					<td><%=lista.get(i).getSenha() %></td>
					<td><a href="select?CPF=<%=lista.get(i).getCPF()%>">Editar</a> 
						<a href="delete?CPF=<%=lista.get(1).getCPF()%>">Excluir</a></td></tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>