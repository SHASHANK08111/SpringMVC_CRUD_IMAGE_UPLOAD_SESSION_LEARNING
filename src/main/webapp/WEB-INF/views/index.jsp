
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="SpringMVC.Model.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>called by home mapping</h1>
    <%
       String name=(String) request.getAttribute("name");
       Student student=(Student)request.getAttribute("Student");
    %>
    <h1> Name is <%=name%> </h1>
    <h1> Name is <%=student.getRollNumber()%> </h1>
    <h1> Name is <%=student.getName()%> </h1>
    
</body>
</html>