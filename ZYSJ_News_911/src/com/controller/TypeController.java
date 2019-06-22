package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Type;
import com.service.TypeService;

@Controller

@RequestMapping("/type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value = "/find")
	//@ResponseBody
	public String findAllType(HttpServletRequest request) {//List<Type> 
		List<Type> types= typeService.findAllType();
		HttpSession session = request.getSession();
		System.out.println(types);
		//return types;
		session.setAttribute("listType", types);
		return "redirect:/TypeChoose.jsp";
	}
	
//	@RequestMapping(value = "/addCookieType")
//	public String addCookieType(HttpServletRequest request,HttpServletResponse response) {
//		String typeId = request.getParameter("Type");
//		//int[] newTypeIds = new int[typeIds.length];
//		 Cookie[] cookies=  request.getCookies();
//			 String cookieValue = buildCookie(typeId,request);
//			  Cookie cookie = new Cookie("typeId",cookieValue);
//			  cookie.setMaxAge(30*24*60*60);
//			  cookie.setPath("/");
//		      response.addCookie(cookie);
//		      System.out.println(cookieValue);
//			return "redirect:/history.jsp";
//		
//	}
//
//	@RequestMapping(value = "/findTypeByCookies")
//	public String findTypeByCookies(HttpServletRequest request,HttpServletResponse response) {
//		Cookie[] cookies = request.getCookies();
//		List<Type> historyTypeList = new ArrayList<>();
//for (int i = 0; cookies != null && i < cookies.length; i++){
//			
//			//找到我们想要的cookie
//			if (cookies[i].getName().equals("typeId")){
//				String[] pids = cookies[i].getValue().split("-");
//				int[] newTypeIds = new int[pids.length];
//				Type type = new Type();
//				System.out.println(pids.toString());
//				//得到cookie中存在的id，展现浏览过的商品
//				for (int j=0;j<pids.length;j++){
//					newTypeIds[j]=Integer.valueOf(pids[j]); 
//					type = typeService.findByTypeId2(newTypeIds[j]);
//					historyTypeList.add(type);
//					System.out.println(newTypeIds[j]+":"+type);
//				}
//			}
//		}
//		System.out.println(historyTypeList);
//		request.setAttribute("historyTypeList", historyTypeList);
//		return null;
//		
//	}
//	
//	
//	
//	private String buildCookie(String id, HttpServletRequest request) {
//		 String productId = null;
//	        Cookie [] cookies = request.getCookies();
//	        for(int i = 0; cookies!=null && i < cookies.length; i++){
//	        	productId = cookies[i].getValue();
//	        }
//	          
//	        if(productId==null)
//	            return id;
//	          
//	        LinkedList<String> list = new LinkedList<String>(Arrays.asList(productId.split("-")));
//	        if(list.contains(id)){
//	            list.remove(id);
//	        }else{
//	            if(list.size()>=5){
//	                list.removeLast();
//	            }
//	        }
//	        list.addFirst(id);
//	          
//	        StringBuffer sb = new StringBuffer();
//	        for(String bid: list){
//	            sb.append(bid + "-");
//	        }
//	        return sb.deleteCharAt(sb.length()-1).toString();//删除最后多余 的一个逗号
//	    }
	
}
