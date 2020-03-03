package com.etc.service;

import com.etc.entity.Queue;

public interface QueueService extends BaseService<Queue> {

    //取票
    public Queue getQueue(String busiType);

    //叫号
    public String callQueue(String busiType);

    //设置定时任务，把数据表queue_info清空，及缓存清空
    public void clearTodayQueueData();
}
