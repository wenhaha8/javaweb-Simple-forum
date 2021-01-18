package cdu.wenhao.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/user/validCode")
public class validCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //禁止缓存3行
        resp.setHeader("Pragma","No-cache");
        resp.setDateHeader("Exprise",0);

        //随机生成四位数的验证码
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            int a=random.nextInt(3);
            char c;
            if (a == 0) {//数字
                c=(char) (random.nextInt(10)+48);
            }else if (a == 1) {
                c=(char)(random.nextInt(26)+97);

            }else {
                c=(char)(random.nextInt(26)+65);
            }

            if (c == 'o'||c == 'O'||c == '1'||c == '0'||c == 'l'||c == 'I') {
                i--;
                continue;
            }
            code=code+c;
        }

        //保存验证码
        HttpSession session = req.getSession();
        session.setAttribute("validCode",code);

        //绘图准备工作
        int width=60;
        int height=20;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        //取得一个画笔
        Graphics g=image.getGraphics();

        //绘制图片
        g.setColor(Color.gray);
        g.fillRect(0,0,width,height);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString(String.valueOf(code),5,16);
        ImageIO.write(image,"png",resp.getOutputStream());
    }
}
