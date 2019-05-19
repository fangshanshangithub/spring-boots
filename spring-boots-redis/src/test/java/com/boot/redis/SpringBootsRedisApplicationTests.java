package com.boot.redis;

import com.boot.redis.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootsRedisApplicationTests {

	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void contextLoads() {
		redisUtils.set("aa",122222);
	}

}

