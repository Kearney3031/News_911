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
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/typeBrowse.js"></script> --%>
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
<a href="../front/user/login.jsp"><input type="button" id="login" value="登录"/></a>
<a href="../front/user/register.jsp"><input type="button" id="reg" value="注册"/></a>
</c:when>
<c:otherwise>
欢迎您,<a href="../front/user/myInformation.jsp">${user.userName}</a><input type='button' value='退出' id='quit' />
</c:otherwise>
</c:choose>
<h1>指尖资讯平台</h1>
<br><br>
<table border="0" cellpadding="10" cellspacing="0">
       <thead>
            <tr align="center">
                   <c:forEach items="${requestScope.types}" var="type">
                        <th><a href="${pageContext.request.contextPath}/news/findByPage.do?typeId=${type.typeId}" 
                               style="text-decoration: none;">${type.typeName }
                            </a>
                        </th>                   
                   </c:forEach>
            </tr>
       </thead>
</table>

<form action="${pageContext.request.contextPath}/news/showNewsByKey">
               关键字查询：<input type="text" name="keyValue"/>
</form>

<table border="0" width="100px">
      <tbody id="pfjtbody"></tbody>
</table>


<table border="0" width="100px">
        <tbody>
        
            <c:forEach items="${requestScope.typeNews }" var="mynews">
                    <tr>
                        <td><a href="../news/display.do?id=${mynews.newsId}" style="text-decoration: none;"> ${mynews.newsTitle}</a></td>
                    </tr>  
            
            </c:forEach>
          
            
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
                <form action="../user/findUserNewsByUserId.do" method="post">
				<input type="submit" value="查看收藏文章"/>
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
				热点新闻
				<div class="hot">
				<c:forEach items="${hot}" var="news">
                     <a href="../news/display.do?id=${news.newsId}"> ${news.newsTitle}</a><br>
                  
                       
                    
                             
                </c:forEach>
				
				
				
				</div>
				要闻推送
				<div class="point">
				<c:forEach items="${point}" var="news">
                      <a href="../news/display.do?id=${news.newsId}"> ${news.newsTitle}</a>
                  <br>
                       
                    
                              
                </c:forEach>
				
				
				</div>
				<input type="button" value="用户反馈" id="feedback" onclick="disp_prompt()" />
				<div  class="footer">
				关于我们<br>
				我们是911不服来干
				</div>

</body>
</html>