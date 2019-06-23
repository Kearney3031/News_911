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

<table>
<c:forEach items="${goods}" var="g">

<tr>
<td>名称${g.goodsName}</td>
<td><img  src="${pageContext.request.contextPath.concat(g.goodsImg)}" width="10px" height="10px"/></td>
<td>价格：${g.goodsPrice}</td>
<td>介绍：${g.goodsInfo}</td>
<td><a href="../goods/delete.do?id=${g.goodsId}"><input type="button" value="删除商品"></a></td>
</tr>

</c:forEach>
</table>
</body>
</html>