package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) 
	throws UnsupportedEncodingException {
		String str = "大师兄";
		//encode方法会将str按照指定的字符集
		//(比如"utf-8")进行编码,然后将编码之后
		//得到的字节数组转换成相应的字符串
		//表示形式。
		String str2 = URLEncoder.encode(str,"utf-8");
		System.out.println(str2);
		String str3 = URLDecoder.decode(str2,"utf-8");
		System.out.println(str3);
	}

}
