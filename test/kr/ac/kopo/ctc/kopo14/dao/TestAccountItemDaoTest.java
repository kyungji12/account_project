package kr.ac.kopo.ctc.kopo14.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import org.junit.Test;

//import org.junit.Test;

import kr.ac.kopo.ctc.kopo14.dao.TestAccountDao;
import kr.ac.kopo.ctc.kopo14.dao.TestAccountDaoImpl;
import kr.ac.kopo.ctc.kopo14.dao.TestAccountItemDao;
import kr.ac.kopo.ctc.kopo14.dao.TestAccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo14.domain.TestAccount;
import kr.ac.kopo.ctc.kopo14.domain.TestAccountItem;
import kr.ac.kopo.ctc.kopo14.domain.TestKind;
import kr.ac.kopo.ctc.kopo14.domain.TestCategory;

public class TestAccountItemDaoTest {
//----Insert----------------------------------------완료
	
//	@Test
//	public void testCreate() {
//		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//		TestAccountDao accountDao = new TestAccountDaoImpl();
//		TestAccount account = new TestAccount();
//		TestAccountItem accountItem = new TestAccountItem();
//		
//		TestCategoryDao categoryDao =new TestCategoryDaoImpl();
//		TestKindDao kindDao = new TestKindDaoImpl();
//		TestKind kind = new TestKind();//지출/수입
//		TestCategory category = new TestCategory();//카테고리
//		
//		account= accountDao.selectOne(1); //개인용
//		accountItem.setAccount_id(account);
//		//System.out.println("1");
//		System.out.println(account.getId());
//		
//		accountItem.setDetail("로또삼");
//		//System.out.println("2");
//		
//		
//		kind=kindDao.selectOne(1); //지출
//		accountItem.setKind(kind);
//		//System.out.println("3");
//		System.out.println(accountItem.getKind().getKind());
//		
//		category=categoryDao.selectOne(4);//카테고리 -식비
//		accountItem.setCategory(category);
//		//System.out.println("4");
//		System.out.println(accountItem.getCategory().getCategory());
//		
//		accountItem.setType("카드");
//		accountItem.setAmount(50000);
//		//System.out.println("5");
//		
//		accountItemDao.create(accountItem);
//		//System.out.print("insert 완료");
//	}
	
//////----Select----------------------------------------완료
//	@Test
//	public void testSelectOne() {
//		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//		TestAccountDao accountDao = new TestAccountDaoImpl();
//		TestAccount account = new TestAccount();
//		account = accountDao.selectOne(1);
//		TestAccountItem accountItem = accountItemDao.selectOne(1);
//		
//		TestCategoryDao categoryDao =new TestCategoryDaoImpl();
//		TestKindDao kindDao = new TestKindDaoImpl();
//		TestKind kind = new TestKind();//지출/수입
//		TestCategory category = new TestCategory();//카테고리
//		
//		
//		assertEquals(accountItem.getKind(),"지출");
//		System.out.printf("%3s	%1s	%4s	%8s	%6s			%6s	%-10s	%-12s\n",
//				"id","account_id","kind","category","detail","type","amount","created");
//		System.out.println("-----------------------------------------------------------"
//				+ "-----------------------------------------------");
//		System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
//				+ accountItem.getId(),accountItem.getAccount_id().getId(),
//				accountItem.getKind().getKind(),accountItem.getCategory().getCategory(),
//				accountItem.getDetail(),accountItem.getType(),accountItem.getAmount(),
//				accountItem.getCreated() );
//		System.out.println("\nselect 완료\n");      //완료 메세지 출력
//	
//		
//	}
//	
//	@Test
//	public void testSelectAllcontainingKind() {
//		//TestAccountDao accountDao = new TestAccountDaoImpl();
//		//TestAccount account = new TestAccount();
//		//account = accountDao.selectOne(1);
//		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//		
//		
//		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingKind("지출");
//		
//		System.out.printf("%3s	%1s	%4s	%8s	%6s			%6s	%-10s	%-12s\n","id","account_id","kind","category","detail","type","amount","created");
//		System.out.println("----------------------------------------------------------------------------------------------------------");
//		for (int i=0; i<accountItem.size(); i++) {
//			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
//					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
//					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
//					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
//					accountItem.get(i).getCreated() );
//
//		}
//		
//	}
//	@Test
//	public void testSelectAllcontainingCategory() {
//		//TestAccountDao accountDao = new TestAccountDaoImpl();
//		//TestAccount account = new TestAccount();
//		//account = accountDao.selectOne(1);
//		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//		
//		
//		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("식비");
//		System.out.printf("%3s	%1s	%4s	%8s	%6s			%6s	%-10s	%-12s\n","id","account_id","kind","category","detail","type","amount","created");
//		System.out.println("----------------------------------------------------------------------------------------------------------");
//		for (int i=0; i<accountItem.size(); i++) {
//			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
//					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
//					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
//					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
//					accountItem.get(i).getCreated() );
//
//		}
//		
//	}
	
	
	
	
////////	@Test---------------------------------완료
//	@Test
//	public void testSelectAll() {
//		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//		TestAccountDao accountDao = new TestAccountDaoImpl();
//		TestAccount account = new TestAccount();
//		List<TestAccountItem> accountItem = accountItemDao.selectAll();
//		account = accountDao.selectOne(1);
//		
//		TestCategoryDao categoryDao =new TestCategoryDaoImpl();
//		TestKindDao kindDao = new TestKindDaoImpl();
//		TestKind kind = new TestKind();//지출/수입
//		TestCategory category = new TestCategory();//카테고리
//		
//		
//		accountItem = accountItemDao.selectAll();
//		System.out.printf("%3s	%1s	%4s	%8s	%6s			%6s	%-10s	%-12s\n","id","account_id","kind","category","detail","type","amount","created");
//		System.out.println("----------------------------------------------------------------------------------------------------------");
//		for (int i=0; i<accountItem.size(); i++) {
//			
//			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
//					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
//					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
//					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
//					accountItem.get(i).getCreated() );
//		}
//	}
	
//////////----Update----------------------------------------완료
	

//	@Test
//	public void testUpdate() {
//		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//		TestAccountItem accountItem = new TestAccountItem();
//		accountItem.setDetail("공차"); //바꿀 것을 넣는것
//		accountItemDao.update(34, accountItem);
//		assertEquals(accountItem.getDetail(),"공차");
//		System.out.println("\nupdate 완료");  
//		
//	}
	@Test
	public void testUpdateDetail() {
		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
		TestAccountItem accountItem = new TestAccountItem();
//		accountItem = accountItemDao.selectOne(1);
//		assertEquals(accountItem.getDetail(),"공차");
//		
		accountItem.setDetail("아이스티");
		accountItemDao.update(76, accountItem);
		assertEquals(accountItem.getDetail(),"아이스티");
		System.out.println("\nupdate 완료");      //완료 메세지 출력
	   }
////////----Delete----------------------------------------완료
//@Test  
//	public void testDelete() {
//	 TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//	      TestAccountItem accountItem = new TestAccountItem();
//	      accountItemDao.delete(68);
//	      System.out.println("\n\ndelete 완료");      //완료 메세지 출력
//	   }


}
