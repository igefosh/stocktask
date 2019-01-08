<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
</head>
<body>
<h1>Update Product</h1>
<form name="product" action="updateProduct" method="post">
    <p>ID</p>
    <input title="Id" type="text" name="id" value="${product.id}" readonly>
    <p>ARTICLE</p>
    <input title="Art" type="text" name="art" value="${product.art}" required>
    <p>NAME</p>
    <input title="Name" type="text" name="name" value="${product.name}" required>
    <p>SHELF</p>
    <input title="Shelf" type="number" name="shelf" value="${product.shelf}" required>
    <p>BOX</p>
    <input title="Box" type="text" name="box" value="${product.box}" required>
    <br>
    <input type="submit" value="OK">
</form>
<br>
<a href="/stocktask_war/products">To Products</a>
</body>
</html>