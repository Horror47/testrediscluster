package com.whw.testrediscluster;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@Slf4j
public class TestredisclusterApplication implements ApplicationRunner {

	@Autowired
	RedisTemplate redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TestredisclusterApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("准备存入");
		redisTemplate.opsForValue().set("cluster","aa");

		log.info("存入");
		String a = (String) redisTemplate.opsForValue().get("cluster");
		log.info("获取:"+a);
	}
}
