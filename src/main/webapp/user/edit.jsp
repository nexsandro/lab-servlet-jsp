<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body onload="evaluateEnableDeletion()">

	<form id="userForm" method="post" action="<%=request.getContextPath()%>/user">

		<input type="hidden" name="command" value="save" />
		<input type="hidden" name="id" id="id" value="${user.id}" />
		
		<table>
			<tr>
				<td>Id:</td>
				<td>${user.id}</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${user.name}" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${user.email}" /></td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="text" name="birthDate"
					value="${user.birthDate}" /></td>
			</tr>
			<tr>
				<td colspan="2"><button>Save</button>&nbsp;<button id="deleteButton" onclick="deleteUser()">Delete</button></td>
			</tr>
		</table>
	</form>

</body>

<script type="text/javascript">


	function onIdChange() {
		evaluateEnableDeletion();
	}
	
	function deleteUser() {
		if (confirm('Confirma exclusão do item?')) {
			var form = document.getElementById('userForm');
			form.action = '<%=request.getContextPath()%>/user?command=delete&id=' + document.getElementById('id').value;
			form.submit();
		}
	}
	
	function evaluateEnableDeletion() {
		var button = document.getElementById('deleteButton');
		button.disabled = document.getElementById('id').value.trim() == '';
	}
	
</script>
</html>