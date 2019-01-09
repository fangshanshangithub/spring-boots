package com.boot.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boot.redis.dao")
public class SpringBootsRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootsRedisApplication.class, args);
	}

}

