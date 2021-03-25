<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Iterator,java.util.Collection,com.jlabs.model.User"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>

<table>
<%
	Collection<User> users = (Collection<User>) request.getAttribute("users");
	Iterator<User> userIt = users.iterator();
	
	while(userIt.hasNext()) {
		User user = userIt.next();
%>
	<tr>
		<td><%=user.getId()%></td><td><a href="<%=request.getContextPath() %>/user?command=edit&id=<%=user.getId()%>"><%=user.getName()%></a></td>
	</tr>	
<%
	}
%>
</table>

<a href="<%=request.getContextPath() %>/user?command=edit">Adiciona</a>

</body>
</html>