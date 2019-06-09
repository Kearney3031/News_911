<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div  class="newscon">
<c:choose>
<c:when test="${user==null}">
<input type="button" id="login" value="登录"/>
<input type="button" id="reg" value="注册"/>
</c:when>
<c:otherwise>
欢迎您,${user.userName} 
</c:otherwise>
</c:choose>
<h1>您看过的</h1>


<table border="0" width="100px">
        <tbody>
          
            
                <c:forEach items="${list}" var="news">
                    <tr>
                     <td>  <a href="display.do?id=${news.newsId}"> ${news.newsTitle}</a></td>
                  
                       
                    </tr>   
                    <tr><td><hr/></td></tr>             
                </c:forEach>
           
        </tbody>
    </table>
                </div>

</body>
</html>