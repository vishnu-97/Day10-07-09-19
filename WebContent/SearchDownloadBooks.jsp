<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchBooks</title>
</head>
<body>
	<h1>Search Books</h1>
	<h4>Search By</h4>
	<form action="BookSearch" method="get" style="padding-left:100px">
		<table style="width:75%" >
		  
		  
		  <tr>
		    <td>Id: </td>
		    <td><input type="number" name="id" ></td>
		    
		  </tr>
		  <tr>
		    <td>Name: </td>
		    <td><input type="text" name="name" ></td>
		    
		  </tr>
		  <tr>
		    <td>Author:</td>
		    <td><input type="text" name="author" ></td>
		    
		  </tr>
		  <tr>
		    <td>Genre:</td>
		    <td><input type="text" name="genre" ></td>
		    
		  </tr>
		  <tr>
		    <td></td>
		    <td><button type="submit" name="submit">Search</button></td>
		    
		  </tr>
		</table>
		
	</form>
</body>
</html>