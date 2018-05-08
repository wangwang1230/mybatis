package com.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	public static SqlSessionFactory getSqlSessionFactory(){
		// 1.��ȡmybatis���������ļ�
		String resource = "conf.xml";
		Reader resourceAsReader =null;
		try {
			resourceAsReader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 2. ����sqlSession�Ĺ���
		SqlSessionFactory sqlSessionFactory=null;
		if(resourceAsReader!=null){
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
		}
		return sqlSessionFactory;
	}
}
