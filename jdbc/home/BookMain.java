package test.jdbc.home;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import test.jdbc.bean.BookDTO;
import test.jdbc.bean.MybatisConnectionFactory;

public class BookMain {
	public static void main(String[] args) {
		SqlSession sql = MybatisConnectionFactory.getSqlSession();
		
		int count = sql.selectOne("book.bookCount");
//									namespace.id
//		select - ����� �ϳ� selectOne (���ڵ尡 �ϳ� ������ query��)
//				 ����� ������ selectList (���ڵ尡 ������) 
//		> ����� ���� �ƴ� ������ ���� �Ǵ� / �Ǵ��� ����� selectList�� ���
//		�±� �þ�� mapper�� �±׸� ��� �÷��� ����ϸ� �ȴ�
		System.out.println("å ��ü�� : "+count);
		
		List<BookDTO> list = sql.selectList("book.bookAll");
		
		for( BookDTO dto : list ) {

			System.out.println("=================Book DTO===============");

			System.out.println("��ȣ : "+ dto.getNum());

			System.out.println("���� : "+dto.getWriter());

			System.out.println("���� : "+ dto.getTitle());

			System.out.println("���� : "+dto.getContent());

			System.out.println("������ : "+ dto.getReg());
		}


		
		sql.close();
		
		
	}
}
