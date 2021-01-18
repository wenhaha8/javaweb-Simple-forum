package cdu.wenhao.controller;

import cdu.wenhao.module.User;
import cdu.wenhao.service.UserService;
import cdu.wenhao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;

//管理候选人（查看候选人列表）
@WebServlet("/user/mod")
public class ModifyUserBeforeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("id");
        int id = (sId==null||sId.equals(""))?0:Integer.parseInt(sId);
        PrintWriter out =resp.getWriter();

        UserService userService =new UserServiceImpl();
        User user =userService.get(id);
        if (user!=null){
            req.setAttribute("user",user);
            req.getRequestDispatcher("modifyUser.jsp").forward(req,resp);
        }else {
            out.println("<script>alert('修改用户失败：id: "+id+"');window.location.href='list'</script>");
        }
        out.close();
    }
}
