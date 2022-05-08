<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addProduct" method="get">
Enter Product name<input type ="text" name="name"><br>
Enter Category
<select name="category">
<option value ="ELECTRONICS">Electronics</option>
<option value ="TOYS">Toys</option>
<option value ="SPORTS">Sports</option>
<option value ="APPARALES">Apparales</option>
</select><br>
Enter Product brand<input type ="text" name="brand"><br>
Enter Product price<input type ="text" name="price"><br>
<input type ="submit" value ="Add Product">
</form>
</body>
</html>