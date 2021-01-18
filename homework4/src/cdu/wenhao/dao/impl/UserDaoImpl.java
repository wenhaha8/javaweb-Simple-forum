package cdu.wenhao.dao.impl;

import cdu.wenhao.dao.BaseDao;
import cdu.wenhao.dao.UserDao;
import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    //该类继承了BaseDao,会调用父类的构造方法,直接实现了数据库连接

    //写在前面方便之后的方法调用
    PreparedStatement pstmt = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int insert(User user) {
        int rows=0;//受影响行数
        String sql = "insert into tb_user(userName,pwd,gender,nickname,headSculpture,reg_time) values (?,?,?,?,?,?)";
        String sql2 = "select userId from tb_user where reg_time=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUserName());
            pstmt.setString(2,user.getPwd());
            pstmt.setString(3,user.getGender());
            pstmt.setString(4,user.getNickname());
            pstmt.setString(5,user.getHeadSculpture());
            pstmt.setString(6,user.getReg_time());
//            pstmt.setString(3,user.getReg_time());
            rows = pstmt.executeUpdate();

            pstmt=conn.prepareStatement(sql2);
            pstmt.setString(1,user.getReg_time());
            ResultSet res=pstmt.executeQuery();
            if (res.next()){
                user.setUserId(res.getInt("userId"));
            }else {
                System.out.println("添加用户时获取userId失败！");
            }
        } catch (Exception e) {
            System.out.println("插入失败！"+user+"\n"+sql);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(User user) {
        int rows=0;//受影响行数
        String sql = "update tb_user set userName=?,pwd=? where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUserName());
            pstmt.setString(2,user.getPwd());
            pstmt.setInt(3,user.getUserId());
            rows = pstmt.executeUpdate();
            if (rows==0){
                System.out.println("UserDao更新失败：sql="+sql+" 用户userId："+user.getUserId());
            }else {
                System.out.println("UserDao更新成功：sql="+sql+" 用户userId："+user.getUserId());
            }
        } catch (Exception e) {
            System.out.println("修改失败！"+user+"\n"+sql);
            e.printStackTrace();
        }
        return rows;
    }

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
                user.setNickname(res.getString("nickname"));
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
                user.setNickname(res.getString("nickname"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setHeadSculpture(res.getString("headSculpture"));
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
                user.setNickname(res.getString("nickname"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setHeadSculpture(res.getString("headSculpture"));
                user.setReg_time(res.getString("reg_time"));
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql+userId);
            e.printStackTrace();
        }
        return user;
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
                user.setNickname(res.getString("nickname"));
                user.setPwd(res.getString("pwd"));
                user.setGender(res.getString("gender"));
                user.setHobby(res.getString("hobby"));
                user.setHeadSculpture(res.getString("headSculpture"));
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
                user.setHeadSculpture(res.getString("headSculpture"));
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
    public int addNews(News news) {
        int rows=0;//受影响行数
        String sql = "insert into tb_news(theme,content,photoUrl,priseNum,userId,newsTime) values (?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,news.getTheme());
            pstmt.setString(2,news.getContent());
            pstmt.setString(3,news.getPhotoUrl());
            pstmt.setInt(4,0);
            pstmt.setInt(5,news.getUserId());
            pstmt.setString(6,news.getNewsTime());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("插入失败！"+news+"\n"+sql);
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<News> findAllNews() {
        List<News> newsList=new ArrayList<>();
        String sql = "select * from  tb_news order by top DESC";
//        String sql = "select * from  tb_news order by newsId DESC";
//        String sql = "select * from  tb_user order by desc where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                News news = new News();
                news.setNewsId(res.getInt("newsId"));
                news.setUserId(res.getInt("userId"));
                news.setTop(res.getInt("top"));
                news.setExcellent(res.getInt("excellent"));
                news.setPriseNum(res.getInt("priseNum"));
                news.setTheme(res.getString("theme"));
                news.setContent(res.getString("content"));
                news.setNewsTime(res.getString("newsTime"));
                news.setPhotoUrl(res.getString("photoUrl"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return newsList;
    }

    @Override
    public List<Discussion> findDiscussionByNewsId(int newsId) {
        List<Discussion> discussionList=new ArrayList<>();
        String sql = "select * from  tb_discussion order by discussionId desc";
//        String sql = "select * from  tb_user order by desc where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                Discussion discussion = new Discussion();
                discussion.setNewsId(res.getInt("newsId"));
                discussion.setUserId(res.getInt("userId"));
                discussion.setContent(res.getString("content"));
                discussion.setDiscussionTime(res.getString("discussionTime"));
                discussionList.add(discussion);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return discussionList;
    }

    @Override
    public List<Discussion> findAllDiscussion() {
        List<Discussion> discussionList=new ArrayList<>();
        String sql = "select * from  tb_discussion order by discussionId";
//        String sql = "select * from  tb_user order by desc where userId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                Discussion discussion = new Discussion();
                discussion.setDiscussionId(res.getInt("discussionId"));
                discussion.setNewsId(res.getInt("newsId"));
                discussion.setUserId(res.getInt("userId"));
                discussion.setContent(res.getString("content"));
                discussion.setNickname(res.getString("nickname"));
                discussion.setBeDisedUserNicename(res.getString("beDisedUserNicename"));
                discussion.setDiscussionTime(res.getString("discussionTime"));
                discussionList.add(discussion);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return discussionList;
    }

    @Override
    public int diss(Discussion discussion) {
        int rows=0;//受影响行数
        String sql = "insert into tb_discussion(newsId,userId,nickname,beDisedUserNicename,content,discussionTime) values (?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,discussion.getNewsId());
            pstmt.setInt(2,discussion.getUserId());
            pstmt.setString(3,discussion.getNickname());
            pstmt.setString(4,discussion.getBeDisedUserNicename());
            pstmt.setString(5,discussion.getContent());
            Date date = new Date();
            pstmt.setString(6,sdf.format(date));
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("讨论插入失败！"+discussion+"\n"+sql);
            e.printStackTrace();
        }
        return rows;
    }


}
