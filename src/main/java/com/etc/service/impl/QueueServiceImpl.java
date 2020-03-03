package com.etc.service.impl;


import com.etc.dao.QueueDao;
import com.etc.entity.Queue;
import com.etc.service.QueueService;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

    @Resource
    private QueueDao queueDao;
    @Resource
    private JedisPool jedisPool;

    //取票
    @Override
    public Queue getQueue(String busiType) {
        Queue queue = new Queue();//构造一个票
        String queueNoNew = busiType;//票号
        //取业务busiType最新一张票号
        String queueNo = queueDao.findLastQueueNoByBusiType(busiType);
        if(queueNo == null){//还没有业务busiType的今日票号
            queueNoNew = queueNoNew + "0001";
        }else{//已经有今日业务busiType的票号
            String nostr = String.valueOf(Integer.parseInt(queueNo.substring(1))+1);
            //数字编号前0的填充
            int max = 4 - nostr.length();
            for(int i = 0;i<max;i++){
                queueNoNew = queueNoNew + "0";
            }
            //得到最新票号
            queueNoNew = queueNoNew + nostr;
        }
        queue.setQueueNo(queueNoNew);
        queue.setBusiType(busiType);
        //设置取票的时间
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String queueTime = dtf.format(ldt);
        queue.setQueueTime(queueTime);
        queue.setQueueStatus("0");
        queueDao.add(queue);//把票保存到数据库中
        //保存到缓存数据库当中
        Jedis jedis = jedisPool.getResource();
        jedis.lpush(busiType,queueNoNew);
        jedis.close();
        return queue;
    }

    //叫号
    @Override
    public String callQueue(String busiType) {
        //叫号
        //String queueNo = queueDao.callQueue(busiType);//从数据库中叫号
        //从缓存数据库中叫号
        Jedis jedis = jedisPool.getResource();
        String queueNo = jedis.rpop(busiType);
        //更改票号的状态
        if(queueNo != null)
            queueDao.modStatus(queueNo);
        jedis.close();
        return queueNo;
    }

    //设置定时任务，把数据表queue_info清空，及缓存清空
    @Override
    @Scheduled(cron = "0 7 9 * * ?")
    public void clearTodayQueueData() {
        queueDao.delAll();
        Jedis jedis = jedisPool.getResource();
        jedis.del("A","B","C");
    }

    @Override
    public void add(Queue queue) {

    }

    @Override
    public void mod(Queue queue) {

    }

    @Override
    public void del(Serializable sid) {

    }

    @Override
    public Queue get(Serializable sid) {
        return null;
    }

    @Override
    public List<Queue> query() {
        return null;
    }

    @Override
    public List<Queue> query(Queue queue) {
        return null;
    }

    @Override
    public PageInfo<Queue> query(Queue queue, int pageNo, int pageSize) {
        return null;
    }
}
