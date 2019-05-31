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
<<<<<<< HEAD
<form action="../../messageUnder.jsp"> <input type="submit" value="跳转"> </form>
=======
这里是<%=request.getSession().getAttribute("country") %><%=request.getSession().getAttribute("pro") %><%=request.getSession().getAttribute("city") %><br>
<%=request.getSession().getAttribute("time") %><br>
<%=request.getSession().getAttribute("today") %><br>
<%=request.getSession().getAttribute("now") %><br>
<form action="../../index.html"> <input type="submit" value="跳转"> </form>
>>>>>>> branch 'master' of https://github.com/Kearney3031/News_911.git

<form action="../../user/findUserTypeByUserId.do">
<input type="text" name="userId" value="${userId}" />
<input type="submit"/> 
</form>
</body>
</html>