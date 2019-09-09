<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<h1>Register Book</h1>
	<form action="BookRegister" method="post" style="padding-left:100px">
		<table style="width:75%" >
		  
		  <tr>
		    <td>Name: </td>
		    <td><input type="text" name="name" required></td>
		    
		  </tr>
		  <tr>
		    <td>Author:</td>
		    <td><input type="text" name="author" required></td>
		    
		  </tr>
		  <tr>
		    <td>Subject:</td>
		    <td><input type="text" name="subject" required></td>
		    
		  </tr>
		  <tr>
		    <td>Price:</td>
		    <td><input type="number" name="price" required ></td>
		    
		  </tr>
		  <tr>
		    <td>File Name(with extension):</td>
		    <td><input type="text" name="file" required></td>
		    
		  </tr>
		  <tr>
		    <td></td>
		    <td><button type="submit" name="submit">Register Book</button></td>
		    
		  </tr>
		</table>
		
	</form>
</body>
</html>