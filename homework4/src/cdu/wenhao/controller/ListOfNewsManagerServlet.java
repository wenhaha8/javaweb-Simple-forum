package cdu.wenhao.controller;

import cdu.wenhao.dao.ManagerDao;
import cdu.wenhao.dao.impl.ManagerDaoImpl;
import cdu.wenhao.module.Manager;
import cdu.wenhao.module.News;
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
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/newsListManager.get")
public class ListOfNewsManagerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage=req.getParameter("page");
        int page=(sPage==null||sPage.equals(""))?1:Integer.parseInt(sPage);
        int pageSize =8;
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);

        ManagerService managerService = new ManagerServiceIpml();
        List<News> newsList= managerService.findAllNewsByPage(page,pageSize);

        req.setAttribute("newsList",newsList);
        int newsCount= managerService.getNewsCount();
//        System.out.println("userCount  "+userCount);
        req.setAttribute("newsCount",newsCount);
        req.setAttribute("pageCount",newsCount%pageSize==0?newsCount/pageSize:newsCount/pageSize+1);

        req.getRequestDispatcher("newsListOfManager.jsp").forward(req,resp);
    }
}
