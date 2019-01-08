<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
</head>
<body>
<h1>Create Product</h1>
<form name="product" action="addProduct" method="post">
    <p>ARTICLE</p>
    <input title="Art" type="text" name="art" required>
    <p>NAME</p>
    <input title="Name" type="text" name="name" required>
    <p>SHELF</p>
    <input title="Shelf" type="number" name="shelf" required>
    <p>BOX</p>
    <input title="Box" type="text" name="box" required>
    <br>
    <input type="submit" value="OK">
</form>
<br>
<a href="/stocktask_war/products">To Products</a>
</body>
</html>