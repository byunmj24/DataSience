package test.jdbc.bean;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
//	Ŭ���� �ʱ�ȭ ��
	static { 
//		�������� �� mybatis ������ �ϰ��ִ� XML ��� �б�
		try{
			Reader reader = Resources.getResourceAsReader("test/jdbc/mybatis/mybatis_config.xml"); 
//					������ ����		����� xml������ �д´�
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//														�������� ����� �� �ְ� ���� ������ �غ��Ų��
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
//		Session - JDBC�۾��� �� �� �ִ� ��ü
	}
}
