package com.test.test;

import java.util.Iterator;
import java.util.List;

import javax.sound.sampled.LineListener;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.test.entity.User;
import com.util.MybatisUtil;

/**
 * 测试增删mybatis增删改查
 * 
 * @author wh 测试junit单个方法： 选中方法名，右键执行 ；否则会执行所有test方法
 */
public class Test2 {

	@Test
	public void insertUser() {
		System.out.println("insertUser");
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		// 找到增加id字符串
		String insertUserIDStr = "com.test.entity.userMapper.insertUser";
		int insert = openSession.insert(insertUserIDStr, new User("汪欢", 18));
		// 事务提交方式1
		openSession.commit();
		System.out.println("执行完成" + insert);
	}

	@Test
	public void updateUser() {
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		// 事务提交方式2 openSession(true)默认提交事务
		SqlSession openSessions = sqlSessionFactory.openSession(true);
		String updateStr = "com.test.entity.userMapper.updateUser";
		int update = openSessions.update(updateStr, new User(1, "刘德华", 45));
		System.out.println("执行完成" + update);
	}

	@Test
	public void deleteUser() {
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		// 事务提交方式2 openSession(true)默认提交事务
		SqlSession openSessions = sqlSessionFactory.openSession(true);
		String deleteStr = "com.test.entity.userMapper.deleteUser";
		int update = openSessions.update(deleteStr, 2);
		System.out.println("执行完成" + update);
	}

	@Test
	public void listUsers() {
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		// 事务提交方式2 openSession(true)默认提交事务
		SqlSession openSessions = sqlSessionFactory.openSession(true);
		String listStr = "com.test.entity.userMapper.listUser";
		List<User> list = openSessions.selectList(listStr);
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("执行完成");
	}
}
