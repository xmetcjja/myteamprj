package com.etc.test;

import com.etc.service.QueueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")

public class QueueServiceTest {
    @Resource
    QueueService queueService;

    //取票的测试
    @Test
    public void takeQueueTest(){
        for (int i = 0;i<1000;i++){
            queueService.getQueue("A");
            queueService.getQueue("B");
            queueService.getQueue("C");
        }
    }

    //叫号的测试
    @Test
    public void callQueueTest(){
        long start = System.currentTimeMillis();
        for(int i = 0;i<10;i++){
            String queueNo = queueService.callQueue("A");
            String queueNo2 = queueService.callQueue("B");
            String queueNo3 = queueService.callQueue("C");
        }
        long end = System.currentTimeMillis();
        System.out.println("所花时间：" + (end - start));
    }
}
