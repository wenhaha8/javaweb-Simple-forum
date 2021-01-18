package cdu.wenhao.controller;

import cdu.wenhao.service.UserService;
import cdu.wenhao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//删除候选人
@WebServlet("/manager/del.do")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("id");
        int id= (sId==null||sId.equals(""))?0:Integer.parseInt(sId);

        PrintWriter out =resp.getWriter();

        UserService userService =new UserServiceImpl();
        if (userService.delete(id)){
            out.println("<script>alert('删除用户成功：id: "+id+"');window.location.href='userList'</script>");
        }else {
            out.println("<script>alert('删除用户失败：id: "+id+"');window.location.href='userList'</script>");
        }
        out.close();
    }
}
