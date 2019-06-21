<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加商品</h1>
<form action="../news/NewsUpload.do" method="post" enctype="multipart/form-data">
            <table  border="0" id="table">
                <tr>
                    <td width="5%"></td>
                    <td width="90%">    
                        <table  border="1" id="table">
                            <tr >
                                <td >新闻题目</td> <td><input type="text" name="newstitle"></td>
                                <td>新闻类别</td> <td>
                                <c:forEach items="${list}" var="type">
    <label><input type="radio" name="newstype" value="${type.typeId}"  />
${type.typeName} 
  </label>
  </c:forEach>
  </td>
                            </tr>
                            
                            <tr>
                                <td>新闻插图</td> <td><input type="file" name="newsimg" /></td>
                                
                            </tr>
                           
                            
                           
                            
 
                        </table>
                    </td>
                    <td width="5%"></td>
                </tr>
                <tr>
                    <td> </td>
                    <td>
                        <div align="center" style="width:80%">  
                            新闻内容: <textarea id="newsEditor" name="newscontent" style=" height: 100px;width: 300px" ></textarea>  
                            <br/>  
                            <input type="submit" value="发 布">  
                            
                        </div>
 
                    </td>
                    <td> </td>
                </tr>
            </table>   
        </form>
</body>
</html>