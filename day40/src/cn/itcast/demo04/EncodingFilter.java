package cn.itcast.demo04;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class EncodingFilter implements Filter {

    public EncodingFilter() {
       
    }

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
//		
//		response.setContentType("text/html;charset=utf-8");
//		
//		HttpServletRequest req = new MyRequest((HttpServletRequest)request);
//		
//		chain.doFilter(request, response);
		
		//���POST��ʽ��������������
		request.setCharacterEncoding("UTF-8");
		
		//��Ӧ��Ϣ��������������
		response.setContentType("text/html; charset=UTF-8");
		
		//���GET��ʽ��������������
		//����һ����װ�������ǿRequest�����getParameter������
		HttpServletRequest req = new MyRequest( (HttpServletRequest)request );
		
		//���У�����ǿ��İ�װ�������У����������󵽴�Ŀ��Servletʱ���õ��ľ����� ǿ���Request����
		chain.doFilter(req, response);
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
