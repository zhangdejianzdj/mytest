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
		//���ύ����ΪGETʱ����ԭʼ�����õ����ַ����������±��� 

		//�õ�ԭʼֵ
		String result = super.getParameter(name);
		
		//����ԭʼ ��getMethod�����õ��ύ��ʽ
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
