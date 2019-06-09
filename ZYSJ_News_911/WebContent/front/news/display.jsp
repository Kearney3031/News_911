<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="../../js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="../../js/jsMessage.js" ></script>
<script type="text/javascript" src="../../js/jqShare.js"></script>
<h1>${news.newsTitle}</h1><br>
<img  src="${pageContext.request.contextPath.concat(news.newsImg)}" /><br>
${news.newsContent}<br>
点赞数：${news.newsLike}<br>
发布时间：${news.publishTime}<br>
新闻作者:${name} 
<br>
 <input type="button" id="shareToQQ" value="分享到QQ空间"/>
　<input type="button" id="shareToXl" value="分享到新浪微博"/>
	<button id="collect">收藏该文章</button>

</body>
</html>