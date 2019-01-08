<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Products</title>
</head>
<body>
<form name="product" action="updateProduct" method="post">
    <p>ID</p>
    <input title="Id" type="text" name="id" value="${product.id}" readonly>
    <p>ART</p>
    <input title="Art" type="text" name="art" value="${product.art}">
    <p>NAME</p>
    <input title="Name" type="text" name="name" value="${product.name}">
    <p>SHELF</p>
    <input title="Shelf" type="text" name="shelf" value="${product.shelf}">
    <p>BOX</p>
    <input title="Box" type="text" name="box" value="${product.box}">
    <br>
    <input type="submit" value="OK">
</form>
<br>
<a href="/stocktask_war/products">To Products</a>
</body>
</html>