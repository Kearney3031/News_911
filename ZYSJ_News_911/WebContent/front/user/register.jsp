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
<center>
<table border='1',width='1' align="center">
<tr>
<td>用户名：</td><td><input name="username" id="username"/></td></tr>
<tr><td>密码：</td><td><input type="password" name="password" id="pwd"/></td></tr>
<tr><td>用户昵称：</td><td><input name="realname" id="rname"/></td></tr>
<tr><td>电话号码：</td><td><input name="phone" id="phone"/></td></tr>
<tr><td>邮箱：</td><td><input name="email" id="email"/></td></tr>
<tr><td>验证码：</td><td><input name="code"  id="code" /></td><td><input type="button" value="发送验证码"  id="sendmail" /></td></tr>
<tr><td>用户类型：</td><td><label>
    <input type="radio" name="userType" value="1" id="RadioGroup1_0" class="type"/>
     会员
  </label>
  
  <label>
    <input type="radio" name="userType" value="2" id="RadioGroup1_1" class="type" />
   小编
  </label>
</td></tr>

</table>
<input type="button" value="完成" id="submit"/>
</center>
</body>
</html>