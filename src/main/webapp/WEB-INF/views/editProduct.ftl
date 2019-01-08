<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
</head>
<body>
<form name="user" action="updateUser" method="post">
    <p>ID</p>
    <input title="Id" type="text" name="id" value="${user.id}" readonly>
    <p>NAME</p>
    <input title="Name" type="text" name="name" value="${user.name}">
    <p>EMAIL</p>
    <input title="Email" type="text" name="email" value="${user.email}">
    <p>AGE</p>
    <input title="Age" type="text" name="age" value="${user.age}">
    <br>
    <input type="submit" value="OK">
</form>
<br>
<a href="/stocktask_war/users">To Users</a>
</body>
</html>