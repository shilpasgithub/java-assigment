<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update </title>
<link rel="stylesheet" type="text/css" href="Styless.css">
</head>
<body>
<div class="container">
<% String username = (String)request.getAttribute("username");%>
<% 
       request.getSession().setAttribute("username", username); 
 %>
<h2>Welcome : <%= username %> </h2>
<h3>Update your Bio </h3>
<form action="BioUpdate" method="POST">
  <input type="text" id="ll" name="bio" placeholder="Enter Bio"><br><br>
  <input type="submit" value="Submit">
</form>
</div>
</body>
</html>