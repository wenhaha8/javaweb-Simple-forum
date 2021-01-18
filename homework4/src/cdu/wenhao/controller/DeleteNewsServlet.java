package cdu.wenhao.controller;

import cdu.wenhao.module.Manager;
import cdu.wenhao.service.ManagerService;
import cdu.wenhao.service.UserService;
import cdu.wenhao.service.impl.ManagerServiceIpml;
import cdu.wenhao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/deleteNews.do")
public class DeleteNewsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("newsId");
        int newsId= (sId==null||sId.equals(""))?0:Integer.parseInt(sId);

        PrintWriter out =resp.getWriter();

        ManagerService managerService =new ManagerServiceIpml();
        if (managerService.deleteNews(newsId)){
            out.println("<script>alert('删除帖子成功：newsId: "+newsId+"');window.location.href='newsListManager.get'</script>");
        }else {
            out.println("<script>alert('删除帖子失败：newsId: "+newsId+"');window.location.href='newsListManager.get'</script>");
        }
        out.close();
    }
}
