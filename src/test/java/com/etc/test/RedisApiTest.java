package com.etc.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class RedisApiTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    JedisPool jedisPool;
    Jedis jedis;

    @Before
    public void getConn(){
        jedis = jedisPool.getResource();
    }

    @Test
    public void stringsTest(){
        jedis.set("key1","value1");
        jedis.set("key2","value2");
        jedis.set("key3","value3");

        logger.info("redis增加值成功!");

        logger.info("获取key1:" + jedis.get("key1"));
        logger.info("获取key2:" + jedis.get("key2"));
    }

    @Test
    public void hashTest(){
        //缓存中存储hash值
        jedis.hset("hash","username","yy");
        //从缓存中取hash值
        logger.info("从redis中取hash缓存的值：" + jedis.hget("hash","username"));
        //一次性设置多个属性值
        Map<String,String> map = new HashMap<>();
        map.put("username","大灰狼");
        map.put("age","20");
        map.put("sex","男");
        jedis.hmset("hash2",map);

        //一次性从hash中获取所有属性值
        List<String> stringList = jedis.hmget("hash2", "username", "age", "sex");
        logger.debug("----> 获取缓存中的数据：" + stringList);

    }

    @Test
    public void listTest(){
        //把数据设置到列表中
        jedis.lpush("mylist","A","B","C","D","E","F");
        //从列表中查询数据
        List<String> list = jedis.lrange("mylist",0,-1);
        for(String s:list){
            logger.info(s);
        }
        //模拟队列
        logger.info("列表最早放入的数据:" + jedis.rpop("mylist"));
        //模拟栈
        logger.info("列表最后放入的数据:" + jedis.lpop("mylist"));
    }
}
