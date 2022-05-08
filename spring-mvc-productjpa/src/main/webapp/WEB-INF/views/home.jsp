<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:right">
<a href="admin">admin</a>
</div>
<form action="search" method="get">
Product Brand/category:<input type="text" name="choice"><br>
<input type="submit" value="Get By Brand/Category"><br>
</form>
<h1>Product List</h1>
<hr>
${products }

</body>
</html>