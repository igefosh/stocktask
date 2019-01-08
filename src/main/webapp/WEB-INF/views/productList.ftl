<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products List</title>
</head>
<body>
<h1>Products List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>ARTICLE</th>
        <th>NAME</th>
        <th>SHELF</th>
        <th>BOX</th>
    </tr>
    <#list products as product>
        <tr>
            <td><a href="product/${product.id}">${product.id}</a></td>
            <td>${product.art}</td>
            <td>${product.name}</td>
            <td>${product.shelf}</td>
            <td>${product.box}</td>
            <td><a href="delete/${product.id}">Delete</a></td>
            <td><a href="update/${product.id}">Update</a></td>
            <td><a href="toBuffer/${product.id}">To Order</a></td>
        </tr>
    </#list>
</table>
<br>
<a href="addProduct">Add Product</a>
<br>
<a href="allOrders">See all orders</a>

</body>
</html>