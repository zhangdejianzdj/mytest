package cn.itcast.demo04;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class MyRequest extends HttpServletRequestWrapper {

	public MyRequest(HttpServletRequest request) {
		super(request);
		
	}

//	@Override
//	public String getParameter(String name) {
//		
//		String step = super.getParameter(name);
//		
//		if ("GET".equals(super.getMethod())) {
//			
//			try {
//				if (step != null) {
//					
//					step = new String(step.getBytes("iso-8859-1"),"utf-8");
//				}
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return step;
//	}

	@Override
	public String getParameter( String name ){
		//当提交方法为GET时，对原始方法得到的字符串进行重新编码 

		//得到原始值
		String result = super.getParameter(name);
		
		//调用原始 的getMethod方法得到提交方式
		if( "GET".equals( super.getMethod() ) ){
			System.out.println(11);
			try {
				if( result != null ){
					result = new String( result.getBytes("utf-8") , "UTF-8" );
					System.out.println(result);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
