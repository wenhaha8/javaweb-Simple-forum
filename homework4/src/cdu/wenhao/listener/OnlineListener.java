package cdu.wenhao.listener;

import cdu.wenhao.module.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class OnlineListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    List<User> onlineUser;//在线的所有用户

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        onlineUser = new ArrayList<>();
        sce.getServletContext().setAttribute("online",onlineUser);//保存在会话中
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //如果会话中新加入了一个变量，看这个变量名是不是user，若是，则加入到用户列表中
        if (se.getName().equals("user")){
            onlineUser.add((User) se.getValue());
        }
        se.getSession().getServletContext().setAttribute("online",onlineUser);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        //如果会话中移除了变量且名是user，则删除用户列表中对应的user
        if (se.getName().equals("user")){
            onlineUser.remove((User) se.getValue());
        }
        se.getSession().getServletContext().setAttribute("online",onlineUser);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }


}
