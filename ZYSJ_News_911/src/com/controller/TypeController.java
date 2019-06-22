package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//把types集合转换成成json字符串，便于前台显示
		@RequestMapping("/showAllTypeToFront")
		@ResponseBody
		public List<Type> showAllTypeToFront(){
			List<Type> types=typeService.findAllTypeToFront();
			return types;
		}
		
		//查询出所有type
		@RequestMapping("/showAllType")
		public String showAllType(@RequestParam(value="pageNumber",required=false)Integer pageNumber,Map<String, Object> map) {
			int pageNumberTemp=1;//第一次访问页面没有传递参数，默认为1，且pageNumber默认为0
			int pageSize=4;
			if(pageNumber!=null) {
				pageNumberTemp=pageNumber;
			}
			map.put("pageBean", typeService.selTypeByPage(pageNumberTemp, pageSize));
			return "manage/showType";
		}
		
		//新增时，页面使用了springMVC标签，必须在请求域中放入一个modelAttribute对象，不然页面报错
		@RequestMapping(value = "/inputInsert",method = RequestMethod.GET)
		public String inputInsert(Map<String, Object> map) {
			System.out.println("请求域中必须要有一个modelAttribute，即使是空的");
			map.put("type", new Type());
			return "manage/inputType";
		}
		
		//修改时，用于表单信息回显
		@RequestMapping(value = "/inputUpdate",method = RequestMethod.GET)
		public String inputUpdate(@RequestParam("typeId")Integer typeId,Map<String, Object> map) {
			System.out.println("表单回显");
			map.put("type",typeService.findByTypeId2(typeId));
			return "manage/inputType";
		}
		
		//增加类型
		@RequestMapping(value ="/saveType",method = RequestMethod.POST)
		public String save(Type type){
			int flag=typeService.addType(type);
			if(flag>0) {
				return "redirect:/type/showAllType.do";
			}else {
				return "redirect:/manage/inputType.jsp";
			}
		}
		
		//修改类型
		@RequestMapping(value = "/updateType",method = RequestMethod.POST)
		public String update(Type type){
			typeService.updType(type);
			return "redirect:/type/showAllType.do";
		}

		
		//删除类型
		@RequestMapping("/deleteType")
		@ResponseBody
		public String deleteType(@RequestParam("typeId") int typeId,OutputStream os) {
			try {
				typeService.delType(typeId);
				os.write("1".getBytes("UTF-8"));//返回1代表删除成功
			} catch (Exception e) {
				   e.printStackTrace();
				try {
					os.write("0".getBytes("UTF-8"));//返回0代表删除失败
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		}
	
}
