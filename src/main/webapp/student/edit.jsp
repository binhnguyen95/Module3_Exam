<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/student">List All Student</a>
    </h2>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Student
                </h2>
            </caption>
            <c:if test="${student != null}">
                <input type="hidden" name="id" value="${student.id}"/>
            </c:if>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="${student.name}"/>
                </td>
            </tr>
            <tr>
                <th>Student birthDate:</th>
                <td>
                    <input type="text" name="email" size="45" value="${user.email}"
                    />
                </td>
            </tr>
            <tr>
                <th>Student address:</th>
                <td>
                    <input type="text" name="country" size="15" value="${user.country}"
                    />
                </td>
            </tr>
            <tr>
                <th>Student phone:</th>
                <td>
                    <input type="text" name="country" size="15" value="${user.country}"
                    />
                </td>
            </tr>
            <tr>
                <th>Student email:</th>
                <td>
                    <input type="text" name="country" size="15" value="${user.country}"
                    />
                </td>
            </tr>
            <tr>
                <th>Student classRoom:</th>
                <td>
                    <input type="text" name="country" size="15" value="${user.country}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>

        <h3>
            <c:if test='${alo != null}'>
                <span style="color: #12faf5"> ${alo} </span>
            </c:if>
        </h3>

    </form>
</div>
</body>
</html>