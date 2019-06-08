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
<form action="user/addUserType.do" method="post">
您喜欢的类别？<br /><br />
<c:if test="${!empty listType }">
                <c:forEach items="${listType}" var="list">    
                <label><input name="Type" type="checkbox" value="${list.typeId}" />${list.typeName}</label>
                </c:forEach>
            </c:if>
<input type="hidden" value="${user.userId}" name="userId" />
<input type="submit" value="订阅">
</form>


<form action="type/addCookieType.do" method="post">
<input type="text" name="Type" />
<input type="submit"/>
</form>
</body>
</html>