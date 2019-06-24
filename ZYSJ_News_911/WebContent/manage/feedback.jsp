<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userManage.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.js"></script>
<link href="${pageContext.request.contextPath }/Style/MsgStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table>
<c:forEach items="${list}" var="f">

<tr>
<td>反馈内容：${f.feedbackContent}</td>
<td>反馈用户编号：${f.userId}</td>
<td>反馈时间：${f.fbTime}</td>
</tr>

</c:forEach>
</table>
</body>
</html>