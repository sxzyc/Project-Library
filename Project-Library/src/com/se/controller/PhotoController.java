package com.se.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.se.util.FileNameUtil;

@Controller
@RequestMapping("/Photo")
public class PhotoController {
	@ResponseBody
	@RequestMapping("/load")
	public Map<String, Object> Photo(@RequestParam MultipartFile uploadPhoto, HttpServletRequest request) {
		String saveFileName= FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(uploadPhoto.getOriginalFilename());
        System.out.println(saveFileName);
        String path=request.getSession().getServletContext().getRealPath("/upload/");
        //File path=new File("E:\\java3-wuye\\Book-System3.4\\WebContent\\upload");
        System.out.println(path);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("saveFileName", saveFileName);
        try {
        	uploadPhoto.transferTo(new File(path+saveFileName));
        	//uploadPhoto.transferTo(new File(path+"\\"+saveFileName));
            //myfile.transferTo(new File(path+saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
       // request.setAttribute("imgname",saveFileName);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/Photodelete")
	public void Photodelete(String filepath,HttpServletRequest request) {
		String path=request.getSession().getServletContext().getRealPath("/upload/");
		FileNameUtil.deleteFile(path+filepath);
		System.out.println(path+filepath);
	}
}
