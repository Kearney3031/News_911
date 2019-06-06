<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-1.6.2.js"></script>
 <script type="text/javascript" src="../../js/indexs.js"></script>
</head>
<body>
<c:forEach items="" >

</c:forEach>

 <div id="pages">
 
                <c:if test="page==1">
        	        <a href="#">上一页</a>
        	        </c:if>
        	        <c:else>
        	         <a href="findCost?page=<s:property value='page-1'/>" >上一页</a>
        	        </c:else>
        	        <s:iterator begin="1" end="totalPage" var="k">
                  	<s:if test="#k==page">
                    <a href="findCost?page=<s:property value='#k'/>" class="current_page">1</a>
                  </s:if>
                  <s:else>
                  <a href="findCost?page=<s:property value='#k'/>"></a>
                  </s:else>
                    </s:iterator>
                   <s:if test="page==totalPage">
        	        <a href="#">上一页</a>
        	        </s:if>
        	        <s:else>
        	         <a href="findCost?page=<s:property value='page+1'/>" >下一页</a>
        	        </s:else>
                </div>
</body>
</html>