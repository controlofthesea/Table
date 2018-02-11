<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<html>
<head>
    <title>Table</title>
</head>
<body>
	<c:if test="${men.size() < 1}">
	<c:out value="List is empty"/>
	</c:if>
	<c:if test="${men.size() > 0}">
    <table border="3">
		<thead>
			<th>ID</th><th>Name</th><th>Surname</th>
		</thead>
		<c:forEach var="man" items="${men}" varStatus="stat">
		<tr>
			<td>${stat.count}</td><td>${man.getName()}</td><td>${man.getSurname()}</td>
			<td><a href="/delete/${man.getName()}+${man.getSurname()}"><img  src="cross.png" height="30" width="30" alt="Delete"></a></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>