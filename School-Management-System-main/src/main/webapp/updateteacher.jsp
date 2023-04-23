<%@page import="java.io.PrintWriter"%>
<%@page import="schoolmanagement.entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sudarshan");
	EntityManager em = emf.createEntityManager();
	Teacher t = em.find(Teacher.class, id1);
	%>

	<form action="updatet" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		salary: <input type="text" value="<%=t.getSalary()%>" name="salary">
		subject: <input type="text" value="<%=t.getSubject()%>"name="subject">
		<input type="submit">
	</form>


	

</body>
</html>