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
		
		//解决POST方式的中文乱码问题
		request.setCharacterEncoding("UTF-8");
		
		//响应信息的中文乱码问题
		response.setContentType("text/html; charset=UTF-8");
		
		//解决GET方式的中文乱码问题
		//创建一个包装类对象（增强Request对象的getParameter方法）
		HttpServletRequest req = new MyRequest( (HttpServletRequest)request );
		
		//放行，把增强后的包装类对象放行，这样在请求到达目标Servlet时，得到的就是增 强后的Request对象
		chain.doFilter(req, response);
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
