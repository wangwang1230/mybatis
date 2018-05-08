package com.test.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.test.entity.User;
import com.util.MybatisUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		//1.读取mybatis核心配置文件
//		String resource="conf.xml";
//		Reader resourceAsReader=Resources.getResourceAsReader(resource);
		//2. 构造sqlSession的工厂
		SqlSessionFactory sqlSessionFactory=MybatisUtil.getSqlSessionFactory();
		//3. 创建能执行映射文件的sqlSession
		SqlSession openSession=sqlSessionFactory.openSession();
		//4. 定义执行sql标示字符串    namespace.方法名
		String statement="com.test.entity.userMapper.getUser";
		User user= openSession.selectOne(statement,1);
		System.out.println(user.getName());
	}

}
