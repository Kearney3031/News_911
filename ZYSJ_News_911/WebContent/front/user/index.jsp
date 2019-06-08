<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎你${user.userId}



这里是<%=request.getSession().getAttribute("country") %><%=request.getSession().getAttribute("pro") %><%=request.getSession().getAttribute("city") %><br>
<%=request.getSession().getAttribute("time") %><br>
<%=request.getSession().getAttribute("today") %><br>
<%=request.getSession().getAttribute("now") %><br>


<form action="../../messageUnder.jsp"> 
<input type="submit" value="评论区"> 
</form>
<form action="../../type/find.do">
<input type="submit" value="类别订阅"/> 
</form>
</body>
</html>