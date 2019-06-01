package com.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;

public class webMes    {

   
    

	
   
    
   public List<String> getAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {  
	   	List<String> list=new ArrayList<>();
	   	
	   	Document doc1 = Jsoup.connect("http://ip.taobao.com/service/getIpInfo2.php?ip=myip").get(); 
		 String body=doc1.body().text().substring(24);
		 System.out.println(body);
		 int aa=body.indexOf('"');
		 System.out.println(aa);
		 String ip=body.substring(0, aa);
		
	      // 创建 GeoLite2 数据库     /usr/local/kobe/apache-tomcat-8.0.53/webapps/MesTest
	   	///Users/mac126/db/GeoLite2-City.mmdb
	      File database = new File("/Users/mac126/Desktop/repository4/ZYSJ_News_911/WebContent/front/user/GeoLite2-City.mmdb"); 
	      System.out.println(database.getName());
	      // 读取数据库内容 
	      DatabaseReader reader=null;      
	      InetAddress ipAddress=null;  
	      CityResponse response=null;
	     
	      try {
	       reader = new DatabaseReader.Builder(database).build();       
	       ipAddress = InetAddress.getByName(ip);  
	        response = reader.city(ipAddress);
	       
	      }
	      catch(Exception e) {
	    	  req.setAttribute("ip", ip);
	    	  req.setAttribute("file", database.getName());
	    	  req.setAttribute("path", database.getPath());
	    	  req.setAttribute("country", response.getCountry().getName());
	    	 req.getRequestDispatcher("fail.jsp").forward(req, res);
	      }
	      req.setAttribute("ip", ip);
	     
	      // 获取查询结果      
	      // 获取国家信息
	      Country country = response.getCountry();
	      System.out.println(country.getIsoCode());               // 'CN'
	      System.out.println(country.getName());                  // 'China'
	      System.out.println(country.getNames().get("zh-CN"));    // '中国'
	      list.add(country.getNames().get("zh-CN"));
	      // 获取省份
	      Subdivision subdivision = response.getMostSpecificSubdivision();
	      System.out.println(subdivision.getName());   // 'Guangxi Zhuangzu Zizhiqu'
	      System.out.println(subdivision.getIsoCode()); // '45'
	      System.out.println(subdivision.getNames().get("zh-CN")); // '广西壮族自治区'
	      list.add(subdivision.getNames().get("zh-CN"));
	     
	      // 获取城市
	      City city = response.getCity();
	      System.out.println(city.getName()); // 'Nanning'
	      Postal postal = response.getPostal();
	      System.out.println(postal.getCode()); // 'null'
	      System.out.println(city.getNames().get("zh-CN")); // '南宁'
	    
	      
	      list.add(city.getNames().get("zh-CN"));
	      Location location = response.getLocation();
	      System.out.println(location.getLatitude());  // 22.8167 纬度
	      System.out.println(location.getLongitude()); // 108.3167 精度
	      
	        try {
	            
	           
	            Document doc = Jsoup.connect("https://www.tianqi.com/"+city.getName().toLowerCase()).timeout(30000).get();
	            Elements links = doc.select(".week");
	            Elements a=doc.select(".now");
	            Elements b=doc.select(".now").next();
	            
//	            for(int i=1;i<links.size();i++) {
//	               
//
//	             boolean ab= a.add(links.eq(i).text());
//	               
//
//	            }
	            System.out.println("时间、节气："+links.eq(0).text());
	            list.add("时间、节气："+links.eq(0).text());
	            
	           
	   	 
	            System.out.println("现在温度："+a.eq(0).text());
	            list.add("现在温度："+a.eq(0).text());
	            System.out.println("今日温度："+b.eq(0).text());
	            list.add("今日温度："+b.eq(0).text());
	            
	            
	        }
	        catch (Exception e){e.printStackTrace();}


	      return list;
	}  

    
}
