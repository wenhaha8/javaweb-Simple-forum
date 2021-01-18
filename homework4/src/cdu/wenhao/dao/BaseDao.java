package cdu.wenhao.dao;

import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    //
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url ="jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
    private String url2 ="jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&user=root&password=zplzplhh";
    private String db_user="root";
    private String db_pwd="zplzplhh";

    //能被子类访问
    protected Connection conn=null;

    public BaseDao(){
        connect();//连接数据库
    }

    protected  void connect(){
        try{
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(url2);
        } catch (Exception e) {
            System.out.println("连接失败："+e.getMessage());
        }
    }

    protected void  close(){
        try {
            //在数据库已连接且未关闭的情况下
            if (conn!=null&&!conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            System.out.println("关闭失败"+e.getMessage());
        }
    }
}
