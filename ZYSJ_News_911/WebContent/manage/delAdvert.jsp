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

<a href="../manage/addAdvert.jsp">添加广告</a>
<table>
<c:forEach items="${adverts}" var="a">

<tr>
<td>名称${a.advertName}</td>
<td><img  src="${pageContext.request.contextPath.concat(a.advertImg)}" width="10px" height="10px"/></td>
<td>链接：${a.advertLink}</td>

<td><a href="../advert/delete.do?id=${a.advertId}"><input type="button" value="删除广告"></a></td>
</tr>

</c:forEach>
</table>
</body>
</html>