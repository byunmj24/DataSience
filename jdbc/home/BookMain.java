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
//		select - 결과를 하나 selectOne (레코드가 하나 나오는 query문)
//				 결과를 여러개 selectList (레코드가 여러개) 
//		> 결과의 수가 아닌 쿼리를 보고 판단 / 판단이 힘들면 selectList로 사용
//		태그 늘어나면 mapper에 태그만 계속 늘려서 사용하면 된다
		System.out.println("책 전체수 : "+count);
		
		List<BookDTO> list = sql.selectList("book.bookAll");
		
		for( BookDTO dto : list ) {

			System.out.println("=================Book DTO===============");

			System.out.println("번호 : "+ dto.getNum());

			System.out.println("저자 : "+dto.getWriter());

			System.out.println("제목 : "+ dto.getTitle());

			System.out.println("내용 : "+dto.getContent());

			System.out.println("출판일 : "+ dto.getReg());
		}


		
		sql.close();
		
		
	}
}
