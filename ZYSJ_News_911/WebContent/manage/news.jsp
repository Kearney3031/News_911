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
<c:forEach items="${list}" var="news">
                   
                       <a href="../news/display.do?id=${news.newsId}"> ${news.newsTitle}</a>
                      <a href="../news/passNews.do?id=${news.newsId}"> <input  type="button" value="通过" ></a>
                   <a href="../news/dispassNews.do?id=${news.newsId}"> <input  type="button" value="不通过" ></a>
                    <hr/>             
                </c:forEach>
</body>
</html>