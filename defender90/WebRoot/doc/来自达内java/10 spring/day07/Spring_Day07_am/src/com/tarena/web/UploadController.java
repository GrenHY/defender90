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
	
	/** ��ʾ����ҳ��� */
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
		//�������ݣ��ܾ���ͼƬ����
		//��ȡ�ļ������ļ�����
		//���浽 /WEB-INF/images
		/*
		image.getName() ������name����ֵ��image��
		image.getBytes() ȫ�����ص�����
		image.getContentType() ͼƬ����
		image.getSize() ͼƬ��С
		image.getInputStream() ������ */ 
		String filename=image.getOriginalFilename();
		String type = image.getContentType();
		if(! types.contains(type)){
			req.setAttribute("message", "����ͼƬ");
			return "upload";
		}
		// abc.png ->  abc_ʱ��.png
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
				"лл"+author);
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
			req.setAttribute("message", "�ļ�����");
			return "upload";
		}
		if(e instanceof IOException ){
			req.setAttribute("message", "����ʧ�ܣ�");
			return "upload";
		}
		throw e;
	}
}












