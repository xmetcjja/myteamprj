package com.etc.service.impl;

import com.etc.dao.ClaDao;
import com.etc.entity.Cla;
import com.etc.service.ClaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class ClaServiceImpl implements ClaService {

    @Resource
    private ClaDao claDao;

    @Override
    public void add(Cla cla) {
        claDao.add(cla);
    }

    @Override
    public void mod(Cla cla) {
        claDao.mod(cla);
    }

    @Override
    public void del(Serializable sid) {
        claDao.del(sid);
    }

    @Override
    public Cla get(Serializable sid) {
        return claDao.get(sid);
    }

    @Override
    public List<Cla> query() {
        return claDao.query(null);
    }

    @Override
    public List<Cla> query(Cla cla) {
        return null;
    }

    @Override
    public PageInfo<Cla> query(Cla cla, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);//1,设置页码，每页显示多少条记录
        List<Cla> list = claDao.query(null);//取页面上所要显示的集合数据
        PageInfo<Cla> pageInfo = new PageInfo<>(list);//构造分页信息对象
        return pageInfo;
    }
}
