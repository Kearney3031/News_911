<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/topicManage.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.js"></script>
<link href="${pageContext.request.contextPath }/Style/MsgStyle.css" rel="stylesheet" type="text/css" />
<body>

<h1 align="center">话题管理页面</h1>
<br><br>
<div class="div_container">
<table border="1" cellpadding="10" cellspacing="0">
	       <thead>
	            <tr align="center">
	                <th>话题ID</th>
	                <th>话题名称</th>
	                <th>话题内容</th>
	                <th>发起人ID</th>
	                <th></th>
	            </tr>
	       </thead>
           <tbody>
                <c:forEach items="${requestScope.pageBean.list}" var="topic">
                    <tr align="center">
                        <td>${topic.topicId }</td>
                        <td>${topic.topicName }</td>
                        <td>${topic.topicContent }</td>
                        <td>${topic.userId }</td>
                        <td><a href="${pageContext.request.contextPath }/topic/deleteTopic.do?topicId=${topic.topicId}" class="deleteTopic">违规？删除</a>
                            <input type="hidden" value="${topic.topicName }"/>
                        </td>
                    </tr>                
                </c:forEach>
           </tbody>
</table>
    <span style="text-align: right;"> 当前页:<strong>${pageBean.pageNumber }</strong></span>
    <span>共<strong>${pageBean.totalPage }</strong>页</span>
    </br><br>
    <center>
	    <a href="${pageContext.request.contextPath }/topic/showAllTopic.do?pageNumber=${pageBean.pageNumber-1}"
	         <c:if test="${pageBean.pageNumber-1<1}">onclick="javascript:return false"</c:if> >
	            <input type="button" value="上一页"/>
	    </a>
	    <a href="${pageContext.request.contextPath }/topic/showAllTopic.do?pageNumber=${pageBean.pageNumber+1}"
	         <c:if test="${pageBean.pageNumber+1>pageBean.totalPage}">onclick="javascript:return false"</c:if> >
	            <input type="button" value="下一页"/>
	    </a>
    </center>
</div>
</body>
</html>