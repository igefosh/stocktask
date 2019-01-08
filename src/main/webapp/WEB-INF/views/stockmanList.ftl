<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Stockman`s List</title>
</head>
<body>
<H1>Stockman`s List</H1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>ORDER NAME</th>
        <th>ARTICLE</th>
        <th>NAME</th>
        <th>SHELF</th>
        <th>BOX</th>
        <th>QUANTITY</th>
    </tr>
    <#list sorders as sorder>
        <tr>
            <td>${sorder.id}</td>
            <td>${sorder.order}</td>
            <td>${sorder.art}</td>
            <td>${sorder.name}</td>
            <td>${sorder.shelf}</td>
            <td>${sorder.box}</td>
            <td>${sorder.quantity}</td>
        </tr>
    </#list>
    <tr>
        <td colspan="7"><a href="finish">Mission complete!</a></td>
    </tr>
</table>

</body>
</html>