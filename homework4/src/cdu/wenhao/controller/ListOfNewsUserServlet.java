package cdu.wenhao.controller;

import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;
import cdu.wenhao.service.UserService;
import cdu.wenhao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/newsList")
public class ListOfNewsUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService =new UserServiceImpl();
        List<News> newsList = userService.findAllNews();
        req.setAttribute("newsList",newsList);

        List<User> userList = userService.findAll();
        req.setAttribute("userList",userList);

        List<Discussion> discussionList = userService.findAllDiscussion();
        req.setAttribute("discussionList",discussionList);
        //测试代码
//        PrintWriter out=resp.getWriter();
//        out.println("<h1>测试点1</h1>");
        req.getRequestDispatcher("newsList.jsp").forward(req,resp);
    }
}
