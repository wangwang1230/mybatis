package com.test.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.test.entity.User;
import com.util.MybatisUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		//1.��ȡmybatis���������ļ�
//		String resource="conf.xml";
//		Reader resourceAsReader=Resources.getResourceAsReader(resource);
		//2. ����sqlSession�Ĺ���
		SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSessionFactory();
		//3. ������ִ��ӳ���ļ���sqlSession
		SqlSession openSession=sqlSessionFactory.openSession();
		//4. ����ִ��sql��ʾ�ַ���    namespace.������
		String statement="com.test.entity.userMapper.getUser";
		User user= openSession.selectOne(statement,1);
		System.out.println(user.getName());
	}

}
