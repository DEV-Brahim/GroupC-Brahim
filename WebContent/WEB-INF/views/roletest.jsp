<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.Row
{
    display: table;
    width: 100%; /*Optional*/
    table-layout: fixed; /*Optional*/
    border-spacing: 10px; /*Optional*/
}
.Column
{
    display: table-cell;
    background-color: #acbfe9; /*Optional*/
}
</style>

</head>
<body>
	<h1>${message }</h1>
	<div class="Row">
		<div class="Column">
			<h2>Add Role :</h2>
			<form action="addrole" method="get">
				<table>
					<tr>
						<td>Role Name :</td>
						<td><input type="text" name="role" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="add" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="Column">
			<h2>Delete Role :</h2>
			<form action="deleterole" method="get">
				<table>
					<tr>
						<td>Role Id :</td>
						<td><input type="text" name="id" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="delete" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="Column">
			<h2>Find Role :</h2>
			<form action="getrole" method="get">
				<table>
					<tr>
						<td>Role Id :</td>
						<td><input type="text" name="id" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Find" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div>
		<h3>${getrole.getId() }</h3>
		<h3>${getrole.getName() }</h3>
		<h2>Show Roles :</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>Name
			</tr>
			<c:forEach var="it" items="${list }">
				<tr>
					<td><c:out value="${it.getId()}" /></td>
					<td><c:out value="${it.getName()}" /></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>