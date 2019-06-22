<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/typeManage.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.js"></script>
<link href="${pageContext.request.contextPath }/Style/MsgStyle.css" rel="stylesheet" type="text/css" />
<body>
<h1 align="center">主题管理页面</h1>
<br><br>
<div class="div_container">
<table border="1" cellpadding="10" cellspacing="0">
       <thead>
            <tr align="center">
                <th>主题ID</th>
                <th>主题名称</th>
                <th>主题内容</th>
                <th></th>
                <th></th>
            </tr>
       </thead>
       <tbody>
            <c:forEach items="${requestScope.pageBean.list}" var="type">
                    <tr align="center">
                        <td>${type.typeId }</td>
                        <td>${type.typeName }</td>
                        <td>${type.typeIntroduce }</td>
                        <td><a href="${pageContext.request.contextPath }/type/inputUpdate.do?typeId=${type.typeId}">修改</a></td>
                        <td><a href="${pageContext.request.contextPath }/type/deleteType.do?typeId=${type.typeId}" class="deleteType">删除</a>
                            <input type="hidden" value="${type.typeName }"/>
                        </td>
                    </tr>                
            </c:forEach>
       </tbody>
       
    </table>
    <span style="text-align: right;"> 当前页:<strong>${pageBean.pageNumber }</strong></span>
    <span>共<strong>${pageBean.totalPage }</strong>页</span>
    </br><br>
    <center>
            <a href="${pageContext.request.contextPath }/type/showAllType.do?pageNumber=${pageBean.pageNumber-1}"
                <c:if test="${pageBean.pageNumber-1<1}">onclick="javascript:return false"</c:if> >
                    <input type="button" value="上一页"/>
            </a>
            <a href="${pageContext.request.contextPath }/type/showAllType.do?pageNumber=${pageBean.pageNumber+1}"
                <c:if test="${pageBean.pageNumber+1>pageBean.totalPage}">onclick="javascript:return false"</c:if> >
                    <input type="button" value="下一页"/>
            </a>
    </center>
</div>

</body>
</html>