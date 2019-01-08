<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All orders</title>
</head>
<body>
<h1>All orders</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Order for:</th>
        <th>Details</th>
    </tr>
    <#list orders as order>
        <tr>
            <form name="toStockman" action="toStockmanList" method="post">
                <td><input title="Id" type="text" name="id" value="${order.id}" readonly></td>
                <td><input title="Name" type="text" name="name" value="${order.name}" readonly></td>
                <td><a href="orderDetails/${order.name}">Details</td>
                <td><a href="deleteOrder/${order.name}">Delete order</td>
                <td><input type="submit" value="ADD TO STOCKMAN`S LIST"></td>
            </form>
            <td>
                <a href="deleteFromStockmanList/${order.id}">Delete from Stockman`s list</a>
            </td>
        </tr>
    </#list>
</table>
<br>
<table border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    <#list sorders as order>
        </tr>
        <td>${order.id}</td>
        <td>${order.name}</td>
        </tr>
    </#list>
    <tr>
        <td colspan="2">
            <a href="stockmanList">Confirm orders</a>
        </td>
    </tr>
</table>
<a href="/stocktask_war/products">To Products</a>
</body>
</html>