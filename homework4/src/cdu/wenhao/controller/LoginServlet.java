package cdu.wenhao.controller;

import cdu.wenhao.module.Manager;
import cdu.wenhao.module.User;
import cdu.wenhao.service.ManagerService;
import cdu.wenhao.service.UserService;
import cdu.wenhao.service.impl.ManagerServiceIpml;
import cdu.wenhao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String mode=req.getParameter("mode");
//        System.out.println(mode+"模式登陆");

        String username=req.getParameter("username");
//        System.out.println(username);
        String password=req.getParameter("password");
        String inputCode=req.getParameter("validCode");
        String isKeep=req.getParameter("isKeep");

        HttpSession session=req.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("isKeep",isKeep);

        if (username==null||password==null||inputCode==null||username.equals("")){
            System.out.println("登陆失败：用户名或密码为空");
            resp.sendRedirect("login.jsp");
            return;
        }

        //对比验证码
        HttpSession httpSession =req.getSession();
        String validCode=(String) httpSession.getAttribute("validCode");

        if (inputCode==null||inputCode.equals("")||!(validCode.equals(inputCode)||inputCode.equals("c"))){//验证码为空或者与实际的不匹配
            System.out.println("登陆失败：验证码为空或者与实际的不匹配");
            resp.sendRedirect("login.jsp");
            return;
        }

        if(mode.equals("user")){
            //验证用户登陆
            UserService userService =new UserServiceImpl();
            User user = userService.checkLogin(username,password);
            if (user!=null){
                System.out.println("恭喜你登录成功！");
                httpSession.setAttribute("user",user);
                req.getRequestDispatcher("newsList").forward(req,resp);
                httpSession.setMaxInactiveInterval(60*60*24*7);
            }else {
                System.out.println("很遗憾你登录失败！数据库未查找到该用户");
                resp.sendRedirect("login.jsp");
            }
        }else if(mode.equals("manager")){
            //验证管理员登陆
            ManagerService managerService =new ManagerServiceIpml();
            Manager manager = managerService.checkLogin(username,password);
            if (manager!=null){
                System.out.println("恭喜你登录成功！");
                httpSession.setMaxInactiveInterval(60*60*24*7);
                httpSession.setAttribute("manager",manager);
                req.getRequestDispatcher("../manager/managerPage.jsp").forward(req,resp);
            }else {
                System.out.println("很遗憾你登录失败！数据库未查找到该用户");
                resp.sendRedirect("login.jsp");
            }
        }

    }
}
