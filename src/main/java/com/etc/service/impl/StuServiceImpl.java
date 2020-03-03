package com.etc.service.impl;

import com.etc.dao.LinkmanDao;
import com.etc.dao.StuDao;
import com.etc.entity.Linkman;
import com.etc.entity.Stu;
import com.etc.service.StuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.font.LineMetrics;
import java.io.Serializable;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;
    @Resource
    private LinkmanDao linkmanDao;

    @Override
    public void add(Stu stu) {
        stuDao.add(stu);
        List<Linkman> list = stu.getList();
        for(Linkman l:list){
            l.setStu(stu);//设置联系人与学生的对应关系
            linkmanDao.add(l);
        }
    }

    @Override
    public void mod(Stu stu) {
        stuDao.mod(stu);
        //学生联系人的crud操作
        Linkman lc = new Linkman();//封装查询条件
        lc.setStu(stu);
        List<Linkman> blist = linkmanDao.query(lc);//查询修改之前的联系人
        if(blist != null && blist.size() != 0){//删除
            for(Linkman bl:blist){//对原联系人循环
                boolean flag = true;//原联系人在修改后的联系人中不存在
                for(Linkman al:stu.getList()){//对修改后的联系人循环比对
                    if(bl.getLid().equals(al.getLid())){
                        flag = false;
                        break;
                    }
                }
                if(flag)linkmanDao.del(bl.getLid());//删除
            }
        }
        //修改与新加
        for(Linkman al:stu.getList()){
            if(al.getLid() == null){//新加
                al.setStu(stu);
                linkmanDao.add(al);
            }else{//修改
                linkmanDao.mod(al);
            }
        }
    }

    @Override
    public void del(Serializable sid) {
        stuDao.del(sid);
    }

    @Override
    public Stu get(Serializable sid) {
        Stu s = stuDao.get(sid);
        Linkman lc = new Linkman();//封装查询条件
        lc.setStu(s);
        s.setList(linkmanDao.query(lc));//查询出学生的联系人
        return s;
    }

    @Override
    public List<Stu> query() {
        return null;
    }

    @Override
    public List<Stu> query(Stu stu) {
        return null;
    }

    @Override
    public PageInfo<Stu> query(Stu stu, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Stu> list = stuDao.query(stu);
        PageInfo<Stu> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
