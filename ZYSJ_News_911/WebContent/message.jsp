<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>评论</title>
</head>
<body>



<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="js/jsMessage.js" ></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<form action="message/find.do">
<input type="submit"/> 
</form>

<form action="message/insert.do" method="post">
<input type="textarea" name="megContent" id="Megcontent">
<input type="submit" value="提交">
<input type="button" id="addMeg" value="json提交"/>
</form>

</body>
</html>



