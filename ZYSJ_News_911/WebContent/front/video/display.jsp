<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../../js/jquery-1.6.2.js"></script>
 <script type="text/javascript" src="../../js/jq02.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
视频名称：${video.videoRealName}
点赞数：${video.videoLike}
下载次数：${video.dTimes}
<a href="show.html?fname=${path}" title="观看视频" target="_blank">播放视频</a>
<form action="../../video/download.do" method="post">
<input type="submit"  value="下载" />
</form>
</body>
</html>