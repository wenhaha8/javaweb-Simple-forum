package cdu.wenhao.service.impl;

import cdu.wenhao.dao.UserDao;
import cdu.wenhao.dao.impl.UserDaoImpl;
import cdu.wenhao.module.Discussion;
import cdu.wenhao.module.News;
import cdu.wenhao.module.User;
import cdu.wenhao.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    //泛型
    UserDao userDao=new UserDaoImpl();

    @Override
    public boolean register(User user) {
        return userDao.insert(user)==1?true:false;
    }

    @Override
    public User checkLogin(String name, String pwd) {
        return userDao.findByNameAndPwd(name,pwd);
    }

    @Override
    public boolean add(User user) {
        return userDao.insert(user)==1?true:false;
    }

    @Override
    public boolean addNews(News news) {
        return userDao.addNews(news)==1?true:false;
    }

    @Override
    public boolean diss(Discussion discussion) {
        return userDao.diss(discussion)==1?true:false;
    }

    @Override
    public boolean modify(User user) {
        return userDao.update(user)==1?true:false;
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id)==1?true:false;
    }

    @Override
    public User get(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByPage(int page, int pageSize) {
        return page>0?userDao.findByPage((page-1)*pageSize,pageSize):userDao.findByPage(0,pageSize);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int getCount() {
        return userDao.getCount();
    }

    @Override
    public List<News> findAllNews() {
        return userDao.findAllNews();
    }

    @Override
    public List<Discussion> findDiscussionByNewsId(int newsId) {
        return userDao.findDiscussionByNewsId(newsId);
    }

    @Override
    public List<Discussion> findAllDiscussion() {
        return userDao.findAllDiscussion();
    }
}
