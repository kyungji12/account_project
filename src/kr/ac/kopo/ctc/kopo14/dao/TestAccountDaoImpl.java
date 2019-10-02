package kr.ac.kopo.ctc.kopo14.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; //자바에서 데이터베이스로 쿼리문 전송할때 사용하는 인터페이스
import java.text.SimpleDateFormat; //지정된 형식으로 날짜 및 시간 출력용
import java.util.ArrayList;
import java.util.Date; //날짜 출력용
import java.util.List; //자료형 클래스

import kr.ac.kopo.ctc.kopo14.domain.TestAccount;

public class TestAccountDaoImpl extends TestGenericDaoImpl<TestAccount> implements TestAccountDao {
//Account 테이블 
//////Create/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestAccount create_overriding(Statement stmt, TestAccount account) { 
		//Insert 부분		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //원하는 형식으로 날짜 및 시간 표현
		String created = transFormat.format(new Date());	//등록일인 created는 날짜 및 시간이 표시됨 
		
		try {
			stmt.execute( //쿼리문 실행을 위한 것
			"insert into TestAccount (title, created) values ('" + account.getTitle() + "', '" + created + "');");
					//Account테이블의 title, created컬럼에 값 입력
				//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute
			
		} catch (SQLException e) { //예외 발생시 
			//e.printStackTrace();
		}
		return null;
	}
///////Read////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public TestAccount selectOne_overriding(Statement stmt, int id) { //특정항목만(유니크값) 읽어올 때 사용
		TestAccount account = new TestAccount(); //Account class에서 return할 변수 새로 설정
		try {
			ResultSet rset = stmt.executeQuery("select * from TestAccount where id = " +id+ ";"); //Account테이블에서 특정 id의 데이터 조회
			//select등 쿼리 실행 후에 값을 가져와야하는 쿼리문의 경우 ResultSet rset = stmt.executeQuery(쿼리문);을 쓴다.
			if(rset.next()) { //rset의 값을 next();로 한줄씩 읽어들인다. 개행이나 공백문자는 무시하고 입력받음.
				account.setId(rset.getInt(1)); //받아온 int값이 계좌 식별자인 id로 set
				account.setTitle(rset.getString(2));//받아온 string값이 계좌 타입인 title로 set
				account.setCreated(rset.getDate(3));//받아온 시간 값이 등록일인 created로 set
			} //rset.close();
			  //return account;  ***********************************여기서 리턴값을 ret으로 해야하나? 
		} catch (Exception e) {
			e.printStackTrace();//예외처리
		}	
		return account;//반환되는 값 *******************************return null; 이라고 해야하나?
	}

	@Override
	public List<TestAccount> selectAll_overriding(Statement stmt) { //Account의 리스트를 모두 조회 
		ArrayList<TestAccount> accountList = new ArrayList<TestAccount>(); //ArrayList 새로 선언
		try {
			ResultSet rset = stmt.executeQuery("select * from TestAccount;");//Account 테이블 모든 값 조회
			//select등 쿼리 실행 후에 값을 가져와야하는 쿼리문의 경우 ResultSet rset = stmt.executeQuery(쿼리문);을 쓴다.
			while(rset.next()) {//rset의 값을 한줄씩 읽어온다. 
				TestAccount account = new TestAccount();
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
				accountList.add(account);
		} rset.close();
		
	} catch (Exception e) { //예외처리
		e.printStackTrace();
	}						
		return accountList; //반환값
}

	@Override
	public List<TestAccount> selectAllContainingTitle_overriding(Statement stmt, String title) { //Account의 리스트를 모두 조회
		ArrayList<TestAccount> accountList = new ArrayList<TestAccount>();//ArrayList 새로 선언
		try {
			ResultSet rset = stmt.executeQuery("select * from TestAccount where title like " + "'%" + title + "%';");
			while(rset.next()) {
				TestAccount account = new TestAccount();
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
				accountList.add(account);
			}
			rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return accountList; //accountList를 반환 
	}
///////Update/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestAccount update_overriding(Statement stmt, int id, TestAccount account) { //Account의 값을 수정
		try {			
			stmt.execute("update TestAccount set id = " + account.getId() + ", title = '"+
					account.getTitle() +"' where id = " + id +";");  //id를 수정
			//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute
			return account;			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	@Override
	public TestAccount update_overriding(Statement stmt, TestAccount account) {
		try {
			stmt.execute("update TestAccount set title = '"+ account.getTitle() +"' where id = " + account.getId() +";");
			//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute , title을 수정
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
///////Delete////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestAccount delete_overriding(Statement stmt, int id) {
		try {
			stmt.execute("delete from TestAccount where id = " + id +";");
			//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute , Account 테이블의 id를 삭제
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	@Override
	public TestAccount delete_overriding(Statement stmt, TestAccount account) {
		delete_overriding(stmt, account.getId());
//		try {		
//			stmt.execute("delete from TestAccount where id = " + account.getId() +";");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
		return null;
	}

}
