<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../advert/addAdvert.do"  method="post" enctype="multipart/form-data">
广告名称:<input name="name" />
广告图片：<input type="file" name="advertImg" />
广告链接：<input name="advertLink">
<input type="submit" value="添加" />
</form>
</body>
</html>