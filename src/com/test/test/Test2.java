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
 * ������ɾmybatis��ɾ�Ĳ�
 * 
 * @author wh ����junit���������� ѡ�з��������Ҽ�ִ�� �������ִ������test����
 */
public class Test2 {

	@Test
	public void insertUser() {
		System.out.println("insertUser");
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		// �ҵ�����id�ַ���
		String insertUserIDStr = "com.test.entity.userMapper.insertUser";
		int insert = openSession.insert(insertUserIDStr, new User("����", 18));
		// �����ύ��ʽ1
		openSession.commit();
		System.out.println("ִ�����" + insert);
	}

	@Test
	public void updateUser() {
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		// �����ύ��ʽ2 openSession(true)Ĭ���ύ����
		SqlSession openSessions = sqlSessionFactory.openSession(true);
		String updateStr = "com.test.entity.userMapper.updateUser";
		int update = openSessions.update(updateStr, new User(1, "���»�", 45));
		System.out.println("ִ�����" + update);
	}

	@Test
	public void deleteUser() {
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		// �����ύ��ʽ2 openSession(true)Ĭ���ύ����
		SqlSession openSessions = sqlSessionFactory.openSession(true);
		String deleteStr = "com.test.entity.userMapper.deleteUser";
		int update = openSessions.update(deleteStr, 2);
		System.out.println("ִ�����" + update);
	}

	@Test
	public void listUsers() {
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		// �����ύ��ʽ2 openSession(true)Ĭ���ύ����
		SqlSession openSessions = sqlSessionFactory.openSession(true);
		String listStr = "com.test.entity.userMapper.listUser";
		List<User> list = openSessions.selectList(listStr);
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("ִ�����");
	}
}
