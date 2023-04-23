<%@page import="schoolmanagement.entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("sudarshan");
  EntityManager em = emf.createEntityManager(); 
  Query q=em.createQuery("select a from Teacher a");
  List<Teacher>l=q.getResultList();
%>
  <h2>Teacher Data</h2>
  <table border="2px">
  <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Subject</th>
   <th>Salary</th>
  </tr>
   
  <%for(Teacher t:l)
  {
  %>
  <tr>
  <td><%=t.getId()%></td>
  <td><%=t.getName()%></td>
  <td><%=t.getSubject()%></td>
  <td><%=t.getSalary()%></td>
  </tr>
   <% }%>
   </table>
   <a href="teachermenu.html">Teacher Menu</a>
</body>
</html>