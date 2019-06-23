<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-1.6.2.js"></script>
 <script type="text/javascript" src="../../js/jq04.js"></script>
</head>
<body>
您好,${user.userRealName}<br>
用户名：${user.userName}<br>
积分：${user.score}<br>
手机号:${user.phone}<br>
邮箱：${user.email}<br>
<input type="button" value="修改昵称" onclick="editMes()" />
<input type="button" value="修改手机号" onclick="editMes1()" />
<a href="../../goods/findAll.do"><input type="button" value="兑换商品" /></a>

</body>
</html>