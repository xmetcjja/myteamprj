package com.etc.service.impl;

import com.etc.dao.UserDao;
import com.etc.entity.User;
import com.etc.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginquery(User user) {
        List<User> list = userDao.query(user);
        if(list != null && list.size() == 1)return list.get(0);
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void mod(User user) {

    }

    @Override
    public void del(Serializable sid) {

    }

    @Override
    public User get(Serializable sid) {
        return null;
    }

    @Override
    public List<User> query() {
        return null;
    }

    @Override
    public List<User> query(User user) {
        return null;
    }

    @Override
    public PageInfo<User> query(User user, int pageNo, int pageSize) {
        return null;
    }
}
