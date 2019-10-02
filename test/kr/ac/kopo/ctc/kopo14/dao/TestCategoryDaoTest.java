package kr.ac.kopo.ctc.kopo14.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.ac.kopo.ctc.kopo14.dao.TestKindDao;
import kr.ac.kopo.ctc.kopo14.dao.TestKindDaoImpl;
import kr.ac.kopo.ctc.kopo14.dao.TestCategoryDao;
import kr.ac.kopo.ctc.kopo14.dao.TestCategoryDaoImpl;
import kr.ac.kopo.ctc.kopo14.domain.TestKind;
import kr.ac.kopo.ctc.kopo14.domain.TestCategory;

public class TestCategoryDaoTest {
	//----Insert----------------------------------------완료
		@Test
		public void testCreate() {
			TestCategoryDao categoryDao = new TestCategoryDaoImpl();
			TestKindDao kindDao = new TestKindDaoImpl();
			TestKind kind = new TestKind();
			TestCategory category = new TestCategory();
			
			kind= kindDao.selectOne(2);
			category.setKind_no(kind);
			
			category.setCategory("기타");
			
			categoryDao.create(category);
			
			System.out.print("insert 완료");
		}
		
	////----Select----------------------------------------완료
//		@Test
//		public void testSelectOne() {
//			TestCategoryDao categoryDao = new TestCategoryDaoImpl();
//			TestCategory category = categoryDao.selectOne(5);
//			assertEquals(category.getCategory(),"밀크티");
////			System.out.printf("%3s%12s%15s%6s%6s%10s%12s\n","id","account_id","detail","kind","type","amount","created");
////			System.out.printf("%3s%12s%10s%6s%6s%10s%18s\n",
////					+ accountItem.getId(),accountItem.getAccount_id().getId(),
////					accountItem.getDetail(),accountItem.getKind(),accountItem.getType(),
////					accountItem.getAmount(),accountItem.getCreated() );
//			System.out.println("\nselect 완료\n");      //완료 메세지 출력
//		}
//		
//		
//////		@Test---------------------------------완료
//		public void testSelectAll() {
//			TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//			List<TestAccountItem> accountItem = new ArrayList<TestAccountItem>();
//			accountItem = accountItemDao.selectAll();
//			for (int i=0; i<accountItem.size(); i++) {
//				System.out.println(accountItem.get(i));
//			}
//		}
////		@Test ----------다시 해야합니더
//		public void testSelectAllContainingTitle() {
//			TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//			List<TestAccountItem> accountItem = accountItemDao.selectAll();
//			assertEquals(accountItem.size(),3);
//	  }
//		
//	//////----Update----------------------------------------완료
//		@Test
//		public void testUpdate() {
//			TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//			TestAccountItem accountItem = new TestAccountItem();
//			accountItem = accountItemDao.selectOne(5);
//			assertEquals(accountItem.getDetail(),"공차");
//			
//			accountItem.setDetail("밀크티");
//			accountItemDao.update(5, accountItem);
//			assertEquals(accountItem.getDetail(),"밀크티");
//			System.out.println("\nupdate 완료");      //완료 메세지 출력
//		   }
//	//////----Delete----------------------------------------완료
//	 @Test  
//		public void testDelete() {
//		 TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
//		      TestAccountItem accountItem = new TestAccountItem();
//		      accountItemDao.delete(6);
//		      System.out.println("\n\ndelete 완료");      //완료 메세지 출력
//		   }
//

	}

