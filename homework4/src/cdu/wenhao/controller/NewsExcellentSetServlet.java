package cdu.wenhao.controller;

import cdu.wenhao.service.ManagerService;
import cdu.wenhao.service.impl.ManagerServiceIpml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/excellent.do")
public class NewsExcellentSetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("newsId");
        int newsId= (sId==null||sId.equals(""))?0:Integer.parseInt(sId);
        PrintWriter out = resp.getWriter();
        ManagerService managerService = new ManagerServiceIpml();
        if(managerService.newsIsExcellent(newsId)){
            out.println("<script>alert('设置成功！');window.location.href='newsListManager.get'</script>");
        }else {
            out.println("<script>alert('设置成功！');window.location.href='newsListManager.get'</script>");
        }
        out.close();
    }
}
