package com.defender.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *  文件处理类
 * @author renHengYu
 *
 */
public class FileTools {
	
	public static String PATH_JSON = "D:/MyEclipse/WorkSpace/defender90/WebRoot/bookmark/fullcalendar-3.3.1/demos/json/";
	
	/**
	 * 保存到.json文件
	 * @param request
	 */
	public static void saveAsJson(HttpServletRequest request) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm");
		String date = format.format(new Date());
		
		String dePath = request.getSession().getServletContext().getContextPath();
		dePath += "/doc/json"+"/"+date+".json";
		
		try {
			FileWriter fw = new FileWriter(dePath);
			PrintWriter out = new PrintWriter(fw);
			
			out.write(dePath);
			out.println();
			fw.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 后续加入换行
	 * @param array
	 * @param path
	 */
	public static void saveAsJson(JSONArray array, String path) {
		if (array == null) {
			array = new JSONArray();
		}
		 FileWriter fwriter = null;
		 try {
			 File file = new File(path);
			 if (!file.getParentFile().exists()) {
				 file.getParentFile().mkdirs();
			 }
		  fwriter = new FileWriter(file);
		  fwriter.write(array.toString());
		 } catch (IOException ex) {
		  ex.printStackTrace();
		 } finally {
		  try {
		   fwriter.flush();
		   fwriter.close();
		  } catch (IOException ex) {
		   ex.printStackTrace();
		  }
		 }
	}
	
	
	public static JSONArray getAsJson(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return new JSONArray();
		}
		BufferedReader reader = null;
		String lastStr = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				lastStr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			return JSONArray.fromObject(lastStr);
		}
		return JSONArray.fromObject(lastStr);
		
	}
	
	static int countFiles = 0;
	static int countFolders = 0;
	
	/**
	 *  搜索文件
	 * @param folder 指定要搜索的文件
	 * @param keyWord  关键字
	 * @return
	 */
	public static File[] searchFile(File folder, final String keyWord) {
		File[] subFoldersFiles = folder.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if (pathname.isFile()) {
					countFiles++;
				} else {
					countFolders++;
				}
				
				if (pathname.isDirectory() || pathname.isFile() && pathname.getName().contains(keyWord)) {
					return true;
				}
				else {
					return false;
				}
			}});
			
			
		List<File> result = new ArrayList<File>();
		for (int i= 0; i<subFoldersFiles.length;i++) {
			if (subFoldersFiles[i].isFile()) {
				result.add(subFoldersFiles[i]);
			} else {
				File[] folderResult = searchFile(subFoldersFiles[i], keyWord);
				for (int j=0; j<folderResult.length; j++) {
					result.add(folderResult[j]);
				}
			}
		}
		
		File files [] = new File[result.size()];
		result.toArray(files);
		return files;
		
	}
	
}
