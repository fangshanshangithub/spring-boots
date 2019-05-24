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
		redisUtils.set("a11a","ww我惹我发的是高等师范对", 100232131);
	}


	@Test
	public void getRedisValue() {
		String vlaue = (String) redisUtils.get("a11a");
		System.out.println("@@@@@@     " + vlaue + "       @");
	}

	@Test
	public void getRedisTime() {
		Long vlaue = redisUtils.getExpire("a11a");
		System.out.println("@@@@@@     " + vlaue + "       @");
	}

}

