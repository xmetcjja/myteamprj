package com.etc.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<G> {
    public void add(G g);
    public void mod(G g);
    public void del(Serializable sid);
    public G get(Serializable sid);
    public List<G> query(G g);
}
