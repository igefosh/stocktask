<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Users List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>AGE</th>
    </tr>
    <#list users as user>
        <tr>
            <td><a href="user/${user.id}">${user.id}</a></td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td><a href="delete/${user.id}">Delete</a></td>
            <td><a href="update/${user.id}">Update</a></td>
            <td><a href="toBuffer/${user.id}">To Order</a></td>
        </tr>
    </#list>
</table>
<br>
<a href="addUser">Add User</a>
</body>
</html>