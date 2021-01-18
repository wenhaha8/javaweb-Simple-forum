package cdu.wenhao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "permitUrls",
                value = "/login.jsp,/login.do,/validCode,/login,/register,/register.do,/register.jsp")})
public class LoginFilter implements Filter {
    String[] permitUrls=null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取permitUrls并按逗号分割为字符串数组
        permitUrls = filterConfig.getInitParameter("permitUrls").split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转servletRequest的类型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("LoginFilter:requestUrl="+request.getRequestURI());

        //检查当前请求的url是否是未登录也允许访问的url
        boolean flag=false;
        String a=request.getRequestURI();

        for(String url:permitUrls){
            //endsWith()-->测试此路径是否以给定的路径结束。
            if (request.getRequestURI().endsWith(url)){
                flag=true;
            }
        }

        if (flag||request.getSession().getAttribute("user")!=null||request.getSession().getAttribute("manager")!=null){
            /*chain.doFilter(request, response)
            过滤器的作用就是之一就是在用户的请求到达servlet之前，拦截下来做预处理，
            处理之后便执行chain.doFilter(request, response)这个方法，如果还有别
            的过滤器，那么将处理好的请求传给下个过滤器，依此类推，当所有的过滤器都
            把这个请求处理好了之后，再将处理完的请求发给servlet；如果就这一个过滤
            器，那么就将处理好的请求直接发给servlet。
            * */
            filterChain.doFilter(servletRequest,servletResponse);
        }else if(a.contains(".css") || a.contains(".js") || a.contains(".png")|| a.contains(".jpg")){
            //如果发现是图片，css或者js文件，直接放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            System.out.println("不允许未登录查看的o！");
            //跳转至登录页面
            request.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
