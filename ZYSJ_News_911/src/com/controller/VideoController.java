package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadVideo(@RequestParam(value = "upload", required = false) MultipartFile file,
			HttpServletRequest request) {
Video v=new Video();

		String path = request.getServletContext().getRealPath("/video");
	System.out.println(path);
		String uploadFileName1 = System.currentTimeMillis() + file.getName();
		File file11 = new File(path, uploadFileName1 + ".mp4");
		v.setVideoPath( path +"/"+ uploadFileName1 + ".mp4");
		v.setVideoLike(0);
		v.setVideoRealName(file.getOriginalFilename());
		v.setVideoName(uploadFileName1 + ".mp4");
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
	public String  display(int id) {
		
		 Video v=videoService.findVideoById(id);
		String path= "/ZYSJ_News_911/video/"+v.getVideoName();
		return "redirect:/front/video/show.html?fname=" +path;
	}
	

	
	
}
