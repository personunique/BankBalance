<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--<script>
function validate()
{
var amount = document.getElementById("the").value;
if(amount<0 || amount>10000){
	alert('Amount is invalid');
	return false;
}
else if(theory>="A" || theory<="Z" && theory>="a" && theory<="z")
	{
	alert('Amount cannot be an alphabet');
	
	return false;
	}
	else if(theory>=0 || theory<=10000)
		return true;
	else
		alert('Invalid characters');



}
</script>--%>
<style>
body{
background-color:rgb(153,204,255);
}
h1{
text-align:"center"
color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="check.obj" onsubmit="return validate()">

<table border="10" align="center" cellspacing="10" cellpadding="5">
<h1 text-align:"center"><b><mark>Balance Details</mark></b></h1>
<tr>
		<td>Account id:&nbsp;&nbsp;</td>
		<td>
				<select name="ddlId" style="width:150px">
					<c:forEach items="${sessionScope.list}" var="list">
        				<option><c:out value="${list}" /></option>
    				</c:forEach>
				</select>
		</td>
		</tr>
<tr>
<br>
		<td>Account Type:&nbsp;&nbsp;</td>
		<td>
			<select name="ddlname" style="width:150px">
				<option value="Select">
				--Select--</option>
				<option value="Savings">
				Savings</option>
				<option value="Current">
				Current</option>
				</select>
		</td>
	</tr>
	
	<br>
	
	
	<tr>
			<td>Amount to be withdrawn:&nbsp;&nbsp;</td>
			<td><input type="number" id="the" name="amount"/>
	</tr>
	<br>
<tr>
	<td>
		<input type="submit" class="button" value="Submit"/>
	</td>
</table>

</form>

</body>
</html>