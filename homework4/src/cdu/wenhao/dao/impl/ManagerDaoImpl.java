package cdu.wenhao.dao.impl;

import cdu.wenhao.dao.BaseDao;
import cdu.wenhao.dao.ManagerDao;
import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.Manager;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    //该类继承了BaseDao,会调用父类的构造方法,直接实现了数据库连接

    //写在前面方便之后的方法调用
    PreparedStatement pstmt = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int delete(int userId) {
        int rows=0;//受影响行数
        String sql = "delete from  tb_user where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("删除失败！"+sql);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<User> findByPage(int start, int num) {
        List<User> userList=new ArrayList<>();
        String sql = "select * from  tb_user order by userId desc limit ?,?";
//        String sql = "select * from  tb_user order by desc where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                User user =new User();
                user.setUserId(res.getInt("userId"));
                user.setUserName(res.getString("userName"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setReg_time(res.getString("reg_time"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> findAll() {
        List<User> userList=new ArrayList<>();
        String sql = "select * from  tb_user order by reg_time desc";
//        String sql = "select * from  tb_user order by desc where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                User user =new User();
                user.setUserId(res.getInt("userId"));
                user.setUserName(res.getString("userName"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setReg_time(res.getString("reg_time"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int userId) {
        User user=null;
        String sql = "select * from  tb_user where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                user=new User();
                user.setUserId(res.getInt("userId"));
                user.setUserName(res.getString("userName"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setReg_time(res.getString("reg_time"));
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql+userId);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Manager checkLogin(String managerName, String pwd) {
        Manager manager = new Manager();
        String sql = "select * from  tb_manager where managerName=? and pwd=?";
        String sql2 = "update tb_manager set lastLoginTime=? where managerId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,managerName);
            pstmt.setString(2,pwd);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                manager.setId(res.getInt("managerId"));
                manager.setManagerName(res.getString("managerName"));
                manager.setLastLoginTime(res.getString("lastLoginTime"));
            }
            pstmt=conn.prepareStatement(sql2);
            Date date= new Date();
            pstmt.setString(1,sdf.format(date));
            pstmt.setInt(2,manager.getId());
            int rows=pstmt.executeUpdate();
            if (rows==0){
                System.out.println("最后登录时间更新失败");
            }else {
                System.out.println("最后登录时间更新成功");
            }
        } catch (SQLException e) {
            System.out.println("管理员查找失败！"+sql);
            e.printStackTrace();
            return null;
        }
        return manager;
    }

    @Override
    public User findByNameAndPwd(String userName, String pwd) {
        User user=new User();
        String sql = "select * from  tb_user where userName=? and pwd=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,userName);
            pstmt.setString(2,pwd);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                user.setUserId(res.getInt("userId"));
                user.setUserName(res.getString("userName"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setReg_time(res.getString("reg_time"));
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByWhere(String where) {
        User user=new User();
        String sql = "select * from  tb_user "+where;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,where);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                user.setUserId(res.getInt("userId"));
                user.setUserName(res.getString("userName"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setReg_time(res.getString("reg_time"));
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int getCount() {
        int count=0;
        String sql = "select * from tb_user";
        try {
            pstmt=conn.prepareStatement(sql);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                count++;
            }
        } catch (SQLException e) {
            System.out.println("获取用户数量  失败！"+sql);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<News> findAllNewsByPage(int start, int num) {
        List<News> newsList=new ArrayList<>();
        String sql = "select * from  tb_news order by newsId desc limit ?,?";
//        String sql = "select * from  tb_user order by desc where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                News news = new News();
                news.setNewsId(res.getInt("newsId"));
                news.setUserId(res.getInt("userId"));
                news.setPriseNum(res.getInt("priseNum"));
                news.setExcellent(res.getInt("excellent"));
                news.setTop(res.getInt("top"));
                news.setTheme(res.getString("theme"));
                news.setContent(res.getString("content"));
                news.setPhotoUrl(res.getString("photoUrl"));
                news.setNewsTime(res.getString("newsTime"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return newsList;
    }

    @Override
    public int getNewsCount() {
        int count=0;
        String sql = "select * from tb_news";
        try {
            pstmt=conn.prepareStatement(sql);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                count++;
            }
        } catch (SQLException e) {
            System.out.println("获取 帖子数量 失败！"+sql);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int newsIsExcellent(int newsId) {
        int rows=0;
        String sql1 = "select excellent from tb_news where newsId=?";
        String sql2 = "update tb_news set excellent=? where newsId=?";
        try {
            pstmt=conn.prepareStatement(sql1);
            pstmt.setInt(1,newsId);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                pstmt=conn.prepareStatement(sql2);
                pstmt.setInt(1,res.getInt("excellent")==1?0:1);
                pstmt.setInt(2,newsId);
                rows = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int newsIsTop(int newsId) {
        int rows=0;
        String sql1 = "select top from tb_news where newsId=?";
        String sql2 = "update tb_news set top=? where newsId=?";
        try {
            pstmt=conn.prepareStatement(sql1);
            pstmt.setInt(1,newsId);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                pstmt=conn.prepareStatement(sql2);
                pstmt.setInt(1,res.getInt("top")==1?0:1);
                pstmt.setInt(2,newsId);
                rows = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteNews(int newsId) {
        int rows=0;//受影响行数
        String sql = "delete from  tb_news where newsId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,newsId);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("删除失败！"+sql);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<Discussion> findAllDisByPage(int start, int num) {
        List<Discussion> disList=new ArrayList<>();
        String sql = "select * from  tb_discussion order by discussionId desc limit ?,?";
//        String sql = "select * from  tb_user order by desc where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                Discussion dis=new Discussion();
                dis.setDiscussionId(res.getInt("discussionId"));
                dis.setNewsId(res.getInt("newsId"));
                dis.setUserId(res.getInt("userId"));
                dis.setNickname(res.getString("nickname"));
                dis.setBeDisedUserNicename(res.getString("beDisedUserNicename"));
                dis.setContent(res.getString("content"));
                dis.setDiscussionTime(res.getString("discussionTime"));
                disList.add(dis);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return disList;
    }

    @Override
    public int getDisCount() {
        int count=0;
        String sql = "select * from tb_discussion";
        try {
            pstmt=conn.prepareStatement(sql);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                count++;
            }
        } catch (SQLException e) {
            System.out.println("获取 评论数量 失败！"+sql);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteDis(int disId) {
        int rows=0;//受影响行数
        String sql = "delete from tb_discussion where discussionId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,disId);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("删除失败！"+sql);
            e.printStackTrace();
        }
        return rows;
    }
}

