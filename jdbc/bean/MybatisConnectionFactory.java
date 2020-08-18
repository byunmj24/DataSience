package test.jdbc.bean;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
//	클래스 초기화 블럭
	static { 
//		접속정보 및 mybatis 설정을 하고있는 XML 경로 읽기
		try{
			Reader reader = Resources.getResourceAsReader("test/jdbc/mybatis/mybatis_config.xml"); 
//					리더에 대입		경로의 xml파일을 읽는다
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//														언제든지 사용할 수 있게 연결 정보를 준비시킨다
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
//		Session - JDBC작업을 할 수 있는 객체
	}
}
