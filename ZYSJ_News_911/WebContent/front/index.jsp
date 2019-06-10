<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.6.2.js"></script>
 <script type="text/javascript" src="../js/jq02.js"></script>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<div class="bdzx">
这里是<%=request.getSession().getAttribute("country") %><%=request.getSession().getAttribute("pro") %><%=request.getSession().getAttribute("city") %><br>
<%=request.getSession().getAttribute("time") %><br>
<%=request.getSession().getAttribute("today") %><br>
<%=request.getSession().getAttribute("now") %><br>
</div>
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
<h1>指尖资讯平台</h1>


<table border="0" width="100px">
        <tbody>
          
            
                <c:forEach items="${list}" var="news">
                    <tr>
                     <td>  <a href="../news/display.do?id=${news.newsId}"> ${news.newsTitle}</a></td>
                  
                       
                    </tr>   
                    <tr><td><hr/></td></tr>             
                </c:forEach>
           
        </tbody>
    </table>




 <div id="pages">
 				<c:choose>
                <c:when test="${page==1}">
        	        <a href="#">上一页</a>
        	        </c:when>
        	        <c:otherwise>
        	         <a href="../news/findByPage.do?page=${page-1}" >上一页</a>
        	        </c:otherwise>
        	        </c:choose>
        	       <c:forEach  begin="1" end="${totalPage}" var="k" >
        	  
                  	<c:choose>
                  	<c:when test="${k==1}">
                 
                    <a href="../news/findByPage.do?page=${k}" class="current_page">1</a>
                  </c:when>
                  <c:otherwise>
                 
                  <a href="../news/findByPage.do?page=${k}">${k}</a>
                  </c:otherwise>
                  </c:choose>
                    </c:forEach>
                    <c:choose>
                   <c:when test="${page==totalPage}">
        	        <a href="#">下一页</a>
        	        </c:when>
        	        <c:otherwise>     
        	         <a href="../news/findByPage.do?page=${page+1}" >下一页</a>
        	        </c:otherwise>
        	        </c:choose>
                </div>
                </div>
                <form action="findNewsByCookies.do" method="post">
				<input type="submit" value="查看浏览历史"/>
				</form>

				<div class="topic" >
				<c:forEach items="${list1}" var="topic">
                      <a href="../topic/display.do?id=${topic.topicId}"> ${topic.topicName}</a>
                  
                       
                    
                    <hr/>            
                </c:forEach>
				
				</div>
								<div class="video" >
				<c:forEach items="${list2}" var="video">
                      <a href="../video/display.do?id=${video.videoId}"> ${video.videoRealName}</a>
                  
                       
                    
                    <hr/>            
                </c:forEach>
				
				</div>

				<form action="../type/find.do" method="post">
				<input type="submit" value="类别订阅"/>
				</form>
				<div  class="footer">
				关于我们<br>
				我们是911不服来干
				</div>

</body>
</html>