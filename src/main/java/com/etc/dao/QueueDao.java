package com.etc.dao;

import com.etc.entity.Queue;

import java.util.List;

public interface QueueDao extends BaseDao<Queue> {

    /**
     * 查询当天某个业务的最后一条记录
     */
    public String findLastQueueNoByBusiType(String busiType);

    /**
     * 查询某种业务的未叫的票，存储到缓存redis中
     */
    public List<String> findNoCallByBusiType(String busiType);

    /**
    * 更新票的状态
     */
    public void modStatus(String queueNo);

    //叫号
    public String callQueue(String busiType);

    //删除全部数据
    public void delAll();
}
