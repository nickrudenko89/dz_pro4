<%--
  Created by IntelliJ IDEA.
  User: Oksana
  Date: 16.11.2017
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Forum</title>
</head>
<body>
Темы форума:<br>
<a href="/forum?theme=1">Theme 1</a><br>
<a href="/forum?theme=2">Theme 2</a><br>
<a href="/forum?theme=3">Theme 3</a>
<!--
<form action="/forum" method="post">
  <input type="text" name="user" />
  <input type="text" name="message" />
  <input type="submit" value="Send" />
-->
</form>
</body>
</html>
<script> function show() { $.ajax({ url: "msg.jsp", cache: false, success: function(html){ $("#content").html(html); } }); } $(document).ready(function(){ show(); setInterval('show()',1000); }); </script>