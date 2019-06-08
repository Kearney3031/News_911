<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
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

<form action="type/find.do">
<input type="submit"/> 
</form>

<form action="message/find.do" method="post">
<input type="textarea" name="megContent" id="Megcontent">
<input type="submit" value="提交">
<input type="button" id="addMeg" value="json提交"/>
</form>




<table border="1">
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
            <c:if test="${!empty messages }">
                <c:forEach items="${messages}" var="list">
                    <tr>
                        <td>${list.id }</td>
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
    </table>


<form action="message/addLike.do?id=27">
<input type="submit"/> 
 <input type="button" id="addLike" value="jsonLike"/>
</form>


</body>
</html>



