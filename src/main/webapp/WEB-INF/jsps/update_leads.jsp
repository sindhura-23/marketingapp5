<%@ page language="java" contentType="text/html; ch  arset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<form action="update" method="post">
			<pre>
			<input type="hidden" name="id" value="${lead.id}"/>
			FirstName <input type="text" name="firstName" value="${lead.firstName}"/>
			LastName <input type="text" name="lastName" value="${lead.lastName}" />
			Email <input type="text" name="email" value="${lead.email}"/>
			Mobile <input type="text" name="mobile" value="${lead.mobile}"/>
			
				<input type="submit" value="update">
				</pre>
			</form>
		${msg}
</body>
</html>