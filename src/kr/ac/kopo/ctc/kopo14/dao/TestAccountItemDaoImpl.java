package kr.ac.kopo.ctc.kopo14.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.ctc.kopo14.domain.TestAccount;
import kr.ac.kopo.ctc.kopo14.domain.TestAccountItem;
//import kr.ac.kopo.ctc.kopo14.dao.TestAccountDao;
//import kr.ac.kopo.ctc.kopo14.dao.TestAccountDaoImpl;
import kr.ac.kopo.ctc.kopo14.dao.TestAccountItemDao;
import kr.ac.kopo.ctc.kopo14.dao.TestAccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo14.domain.TestKind;
import kr.ac.kopo.ctc.kopo14.domain.TestCategory;
//import kr.ac.kopo.ctc.kopo14.dao.TestKindDao;
//import kr.ac.kopo.ctc.kopo14.dao.TestKindDaoImpl;
//import kr.ac.kopo.ctc.kopo14.dao.TestCategoryDao;
//import kr.ac.kopo.ctc.kopo14.dao.TestCategoryDaoImpl;

public class TestAccountItemDaoImpl extends TestGenericDaoImpl<TestAccountItem> implements TestAccountItemDao {
//AccountItem 테이블 
//////Create/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestAccountItem create_overriding(Statement stmt, TestAccountItem accountItem) {
		//Insert 부분
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //원하는 형식으로 날짜 및 시간 표현
		String created = transFormat.format(new Date());	//등록일인 created는 날짜 및 시간이 표시됨 
		try {
			String sql = "insert into TestAccountItem(account_id,kind,category,detail,type,amount,created) value ('" 
					+ accountItem.getAccount_id().getId() + "', '" + accountItem.getKind().getKind() + "','"
					+ accountItem.getCategory().getCategory() + "','" + accountItem.getDetail() +"','"
					+ accountItem.getType() + "','" + accountItem.getAmount() + "','" + created + "');";
//			System.out.println(sql);
			stmt.execute(sql);	//테이블 생성문
			//Account테이블의 title, created컬럼에 값 입력
			//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute
		} catch (SQLException e) { //예외 발생시 
			//e.printStackTrace();
		}
		return null;
	}
	
