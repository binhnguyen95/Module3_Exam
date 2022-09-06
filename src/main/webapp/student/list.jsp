<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>Student Management</h1>
  <h2>
    <a href="/student?action=create">Add New Student</a>
  </h2>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List of Student</h2></caption>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Birth Date</th>
      <th>Address</th>
      <th>Phone</th>
      <th>Email</th>
      <th>Classroom</th>
    </tr>
    <c:forEach var="student" items="${LIST}">
      <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.address}</td>
        <td>${student.birthDate}</td>
        <td>${student.phone}</td>
        <td>${student.email}</td>
        <td>${student.classRoom}</td>
        <td>
          <a href="/student?action=edit&id=${student.id}">Edit</a>
          <a href="/student?action=delete&id=${student.id}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>