<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
one row added successfully
<%
int id = Integer.parseInt(session.getAttribute("id").toString());
String name = session.getAttribute("type").toString();
int total = Integer.parseInt(session.getAttribute("balance").toString());

%>
<form>
<table border="10" align="center" cellspacing="10" cellpadding="5">
<tr>
	<td>Account Id</td>
	<td><%=id %>
</tr>

<tr>
	<td>Account type</td>
	<td><%=name %> 
</tr>

<tr>
	<td>Balance amount</td>
	<td><%=total %> 
</tr>
</table>
</form>
</body>
</html>