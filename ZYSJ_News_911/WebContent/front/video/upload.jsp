<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user/upload.do" method="post" enctype="multipart/form-data">
  			<!-- 创建上传的组件 -->
  			上传视频	<input type="file" name="upload"  id="file" />
  			<%-- <s:file label="上传文件" name="upload"></s:file> --%>
  			<!-- 使用一样的upload,表示将文件上传到Action的一个文件集合中 -->
  			<!-- <s:submit value="上传"></s:submit> -->
  			<input type="submit" value="上传" />
      </form>
</body>
</html>