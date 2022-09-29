<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="utf8">
<title>Alterar Cliente</title>
</head>
<body>
<script src="scripts/validador.js"></script>
	<h1>Alterar cliente</h1>
	<form name="frmCliente" action="update">
		<table>
		    <tr>
        		<td><input type="text" name="CPF" value = "<%out.print(request.getAttribute("CPF"));%>"></td>
        	</tr>
        	<tr>
        		<td><input type="text" name="nomeCliente" value = "<%out.print(request.getAttribute("nomeCliente"));%>"></td>
        	</tr>
        	<tr>
        		<td><input type="text" name="telefone" value = "<%out.print(request.getAttribute("telefone"));%>"></td>
        	</tr>
        	<tr>
        		<td><input type="text" name="email" value = "<%out.print(request.getAttribute("email"));%>"></td>
        	</tr>
        	<tr>
        		<td><input type="text" name="senha" value = "<%out.print(request.getAttribute("senha"));%>"></td>
        	</tr>
		</table>
		<input type="button" value="salvar" onclick="validar()">
	</form>

</body>
</html>