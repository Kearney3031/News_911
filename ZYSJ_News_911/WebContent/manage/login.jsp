<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="../js/jq03.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Style/Login.css" />
</head>
<body>
    <div class="wrapLogin">
		    <div class="loginPanel">
		    		<h2>指尖新闻后台管理系统</h2>
			       	    <p><label>账号：</label><input type="text" id="username1"/></p>
			           	<p><label>密码：</label><input type="password" id="password"/></p>
			        	<p class="btn">
			        	     <input type="button" class="btnLogin" id="login1" value="登录" />
			        	     <input type="button" class="btnCancel" value="重置" />
			        	</p>	       		
		     </div>
    </div>
</body>
</html>