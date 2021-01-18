package cdu.wenhao.controller;

import cdu.wenhao.module.News;
import cdu.wenhao.module.User;
import cdu.wenhao.service.UserService;
import cdu.wenhao.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("/user/addNews.do")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news=null;
        //配置保存位置
        String path = "/photo";
        //获取保存位置对应的真实物理地址
        String savedDir= req.getServletContext().getRealPath(path);

        //创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory= new DiskFileItemFactory();
        //创建文件上传处理器
        ServletFileUpload upload=new ServletFileUpload(factory);

        try{
            //解析请求
            List<FileItem> items=upload.parseRequest(req);
            if(!items.isEmpty()){//非空则有信息添加
                news=new News();
            }

            //创建迭代器，用来处理表单数据
            Iterator<FileItem> iterator=items.iterator();
            while (iterator.hasNext()){
                FileItem item =iterator.next();
                //判断是表单域的信息 还是 上传的文件（有name  和 照片文件）
                if(item.isFormField()){
                    //根据fielName来判断是哪个表单控件，我们这儿只有name
                    if(item.getFieldName().equals("theme")){
                        news.setTheme(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }else if(item.getFieldName().equals("content")){
                        news.setContent(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }else if(item.getFieldName().equals("userId")){
                        news.setUserId(Integer.parseInt(new String(item.getString().getBytes("iso-8859-1"),"utf-8")));
                    }
                }else {
                    //文件
                    //获取文件名
                    String fileName =item.getName();
                    //保存文件
                    System.out.println("saveDir="+savedDir);
                    File file = new File(savedDir+"//"+fileName);
                    if (!file.exists()){
                        //如果该路径文件不存在，才写入。因为如果存在又写入的话会报错
                        item.write(file);
                    }

                    //候选人的照片路径
                    System.out.println("req.getContextPath()="+req.getContextPath());
//                    news.setPhotoUrl(req.getContextPath()+path+"/"+fileName);
                    //直接将图片路径设置为图片文件的名字
                    news.setPhotoUrl(fileName);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out =resp.getWriter();
        Date date =new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newsTime = sdf.format(date);
        news.setNewsTime(newsTime);
        UserService userService =new UserServiceImpl();
        if (userService.addNews(news)){
            out.println("<script>window.location.href='newsList'</script>");
        }else {
            out.println("<script>alert('新建帖子失败："+news+"');window.location.href='newsList'</script>");
        }
        out.close();
    }
}
