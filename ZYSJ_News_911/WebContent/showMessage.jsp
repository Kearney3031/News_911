<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="js/jqMes.js" ></script>
<%-- <table id="message" border="1">
        <tbody>
            <tr>
                <th>ID</th>
                <th>内容</th>
                <th>点赞数</th>
                <th>时间</th>
                <th>用户Id</th>
                <th>新闻Id</th>
                <th>视频Id</th>
                <th>主题Id</th>
                <th>操作</th>
            </tr>
            <c:if test="${!empty listMessage }">
                <c:forEach items="${listMessage}" var="list">
                    <tr>
                        <td>${list.messageId }</td>
                        <td>${list.megContent }</td>
                        <td>${list.megLike }</td>
                        <td>${list.time }</td>
                        <td>${list.userId }</td>
                        <td>${list.newsId }</td>
                        <td>${list.videoId }</td>
                        <td>${list.topicId }</td>
                        <td><input  type="button" value="修改" id="update" /></td>
                        <td><input  type="button" value="删除" id="delete"   /></td>
                    </tr>                
                </c:forEach>
            </c:if>
        </tbody>
    </table> --%>




<div align="center">

<table id="order" border="1" cellspacing="0" cellpadding="0">
	<tr class="title">
	<td>id</td>
		<td>内容</td>
		<td>点赞数</td>
		<td>时间</td>
		<td>用户Id</td>
		<td>新闻Id</td>
		<td>视频Id</td>
		<td>主题Id</td>
		<td>操作</td>
		<td>全选<input type="checkbox" id="checkAll"/></td>
	</tr>
</table>

<input type="button" value="批量删除" id="deletebtn"/>

</div>





</body>
</html>