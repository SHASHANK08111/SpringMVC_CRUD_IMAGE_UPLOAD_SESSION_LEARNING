<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h2>User Form</h2>
    <form:form method="post" action="saveUser" modelAttribute="user">
        <table>
            <tr>
                <td>Username:</td>
                <td><form:input path="userName" /></td> 
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="passWord" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
