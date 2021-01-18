package cdu.wenhao.dao;

import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.Manager;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;

import java.util.List;

public interface ManagerDao {
    //接口里面的方法默认是抽象的

    //删除
    int delete(int id);

    //按页查找用户
    List<User> findByPage(int start, int num);

    //查找所有用户
    List<User> findAll();

    //id查找用户
    User findById(int id);

    //验证管理员登陆
    Manager checkLogin(String name,String pwd);

    //名字和密码查找用户
    User findByNameAndPwd(String name,String pwd);

    //where条件查找用户
    User findByWhere(String where);

    //获取数据库有多少条用户信息
    int getCount();

    //分页查找帖子
    List<News> findAllNewsByPage(int start, int num);

    //获取数据库有多少条帖子信息
    int getNewsCount();

    //设置帖子是否为精华帖
    int newsIsExcellent(int newsId);

    //设置帖子是否为置顶帖
    int newsIsTop(int newsId);

    //删除帖子
    int deleteNews(int newsId);

    //分页查找评论
    List<Discussion> findAllDisByPage(int start, int num);

    //获取数据库有多少条评论信息
    int getDisCount();

    //删除帖子
    int deleteDis(int disId);
}
