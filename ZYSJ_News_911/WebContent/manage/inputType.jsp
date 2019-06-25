<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Style/AddStyle.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.js"></script>
<script type="text/javascript">
$(function(){
	var typeName=false;
	var typeIntroduce=false;
    $(":input[name='typeName']").blur(function(){
    	if($(this).val()==""){
    		typeName=false;
		}else{
			typeName=true;
		}
    })
	$(":textarea[name='typeIntroduce']").blur(function(){
    	if($(this).val()==""){
    		typeIntroduce=false;
		}else{
			typeIntroduce=true;
		}
    })
	$(":submit").click(function(){
		if(typeName==false || typeIntroduce==false){
			alert("请填写完整信息！");
			return false;
		}
	})
})
</script>
<body>
<center>
<h1>编辑主题信息</h1>
<c:if test="${type.typeId!=0}">
   <form:form action="${pageContext.request.contextPath }/type/updateType.do" method="post" modelAttribute="type">
        <form:hidden path="typeId"/>
        <table style="margin:50px auto;"> 
	      <tbody>
			   <tr><td>频道名称：</td><td><form:input path="typeName"/></td></tr>
			   <tr><td>频道介绍：</td><td><form:textarea path="typeIntroduce"/></td></tr>
	      </tbody>   
	      <tfoot>
	           <tr>
	               <td><input type="submit" value="保存" id="btnSure"/></td>
	               <td><a href="${pageContext.request.contextPath }/type/showAllType.do">
	                       <input type="button" value="取消" id="btnCancel"/>
	                   </a>
	               </td>
	           </tr>
	      </tfoot> 
	   </table>
    </form:form>
</c:if>
<c:if test="${type.typeId==0}">
    <form:form action="${pageContext.request.contextPath }/type/saveType.do" method="post" modelAttribute="type">
       <table style="margin:50px auto;"> 
	      <tbody>
			<tr><td>频道名称：</td><td><input type="text" name="typeName"/></td></tr>
			<tr><td>频道介绍：</td><td><textarea rows="" cols="" name="typeIntroduce"></textarea></td></tr>
	      </tbody>   
	      <tfoot>
	           <tr>
	               <td><input type="submit" value="保存" id="btnSure"/></td>
	               <td><a href="${pageContext.request.contextPath }/type/showAllType.do">
	                       <input type="button" value="取消" id="btnCancel"/>
	                   </a>
	               </td>
	           </tr>
	      </tfoot> 
	   </table>
    </form:form>
</c:if>            
</center>
</body>
</html>