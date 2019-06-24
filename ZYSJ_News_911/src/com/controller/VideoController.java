package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.model.Collect;
import com.model.News;

import com.util.getIPAddr;
import com.util.webMes;

import com.model.Subscribe;
import com.model.Topic;
import com.model.Type;
import com.model.User;
import com.model.Video;
import com.service.UserService;
import com.service.VideoService;
import com.util.CustomSystemUtil;
import com.util.RandomNum;
import com.util.sendemail;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private  VideoService videoService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadVideo(@RequestParam(value = "upload", required = false) MultipartFile file,
			HttpServletRequest request) {
Video v=new Video();
	User u=(User) request.getSession().getAttribute("user");
		String path = request.getServletContext().getRealPath("/video");
	System.out.println(path);
		String uploadFileName1 = System.currentTimeMillis() + file.getName();
		File file11 = new File(path, uploadFileName1 + ".mp4");
		v.setVideoPath( path +"/"+ uploadFileName1 + ".mp4");
		v.setVideoLike(0);
		v.setUserId(u.getUserId());
		
		v.setVideoRealName(file.getOriginalFilename());
		v.setVideoName(uploadFileName1 + ".mp4");
		v.setdTimes(0);
		videoService.addVideo(v);
		try {
			file.transferTo(file11);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ModelAndView mav=new
		// ModelAndView("/show.html?fname="+uploadFileName1+".mp4");
//				mav.addObject("fname", uploadFileName1+".mp4");
		// mav.getModel().put("fname", uploadFileName1+".mp4");
		return "redirect:/front/user/editor.jsp";
		
//		return "redirect:/file/show.html?fname=" + uploadFileName1 + ".mp4";

	}

	@RequestMapping(value = "/display")
	public String  display(int id,HttpServletRequest req) {
		User u=(User) req.getSession().getAttribute("user");
		userService.addUserScore(u.getUserId());
		u.setScore(u.getScore()+1);
		req.getSession().setAttribute("user", u);
		 Video v=videoService.findVideoById(id);
		 req.getSession().setAttribute("video", v);
		String path= "/ZYSJ_News_911/video/"+v.getVideoName();
		req.getSession().setAttribute("path", path);
		return "redirect:/front/video/display.jsp";
		
	} 
	@RequestMapping(value = "/addLike")
	@ResponseBody
	public void  addLike(int id,HttpServletRequest req) {
		videoService.addLike(id);
		
	} 
	@RequestMapping(value="/download",method=RequestMethod.POST)
	
    public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path1=request.getServletContext().getRealPath("/video");
       Video v=(Video) request.getSession().getAttribute("video");
       videoService.addDTimes(v.getVideoId());
       String filename=v.getVideoName();
        System.out.println(filename);
        String path = v.getVideoPath();  
        System.out.println(path);
//        //获取输入流  
//        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
//        //转码，免得文件名中文乱码  
//        filename = URLEncoder.encode(filename,"UTF-8");  
//        //设置文件下载头  
//        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
//        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
//        response.setContentType("multipart/form-data");   
//        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
//        int len = 0;  
//        while((len = bis.read()) != -1){  
//            out.write(len);  
//            out.flush();  
//        }  
//        out.close();  
//    }
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data"); 
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024]; 
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len = in.read(buffer)) > 0){
        	out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
       
    }

	@RequestMapping(value = "/All")
	public String  all(HttpServletRequest req) {
		
		User u=(User) req.getSession().getAttribute("user");
		
		
		req.getSession().setAttribute("videoList",videoService.All(u.getUserId()));
		req.getSession().setAttribute("temp", 2);
		return "redirect:/front/user/editor.jsp";
		
		
	} 

	
}
