package cdu.wenhao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class EncodingWrapper extends HttpServletRequestWrapper {

    public EncodingWrapper(HttpServletRequest request){
        super(request);
    }

    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        if (value!=null){
            try{
                //解决URL中文乱码问题
                byte[] bytes = value.getBytes("ISO-8859-1");
            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

}
