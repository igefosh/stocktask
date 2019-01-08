<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add product to order</title>
</head>
<body>
<h1>Add product to order</h1>
<form name="product" action="addToOrder" method="post">
    <p>ID</p>
    <input title="Id" type="text" name="id" value="${product.id}" readonly>
    <p>ARTICLE</p>
    <input title="Art" type="text" name="art" value="${product.art}" readonly>
    <p>NAME</p>
    <input title="Name" type="text" name="name" value="${product.name}" readonly>
    <p>SHELF</p>
    <input title="Shelf" type="text" name="shelf" value="${product.shelf}" readonly>
    <p>BOX</p>
    <input title="Box" type="text" name="box" value="${product.box}" readonly>
    <p>Enter QUANTITY</p>
    <input title="Quantity" type="number" name="quantity" value="0">
    <br>
    <input type="submit" value="OK">
</form>
<br>
<a href="/stocktask_war/products">To Products</a>
</body>
</html>