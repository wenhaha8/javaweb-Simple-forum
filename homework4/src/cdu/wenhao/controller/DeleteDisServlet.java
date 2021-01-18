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

@WebServlet("/manager/deleteDis.do")
public class DeleteDisServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId=req.getParameter("disId");
        int disId= (sId==null||sId.equals(""))?0:Integer.parseInt(sId);

        PrintWriter out =resp.getWriter();

        ManagerService managerService =new ManagerServiceIpml();
        if (managerService.deleteDis(disId)){
            out.println("<script>alert('删除评论成功：disId: "+disId+"');window.location.href='disListManager.get'</script>");
        }else {
            out.println("<script>alert('删除评论失败：disId: "+disId+"');window.location.href='disListManager.get'</script>");
        }
        out.close();
    }
}
