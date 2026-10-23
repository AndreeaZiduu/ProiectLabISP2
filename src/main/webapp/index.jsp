<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<br>
<a href="CounterServlet?inc=1">CounterServlet GET</a>
<a href="CounterServlet?dec=1">CounterServlet GET (-1)</a>
<a href="CounterServlet?inc=3">CounterServlet GET (+3)</a>
<a href="CounterServlet?dec=2">CounterServlet GET (-2)</a>
<form action="CounterServlet" method="POST">
    <br>inc: <input type="text" name="inc" value="1">
    <br>dec: <input type="text" name="dec" value="1">
    <br><input type="submit" value="CounterServlet POST">
</form>
</body>
</html>