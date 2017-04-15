package com.tarena.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	/** 显示上载页面的 */
	@RequestMapping("/upload.form")
	public String uploadForm(){
		return "upload";
	}
	@RequestMapping("/save.form")
	public String save(
			MultipartFile image,
			String author,
			HttpServletRequest req)
		throws Exception{
		//检查表单数据：拒绝非图片数据
		//获取文件名和文件数据
		//保存到 /WEB-INF/images
		/*
		image.getName() 输入框的name属性值“image”
		image.getBytes() 全表上载的数据
		image.getContentType() 图片类型
		image.getSize() 图片大小
		image.getInputStream() 输入流 */ 
		String filename=image.getOriginalFilename();
		String type = image.getContentType();
		if(! types.contains(type)){
			req.setAttribute("message", "不是图片");
			return "upload";
		}
		// abc.png ->  abc_时间.png
		String name = filename.substring(0, 
					filename.lastIndexOf(".")); 
		String ext = filename.substring(
				filename.lastIndexOf("."));
		filename = name+System.nanoTime()+ext;
		String path = "/WEB-INF/photo";
		// path = d:\......\WEB-INF\photo
		path = req.getSession()
		  .getServletContext().getRealPath(path);
		File dir = new File(path);
		if(! dir.exists()){
			dir.mkdir();
		}
		File imageFile = new File(dir, filename);
		FileOutputStream out = 
			new FileOutputStream(imageFile);
		out.write(image.getBytes());
		out.close();
		req.setAttribute("message", 
				"谢谢"+author);
		return "upload";
	}
	private Set<String> types;
	public UploadController() {
		types = new HashSet<String>();
		types.add("image/png");
		types.add("image/jpeg");
		types.add("image/gif");
	}
	
	@ExceptionHandler
	public String execute(
			HttpServletRequest  req,
			Exception e) throws Exception{
		if(e instanceof MaxUploadSizeExceededException){
			req.setAttribute("message", "文件大了");
			return "upload";
		}
		if(e instanceof IOException ){
			req.setAttribute("message", "保存失败！");
			return "upload";
		}
		throw e;
	}
}












