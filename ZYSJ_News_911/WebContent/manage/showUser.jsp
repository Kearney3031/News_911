<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userManage.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.js"></script>
<link href="${pageContext.request.contextPath }/Style/MsgStyle.css" rel="stylesheet" type="text/css" />
<body>
<h1 align="center">用户管理页面</h1>
<br><br>
<div class="div_container">
<table border="1" cellpadding="10" cellspacing="0">
	       <thead>
	            <tr align="center">
	                <th>用户ID</th>
	                <th>用户名</th>
	                <th>昵称</th>
	                <th>联系电话</th>
	                <th>邮箱</th>
	                <th>用户类型</th>
	                <th>累积分数</th>
	                <th></th>
	            </tr>
	       </thead>
           <tbody>
                <c:forEach items="${requestScope.pageBean.list}" var="user">
                    <tr>
                        <td>${user.userId }</td>
                        <td>${user.userName }</td>
                        <td>${user.userRealName }</td>
                        <td>${user.phone }</td>
                        <td>${user.email }</td>
                        <td>${user.userType }</td>
                        <td>${user.score }</td>
                        <td><a href="${pageContext.request.contextPath }/user/deleteUser.do?userId=${user.userId}" class="deleteUser">冻结？删除</a>
                            <input type="hidden" value="${user.userName }"/>
                        </td>
                    </tr>                
                </c:forEach>
            </tbody>
</table>
    <span style="text-align: right;"> 当前页:<strong>${pageBean.pageNumber }</strong></span>
    <span>共<strong>${pageBean.totalPage }</strong>页</span>
    </br><br>
    <center>
	    <a href="${pageContext.request.contextPath }/user/showAllUser.do?pageNumber=${pageBean.pageNumber-1}"
	         <c:if test="${pageBean.pageNumber-1<1}">onclick="javascript:return false"</c:if> >
	            <input type="button" value="上一页"/>
	    </a>
	    <a href="${pageContext.request.contextPath }/user/showAllUser.do?pageNumber=${pageBean.pageNumber+1}"
	         <c:if test="${pageBean.pageNumber+1>pageBean.totalPage}">onclick="javascript:return false"</c:if> >
	            <input type="button" value="下一页"/>
	    </a>
    </center>
</div>
</body>
</html>