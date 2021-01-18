package cdu.wenhao.dao;

import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;

import java.util.List;

public interface UserDao {
    //接口里面的方法默认是抽象的
    //增加用户
    int insert(User user);
    //修改
    int update(User user);
    //删除
    int delete(int id);
    //按页查找
    List<User> findByPage(int start,int num);
    //查找所有
    List<User> findAll();
    //id查找
    User findById(int id);
    //名字和密码查找
    User findByNameAndPwd(String name,String pwd);
    //where条件查找
    User findByWhere(String where);
    //获取数据库有多少条用户信息
    int getCount();

    //获取所有帖子
    List<News> findAllNews();

    //获取对应帖子的所有评论
    List<Discussion> findDiscussionByNewsId(int newsId);

    //获取对应帖子的所有评论
    List<Discussion> findAllDiscussion();

    //评论
    int diss(Discussion discussion);

    //发帖
    int addNews(News news);
}
