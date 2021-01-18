package cdu.wenhao.service;

import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;

import java.util.List;

public interface UserService {
    //登陆
    boolean register(User user);

    //检查登陆
    User checkLogin(String name,String pwd);

    //增加用户
    boolean add(User user);

    //修改用户
    boolean modify(User user);

    //删除用户
    boolean delete(int id);

    //根据id获取用户信息
    User get(int id);

    //根据页码获取用户
    List<User> findByPage(int page,int pageSize);

    //根据页码获取用户
    List<User> findAll();

    //获取用户数量
    int getCount();

    //获取所有帖子
    List<News> findAllNews();

    //获取对应帖子的所有评论
    List<Discussion> findDiscussionByNewsId(int newsId);

    //获取对应帖子的所有评论
    List<Discussion> findAllDiscussion();

    //发帖
    boolean addNews(News news);

    //评论
    boolean diss(Discussion discussion);
}
