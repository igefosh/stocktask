<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Details</title>
</head>
<body>
<h1>Details</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>ARTICLE</th>
        <th>NAME</th>
        <th>SHELF</th>
        <th>BOX</th>
        <th>QUANTITY</th>
    </tr>
    <#list orderdetails as order>
        </tr>
        <td>${order.id}</td>
        <td>${order.art}</td>
        <td>${order.name}</td>
        <td>${order.shelf}</td>
        <td>${order.box}</td>
        <td>${order.quantity}</td>
        </tr>
    </#list>
</table>
<a href="/stocktask_war/allOrders">Back</a>
<a href="/stocktask_war/products">To Products</a>
</body>
</html>