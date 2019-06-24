 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>#form_top{display:block; bottom:3px; right:3px; position:fixed;font-size: 24px;}.top_img{ width: 40px; height:40px; cursor: pointer; } </style><a id="_top"></a>
<link rel="stylesheet" type="text/css" href="../css/base.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
 <script type="text/javascript" src="../js/jq02.js"></script>
 <script type="text/javascript" src="../js/test.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/typeBrowse.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/findNewsByKeyValue.js"></script>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">

 $(function(){

	 $(".coupletbox").clonefn({

		    cloneto:false,//是否允许克隆

			initial:"top",//初始位置top或down

			closeBtn:".closeBtn",//关闭按钮

			speed:2000,//动画速度

			easing:"easeInOutBack",//扩展动画，是基于jQuery Easing v1.3官方下载地址http://gsgd.co.uk/sandbox/jquery/easing/

			zIndex:10000000000000 //层

		 });

	 });

</script>
</head>
<body style="min-height: 1080px;width: 70%;margin: auto;">
	<div style="margin-bottom: 15px;height: 70px;">
		<h1 style="float: left;">指尖资讯平台
		<br>公告<br><c:forEach items="${notice}" var="n">
			          ${n.noticeContent}
			      
			                   
			    </c:forEach></h1>
		
		
		<div style="float: right;margin-top: 30px;" class="bdzx">
		这里是<%=request.getSession().getAttribute("country") %><%=request.getSession().getAttribute("pro") %><%=request.getSession().getAttribute("city") %><br>
		<%=request.getSession().getAttribute("time") %><br>
		<%=request.getSession().getAttribute("today") %><br>
		<%=request.getSession().getAttribute("now") %><br>
		</div>
	</div>

	<c:choose>
		<c:when test="${user==null}">
		<a href="../front/user/login.jsp"><input type="button" id="login" value="登录"/></a>
		<a href="../front/user/register.jsp"><input type="button" id="reg" value="注册"/></a>
		</c:when>
		<c:otherwise>
		欢迎您,<a href="../front/user/myInformation.jsp">${user.userName}</a><input type='button' value='退出' id='quit' />
		<input type="button" value="用户反馈" id="feedback" onclick="disp_prompt()" style="margin-top: 20px;margin-bottom: 20px;">
		</c:otherwise>
	</c:choose>

	<div class="newscon" style="min-height: 700px;margin-top: 20px;">
		<!-- 左 -->
		<div style="float: left;width: 25%;">
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

		</div>

		<!-- 右 -->
		<div style="float: right;width: 20%;margin-left: 20px;">
			<form action="../type/find.do" method="post">
			<input type="submit" value="类别订阅"/>
			</form>

			热点新闻
			<div class="hot" style="margin-top: 20px;margin-bottom: 20px;">
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
		</div>

		<!-- 中 -->
		<div style="width: 50%;float: right;">
		      <table border="0" cellpadding="10" cellspacing="0">
                 <thead>
                        <tr align="center"><!-- 展示所有主题类型 -->
                             <c:forEach items="${requestScope.types}" var="type">
                               <th>
                                   <a href="${pageContext.request.contextPath}/news/showNewsByType.do?typeId=${type.typeId}&&page=1" 
                                      style="text-decoration: none;" class="typeBrowse">${type.typeName }
                                   </a>  
                               </th>                   
                             </c:forEach>
                        </tr>
                 </thead>
              </table>

              <form action="${pageContext.request.contextPath}/news/showNewsByKey.do" method="post"> 
                                 关键字查询： <input type="text" name="newsTitle"/>
                              <input type="hidden" name="page" value="1">
                              <input type="submit" value="查询"/>
              </form>
              
              <table border="0" width="100px">
                 <tbody>
                     <!-- 展示关键字查询到的新闻 -->
                     <c:forEach items="${requestScope.KeyNews }" var="mynews">
                         <tr>
                            <td>${mynews.newsTitle}</td>
                         </tr>  
                     </c:forEach>
                 </tbody>
              </table>
              
             <table border="0" width="100px">
                <tbody>
                    <!-- 展示分类查询到的新闻 -->
                   <c:forEach items="${requestScope.mynews }" var="typenews">
                       <tr>
                          <td>${typenews.newsTitle}</td>
                       </tr>  
                   </c:forEach>
                </tbody>
            </table>
            
			<table border="0" width="100px" style="">
		        <tbody>
		      		<c:forEach items="${list}" var="news">
		                <tr>
		                 <td>  <a href="../news/display.do?id=${news.newsId}"> ${news.newsTitle}</a></td>
		              
		                   
		                </tr>   
		                <tr><td><hr/></td></tr>             
		            </c:forEach>
		        </tbody>
			</table>

			<div id="pages" style="margin-bottom: 20px;">
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

		    <div class="video" >
				<c:forEach items="${list2}" var="video">
		              <a href="../video/display.do?id=${video.videoId}"> ${video.videoRealName}</a>
		          
		            <hr/>            
		        </c:forEach>
			</div>
		</div>
    </div>
			
			<div class="coupletbox" id="advert1"  style="width:150px; height:300px; background:url('${pageContext.request.contextPath.concat(advert1.advertImg)}');">
  <a href="#" class="closeBtn" id="btnxx" title="关闭">&times;关闭</a>
	<h1 id="link1" style="display:none;">${advert1.advertLink}</h1>
</div>
<div class="coupletbox" id="advert2" style="width:150px; height:300px; background:url('${pageContext.request.contextPath.concat(advert2.advertImg)}');">
  <a href="#" class="closeBtn" id="btnxx" title="关闭">&times;关闭</a>
<h1 id="link2" style="display:none;">${advert2.advertLink}</h1>
</div>		
	<div style="width: 100%;text-align: center;margin-top: 30px;" class="footer">
		关于我们<br>
		我们是911不服来干
	</div>
	<div id="form_top"><a href="#_top" title="回到顶部">置顶<div class="top_img"></div></a></div>
	

</body>
</html>