package cdu.wenhao.service;

import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.Manager;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;

import java.util.List;

public interface ManagerService {
    //检查登陆
    Manager checkLogin(String name,String pwd);

    //删除用户
    boolean delete(int id);

    //根据id获取用户信息
    User get(int id);

    //根据页码获取用户
    List<User> findAllUserByPage(int page, int pageSize);

    //获取用户数量
    int getCount();

    //分页获取帖子
    List<News> findAllNewsByPage(int page, int pageSize);

    //获取帖子数量
    int getNewsCount();

    //设置帖子是否为精华帖
    boolean newsIsExcellent(int newsId);

    //设置帖子是否为置顶帖
    boolean newsIsTop(int newsId);

    //删除帖子
    boolean deleteNews(int newsId);

    //分页获取评论
    List<Discussion> findAllDisByPage(int page, int pageSize);

    //获取评论数量
    int getDisCount();

    //删除帖子
    boolean deleteDis(int newsId);



}
