package com.zj.redis;

import com.zj.redis.entity.User;
import com.zj.redis.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void  setTest1(){
        User user = new User();
        user.setId(1);
        user.setName("zj");
        this.redisUtil.set("test1",user);
    }

    @Test
    public void getTest1(){

        System.out.println(this.redisUtil.get("test1"));
    }
}
