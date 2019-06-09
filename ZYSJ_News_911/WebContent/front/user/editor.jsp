<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../js/jquery-1.6.2.js"></script>
 <script type="text/javascript" src="../../js/editor.js"></script>
<title>Insert title here</title>
</head>
<body>
您好，亲爱的小编${user.userName}
<input type="button" value="写新闻" id="addNews" />
<a href="../topic/addTopic.jsp"><input type="button" value="发起话题" id="addTopic" /></a>
<a href="../video/upload.jsp"><input type="button" value="上传视频" id="videoUpload" /></a>
</body>
</html>