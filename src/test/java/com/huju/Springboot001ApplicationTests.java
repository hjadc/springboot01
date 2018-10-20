package com.huju;

import com.huju.test01.domain.Person;
import com.huju.test01.domain.KpiIndexDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot001ApplicationTests {

	/**
	 * 引入这个是redis自带的模板
	 */
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	private Person person; // 测试获取配置文件的内容

	@Autowired
	ApplicationContext ioc;


	/**
	 * 字符串 (strings)			stringRedisTemplate.opsForValue();
	 * 散列 (hashes)				stringRedisTemplate.opsForHash()
	 * 列表 (lists)				stringRedisTemplate.opsForList()
	 * 集合 (sets)				stringRedisTemplate.opsForSet()
	 * 有序集合 (sorted sets)	stringRedisTemplate.opsForZSet()
	 */
	@Test
	public void contextLoads() {
		// stringRedisTemplate.opsForValue().set("msg","Hello Redis !");

		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);
	}

	@Test
	public void test02(){

		KpiIndexDomain domain = new KpiIndexDomain();
		domain.setId(666);
		domain.setCode("test02");
		domain.setName("这个是测试redis存储对象");
		domain.setCreatedBy("huju");
		domain.setCreationDate(new Date());

		redisTemplate.opsForValue().set("kpiIndex",domain);

		KpiIndexDomain kpiIndex = (KpiIndexDomain)redisTemplate.opsForValue().get("kpiIndex");
		System.out.println(kpiIndex);

	}

	/**
	 * 测试获取配置文件的值
	 */
	@Test
	public void getProperties(){
		System.out.println(person);

	}

	/**
	 * 测试给容器中添加bean
	 */
	@Test
	public void getBean(){
		boolean bean = ioc.containsBean("helloService");
		System.out.println(bean);

	}

}
