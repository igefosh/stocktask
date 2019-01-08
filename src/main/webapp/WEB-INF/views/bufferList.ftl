<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create order</title>
</head>
<body>
<h1>Create order</h1>
<form name="createorder" action="createOrder" method="post">
    <table border="1">
        <tr>
            <th>ARTICLE</th>
            <th>NAME</th>
            <th>SHELF</th>
            <th>BOX</th>
            <th>QUANTITY</th>
        </tr>
        <#list bufferEntitys as buffer>
            <tr>
                <td>${buffer.art}</td>
                <td>${buffer.name}</td>
                <td>${buffer.shelf}</td>
                <td>${buffer.box}</td>
                <td>${buffer.quantity}</td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="/stocktask_war/products">Add More Products</a>
    <br>
    <p>Enter client name:</p>
    <input title="Order" type="text" name="orderNumber" required placeholder="Enter client`s name">
    <input type="submit" value="CREATE ORDER">
</form>
<br>
<a href="allOrders">See all orders</a>
<br>
<a href="/stocktask_war/products">To Products</a>
</body>
</html>