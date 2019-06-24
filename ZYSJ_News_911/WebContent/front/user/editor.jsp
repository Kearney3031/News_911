<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="../../news/All.do" >
<input type="button" value="写新闻" id="addNews" />
<input type="submit" value="查看我上传的新闻"/></form>
<form action="../../topic/All.do">
<a href="../topic/addTopic.jsp"><input type="button" value="发起话题" id="addTopic" /></a>
<input type="submit" value="查看我发起的话题"/></form>
<form action="../../video/All.do" >
<a href="../video/upload.jsp"><input type="button" value="上传视频" id="videoUpload" /></a>
<input type="submit" value="查看我上传的视频"/></form>
<c:choose>
<c:when test="${temp==0}">
<table border="0" width="100px">
		<c:choose>
		<c:when test="${newsList!=null}">
		<tr>
		<td>新闻</td>
		<td>点赞数</td>
		<td>审核状态</td>
		<td>发布时间</td>
		</tr>
		</c:when>
		</c:choose>
        <tbody>
                <c:forEach items="${newsList}" var="news">
                    <tr>
                     <td>  <a href="../../news/display.do?id=${news.newsId}"> ${news.newsTitle}</a></td>
                    <td>${news.newsLike}</td>
                    <c:choose>
                    <c:when test="${news.newsStatus==0}"> <td>未审核</td></c:when>
                   <c:when test="${news.newsStatus==1}"> <td>通过审核</td></c:when>
                   <c:otherwise><td>未通过</td></c:otherwise>
                    </c:choose>
                    <td>${news.publishTime}</td>
                    </tr>   
                              
                </c:forEach>
        </tbody>
</table>
</c:when>
</c:choose>
<c:choose>
<c:when test="${temp==1}">
<table border="0" width="100px">
		<c:choose>
		<c:when test="${topicList!=null}">
		<tr>
		<td>话题</td>
		
		</tr>
		</c:when>
		</c:choose>
        <tbody>
                <c:forEach items="${topicList}" var="topic">
                    <tr>
                     <td>  <a href="../../topic/display.do?id=${topic.topicId}"> ${topic.topicName}</a></td>
                    </tr>             
                </c:forEach>
        </tbody>
</table>
</c:when>
</c:choose>
<c:choose>
<c:when test="${temp==2}">
<table border="0" width="100px">
		<c:choose>
		<c:when test="${videoList!=null}">
		<tr>
		<td>视频</td>
		<td>点赞数</td>
		<td>下载次数</td>
		
		</tr>
		</c:when>
		</c:choose>
        <tbody>
                <c:forEach items="${videoList}" var="video">
                    <tr>
                     <td>  <a href="../../video/display.do?id=${video.videoId}"> ${video.videoRealName}</a></td>
                    <td>${video.videoLike}</td> 
                    <td>${video.dTimes}</td>
                    </tr>   
                              
                </c:forEach>
        </tbody>
</table>
</c:when>
</c:choose>
</body>
</html>