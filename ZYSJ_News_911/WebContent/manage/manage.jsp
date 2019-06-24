<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="${pageContext.request.contextPath }/Style/manage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/manage.js"></script>
<body>

 



 	<div class="header">
	        <div class="header_logo">
	        	指尖新闻后台管理系统
	        </div>
    </div>
    <div class="wrap">
        <ul class="siderbar">
        	<li><span>新闻管理</span>
	        	<ul>
	               <li><a href="${pageContext.request.contextPath }/news/findAll.do" target="mainFrame">审查新闻</a></li>
	        	</ul>
	        </li>
	        <li><span>公告管理</span>
	        	<ul>
	               <li><a href="updateNotice.jsp" target="mainFrame">修改公告</a></li>
	        	</ul>
	        </li>
	        <li><span>主题管理</span>
	            <ul>
	               <li><a href="${pageContext.request.contextPath }/type/inputInsert.do" target="mainFrame">添加新主题</a></li>
	               <li><a href="${pageContext.request.contextPath }/type/showAllType.do" target="mainFrame">管理主题信息</a></li>
	            </ul>
	        </li>
	        <li><span>话题管理</span>
	            <ul>
	                <li><a href="${pageContext.request.contextPath }/topic/showAllTopic.do" target="mainFrame">管理话题信息</a></li>
	            </ul>
	        </li>
	        <li><span>用户管理</span>
	            <ul>
	                <li><a href="${pageContext.request.contextPath }/user/showAllUser.do" target="mainFrame">用户信息管理</a></li>
	                 <li><a href="${pageContext.request.contextPath }/feedback/findAll.do"  target="mainFrame">查看反馈</a></li>
	        	</ul>
	        </li>
	        <li><span>广告管理</span>
	            <ul>
	               <li><a href="addAdvert.jsp" target="mainFrame">添加新广告</a></li>
	               <li><a href="${pageContext.request.contextPath }/advert/findAll.do" target="mainFrame">管理广告信息</a></li>
	            </ul>
	        </li>
	        <li><span>商品管理</span>
	            <ul>
	               <li><a href="addGoods.jsp" target="mainFrame">添加新商品</a></li>
	               <li><a href="${pageContext.request.contextPath }/goods/findAll1.do" target="mainFrame">管理商品信息</a></li>
	            </ul>
	        </li>
	        
	        <li><span>系统功能操作</span>
	        	<ul>
	               
	                <li><a href="${pageContext.request.contextPath }/manage/logout.jsp">安全退出</a></li>
	        	</ul>
	        </li>
	        
        </ul>
       	<div class="content">
              	<iframe width="99%" height="100%" name="mainFrame" frameborder="0" ></iframe>
        </div>
   </div>
        
   <div class="footer"></div>
   

</body>
</html>