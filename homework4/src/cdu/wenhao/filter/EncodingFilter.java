package cdu.wenhao.filter;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
//        System.out.println("EncodeingFilter：requestURI= "+request.getRequestURI());
        resp.setContentType("text/html;charset=utf-8");
        if (request.getMethod().equals("GET")){
            request=new EncodingWrapper(request);
        }else {
            request.setCharacterEncoding("utf-8");
        }

        chain.doFilter(request,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
