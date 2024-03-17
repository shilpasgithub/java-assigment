<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="Styles.css">
</head>
<body>
<div class="container">
<% String bio = (String)request.getAttribute("bio");%>
<% String username = (String)request.getAttribute("username");%>
<% 
       request.getSession().setAttribute("username", username); 
 %>

<h3>Welcome : <%= username %> </h3><br>
<h3>About Me : <%= bio %> </h3>
<br>
<form action="Trigger" method="GET">
<button type="submit">Update Bio</button>
</form>
<br>
<form action="DeleteAcc" method="POST" class=delete>
<button type="submit" >Delete Account</button>
</form>

   </div>
</body>
</html>