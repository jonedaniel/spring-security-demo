package com.testcase.plaintest;

import com.testcase.plaintest.domain.TestModel;
import com.testcase.plaintest.security.mapper.SysUserMapper;
import com.testcase.plaintest.util.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaintestApplicationTests {

	@Autowired
	private RedisService redisService;
	@Autowired
	private SysUserMapper userMapper;

	@Test
	public void contextLoads() {
		redisService.set("name", "123",1800L);
		System.out.println(redisService.get("name"));
	}

	@Test
	public void test2() {
		System.out.println(TestEnum.MATERIAL_ADMIN_PASSED.name());
	}

	@Test
	public void test3() {
		System.out.println(userMapper.selectAll());
	}

	@Test
	public void testMultiThread() {
		System.out.println(TestModel.GUARANTED_WAY.get("1"));
	}

	public static void main(String[] args) {
//		System.out.println(TestModel.GUARANTED_WAY.get(1));

		System.out.println(String.valueOf(null));

		/**
		 * todo 数据库日志
		 */
	}


}
