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
<form action="../goods/addGoods.do" method="post" enctype="multipart/form-data">
            <table  border="0" id="table">
                <tr>
                    <td width="5%"></td>
                    <td width="90%">    
                        <table  border="1" id="table">
                            <tr>
                                <td>商品名称</td> <td><input type="text" name="name"></td>
                                
                            </tr>
                             <tr>
                                <td>商品价格</td> <td><input type="text" name="price"></td>
                                
                            </tr>
                            <tr>
                                <td>商品图片</td> <td><input type="file" name="goodsimg" /></td>
                                
                            </tr>
                           
                            
                           
                            
 
                        </table>
                    </td>
                    <td width="5%"></td>
                </tr>
                <tr>
                    <td> </td>
                    <td>
                        <div align="center" style="width:80%">  
                            商品描述: <textarea id="goodinfo" name="goodinfo" style=" height: 100px;width: 300px" ></textarea>  
                            <br/>  
                            <input type="submit" value="添加">  
                            
                        </div>
 
                    </td>
                    <td> </td>
                </tr>
            </table>   
        </form>
</body>
</html>