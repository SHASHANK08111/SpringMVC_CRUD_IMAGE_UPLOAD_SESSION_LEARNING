<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>All Users</h2>
    <form action="logout">
        <input type="submit" value="logout"/>
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.passWord}</td>
                     <td>
                        <img src="data:image/jpeg;base64,${user.base64ProfileImage}" alt="Profile Image" style="width: 100px; height: 100px;">
                     </td>
                    <td>
                        <form action="deleteUser" method="post">
                            <input type="hidden" name="userId" value="${user.id}">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    
                    <td>
                        <form action="updateUser" method="post">
                            <input type="hidden" name="userId" value="${user.id}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td>
   
					   <form method="post" action="uploadImage" enctype="multipart/form-data">
                            <input type="hidden" name="userId" value="${user.id}">
                            <input type="file" name="imageFile">
                            <input type="submit" value="Upload Image">
                        </form>
					
                   
                   </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
