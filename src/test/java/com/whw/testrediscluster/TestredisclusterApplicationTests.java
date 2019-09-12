package com.whw.testrediscluster;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestredisclusterApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void cluster(){
		log.info("准备存入");
		redisTemplate.opsForValue().set("cluster","aa");

		log.info("存入");
		String a = (String) redisTemplate.opsForValue().get("cluster");
		log.info("获取:"+a);

	}
}
