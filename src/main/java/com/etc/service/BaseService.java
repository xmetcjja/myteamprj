package com.etc.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public interface BaseService<G> {

    public void add(G g);
    public void mod(G g);
    public void del(Serializable sid);
    public G get(Serializable sid);
    public List<G> query();
    public List<G> query(G g);
    //pageNo:表示当前页 pageSize:表示每页显示多少条记录
    public PageInfo<G> query(G g, int pageNo, int pageSize);

}