///////Read////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public TestAccountItem selectOne_overriding(Statement stmt, int id) {//특정항목만(유니크값) 읽어올 때 사용
		TestAccountItem accountItem = new TestAccountItem(); //AccountItem class에서 return할 변수 새로 설정
		TestAccount account = new TestAccount();
		
		TestCategoryDao categoryDao =new TestCategoryDaoImpl();
		TestKindDao kindDao = new TestKindDaoImpl();
		TestKind kind = new TestKind();
		TestCategory category = new TestCategory();
		try { //a=Account , b=AccountItem
			ResultSet rset = stmt.executeQuery("SELECT a.id, a.title, a.created,"
					+ " b.id, b.account_id, b.kind, b.category, b.detail, b.TYPE, b.amount, b.created, c.no " + 
					"FROM TestAccountItem AS b JOIN TestAccount AS a ON b.account_id = a.id " + 
					"JOIN TestKind AS c ON b.kind = c.kind " + 
					"JOIN TestCategory AS d ON b.category = d.category " + 
					"WHERE b.account_id = a.id;");
			
			
			if(rset.next()) { //rset의 값을 next();로 한줄씩 읽어들인다. 개행이나 공백문자는 무시하고 입력받음.
			
			account.setId(rset.getInt(1));
			account.setTitle(rset.getString(2));
			account.setCreated(rset.getDate(3));
		
			accountItem.setId(rset.getInt(4));
			accountItem.setAccount_id(account);
			
			kind.setNo(rset.getInt(12));
			accountItem.setKind(kind);
			
			category.setCategory(rset.getString(7));
			accountItem.setCategory(category);
			
			accountItem.setDetail(rset.getString(8));//받아온 string값이 계좌 타입인 title로 set
			
			accountItem.setType(rset.getString(9));
			accountItem.setAmount(rset.getInt(10));
			accountItem.setCreated(rset.getDate(11));//받아온 시간 값이 등록일인 created로 set
			} //rset.close();
			  //return ret;  ***********************************여기서 리턴값을 ret으로 해야하나? 
		} catch (Exception e) {
			e.printStackTrace();//예외처리
		}	
		return accountItem;//반환되는 값 *******************************return null; 이라고 해야하나?
	}

	@Override
	public List<TestAccountItem> selectAll_overriding(Statement stmt) { //Account의 리스트를 모두 조회 
		ArrayList<TestAccountItem> accountItemList = new ArrayList<TestAccountItem>(); //ArrayList 새로 선언
	
		try {
			ResultSet rset = stmt.executeQuery("SELECT a.id, a.title, a.created,"
					+ " b.id, b.account_id, b.kind, b.category, b.detail, b.TYPE, b.amount, b.created, c.kind " + 
					"FROM TestAccountItem AS b JOIN TestAccount AS a ON b.account_id = a.id " + 
					"JOIN TestKind AS c ON b.kind = c.kind " + 
					"JOIN TestCategory AS d ON b.category = d.category " + 
					"WHERE b.account_id = a.id;");//AccountItem 테이블 모든 값 조회
			//select등 쿼리 실행 후에 값을 가져와야하는 쿼리문의 경우 ResultSet rset = stmt.executeQuery(쿼리문);을 쓴다.
			while(rset.next()) {
				TestAccount account = new TestAccount();
				TestAccountItem accountItem = new TestAccountItem();
				
				TestKind kind = new TestKind();
				TestCategory category = new TestCategory();
				///////////////////////////////////////////
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
			
				accountItem.setId(rset.getInt(4));
				accountItem.setAccount_id(account);
				
				kind.setKind(rset.getString(12));
				accountItem.setKind(kind);
				
				category.setCategory(rset.getString(7));
				accountItem.setCategory(category);
				
				accountItem.setDetail(rset.getString(8));//받아온 string값이 계좌 타입인 title로 set
				
				accountItem.setType(rset.getString(9));
				accountItem.setAmount(rset.getInt(10));
				accountItem.setCreated(rset.getDate(11));
				
				accountItemList.add(accountItem);
			}
			rset.close();
			return accountItemList; //반환값
		} catch (Exception e) { //예외처리
			e.printStackTrace();
		}						
		return null;
	}

	@Override
	public List<TestAccountItem> selectAllContainingKind_overriding(Statement stmt, String kind) {//Account의 리스트를 모두 조회 
		List<TestAccountItem> accountItemList = new ArrayList<TestAccountItem>(); //ArrayList 새로 선언	
		
		try {
			ResultSet rset = stmt.executeQuery("SELECT a.id, a.title, a.created,"
					+ " b.id, b.account_id, b.kind, b.category, b.detail, b.TYPE, b.amount, b.created, c.kind " + 
					"FROM TestAccountItem AS b JOIN TestAccount AS a ON b.account_id = a.id " + 
					"JOIN TestKind AS c ON b.kind = c.kind " + 
					"JOIN TestCategory AS d ON b.category = d.category " +"where b.kind ='" + kind + "';");
			//select등 쿼리 실행 후에 값을 가져와야하는 쿼리문의 경우 ResultSet rset = stmt.executeQuery(쿼리문);을 쓴다.
			//타이틀이 비슷한 것을 찾아서 조회 
			while(rset.next()) {
				TestAccountItem accountItem = new TestAccountItem();
				TestKind kk = new TestKind();
				TestAccount account = new TestAccount();
				TestCategory cc = new TestCategory();
				///////////////////////////////////////////
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
			
				accountItem.setId(rset.getInt(4));
				accountItem.setAccount_id(account);
				
				kk.setKind(rset.getString(12));
				accountItem.setKind(kk);
				
				cc.setCategory(rset.getString(7));
				accountItem.setCategory(cc);
				
				accountItem.setDetail(rset.getString(8));//받아온 string값이 계좌 타입인 title로 set
				
				accountItem.setType(rset.getString(9));
				accountItem.setAmount(rset.getInt(10));
				accountItem.setCreated(rset.getDate(11));
				accountItemList.add(accountItem);
			}
			rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return accountItemList;
	}
	
	@Override
	public List<TestAccountItem> selectAllContainingCategory_overriding(Statement stmt, String category) {//Account의 리스트를 모두 조회 
		List<TestAccountItem> accountItemList = new ArrayList<TestAccountItem>(); //ArrayList 새로 선언	
		
		try {
			ResultSet rset = stmt.executeQuery("SELECT a.id, a.title, a.created,"
					+ " b.id, b.account_id, b.kind, b.category, b.detail, b.TYPE, b.amount, b.created, c.kind " + 
					"FROM TestAccountItem AS b JOIN TestAccount AS a ON b.account_id = a.id " + 
					"JOIN TestKind AS c ON b.kind = c.kind " + 
					"JOIN TestCategory AS d ON b.category = d.category " +"where b.category ='" + category + "';");
			//select등 쿼리 실행 후에 값을 가져와야하는 쿼리문의 경우 ResultSet rset = stmt.executeQuery(쿼리문);을 쓴다.
			//타이틀이 비슷한 것을 찾아서 조회 
			while(rset.next()) {
				TestAccountItem accountItem = new TestAccountItem();
				TestKind kk = new TestKind();
				TestAccount account = new TestAccount();
				TestCategory cc = new TestCategory();
				///////////////////////////////////////////
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
			
				accountItem.setId(rset.getInt(4));
				accountItem.setAccount_id(account);
				
				kk.setKind(rset.getString(12));
				accountItem.setKind(kk);
				
				cc.setCategory(rset.getString(7));
				accountItem.setCategory(cc);
				
				accountItem.setDetail(rset.getString(8));//받아온 string값이 계좌 타입인 title로 set
				
				accountItem.setType(rset.getString(9));
				accountItem.setAmount(rset.getInt(10));
				accountItem.setCreated(rset.getDate(11));
				accountItemList.add(accountItem);
			}
			rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return accountItemList;
	}
	
	
	@Override
	public List<TestAccountItem> selectAllContainingDetail_overriding(Statement stmt, String detail) {//Account의 리스트를 모두 조회 
		List<TestAccountItem> accountItemList = new ArrayList<TestAccountItem>(); //ArrayList 새로 선언	
		
		try {
			ResultSet rset = stmt.executeQuery("SELECT a.id, a.title, a.created,"
					+ " b.id, b.account_id, b.kind, b.category, b.detail, b.TYPE, b.amount, b.created, c.kind " + 
					"FROM TestAccountItem AS b JOIN TestAccount AS a ON b.account_id = a.id " + 
					"JOIN TestKind AS c ON b.kind = c.kind " + 
					"JOIN TestCategory AS d ON b.category = d.category " +"where b.detail ='" + detail + "';");
			//select등 쿼리 실행 후에 값을 가져와야하는 쿼리문의 경우 ResultSet rset = stmt.executeQuery(쿼리문);을 쓴다.
			//타이틀이 비슷한 것을 찾아서 조회 
			while(rset.next()) {
				TestAccountItem accountItem = new TestAccountItem();
				TestKind kk = new TestKind();
				TestAccount account = new TestAccount();
				TestCategory cc = new TestCategory();
				///////////////////////////////////////////
				account.setId(rset.getInt(1));
				account.setTitle(rset.getString(2));
				account.setCreated(rset.getDate(3));
			
				accountItem.setId(rset.getInt(4));
				accountItem.setAccount_id(account);
				
				kk.setKind(rset.getString(12));
				accountItem.setKind(kk);
				
				cc.setCategory(rset.getString(7));
				accountItem.setCategory(cc);
				
				accountItem.setDetail(rset.getString(8));//받아온 string값이 계좌 타입인 title로 set
				
				accountItem.setType(rset.getString(9));
				accountItem.setAmount(rset.getInt(10));
				accountItem.setCreated(rset.getDate(11));
				accountItemList.add(accountItem);
			}
			rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return accountItemList;
	}
///////Update/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestAccountItem update_overriding(Statement stmt, int id, TestAccountItem accountItem) { //AccountItem의 값을 수정
		try {
			stmt.execute("update TestAccountItem set detail = '" + 
					accountItem.getDetail() + "' where id = " + id +";"); //id를 수정
			//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute
			System.out.println(accountItem.getDetail());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return accountItem;	
	}

//	@Override
//	public AccountItem update_overriding(Statement stmt, AccountItem accountItem) {
//		try {
//			stmt.execute("update AccountItem set title = '"+ accountItem.getTitle() +"' where id = " + accountItem.getId() +";");
//			//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute , title을 수정
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
//		return null;
//	}
///////Delete////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestAccountItem delete_overriding(Statement stmt, int id) {
		try {
			stmt.execute("delete from TestAccountItem where id = " + id +";");
			//쿼리 실행 후 값을 가져오지 않아도 된다면 그냥 stmt.execute , AccountItem 테이블의 id를 삭제
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

//	@Override
//	public TestAccountItem delete_overriding(Statement stmt, TestAccountItem accountItem) {
//		delete_overriding(stmt, accountItem.getId());
////		try {
////			stmt.execute("delete from AccountItem where id = " + accountItem.getId() +";");
////		} catch (Exception e) {
////			e.printStackTrace();
////		}	
//		return null;
//	}
	
}
