<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-1.6.2.js"></script>
 <script type="text/javascript" src="../../js/jq03.js"></script>
</head>
<body>

用户名：<input name="username" id="username"/>
密码：<input type="password" name="password" id="pwd"/>
用户昵称：<input name="realname" id="rname"/>
电话号码：<input name="phone" id="phone"/>
邮箱：<input name="email" id="email"/>
验证码：<input name="code"  id="code" /><input type="button" value="发送验证码"  id="sendmail" />
用户类型：<label>
    <input type="radio" name="userType" value="1" id="RadioGroup1_0" class="type"/>
     会员
  </label>
  
  <label>
    <input type="radio" name="userType" value="2" id="RadioGroup1_1" class="type" />
   小编
  </label>

<input type="button" value="完成" id="submit"/>

</body>
</html>