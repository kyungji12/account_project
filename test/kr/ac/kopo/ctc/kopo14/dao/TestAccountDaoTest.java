package kr.ac.kopo.ctc.kopo14.dao;

import kr.ac.kopo.ctc.kopo14.dao.TestAccountDao;
import kr.ac.kopo.ctc.kopo14.dao.TestAccountDaoImpl;
import kr.ac.kopo.ctc.kopo14.domain.TestAccount;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestAccountDaoTest {
//----Insert----------------------------------------
		@Test
	public void testCreate() {
		TestAccountDao accountDao = new TestAccountDaoImpl();
		TestAccount account = new TestAccount();
		account.setTitle("모임용");
		accountDao.create(account);	
	}
	
//////----Select----------------------------------------
	@Test
	public void testSelectOne() {
		TestAccountDao accountDao = new TestAccountDaoImpl();
		//인터페이스를 통해서 impl객체 만들고
		TestAccount account = new TestAccount();
		//결과값을 받아올 Account객체도 만들고 (여기서 게터로 결과를 받아옴)
		account = accountDao.selectOne(2); //id불러오기 실행 (?)
		
		System.out.printf("%3s%8s%12s\n","id","title","created");
		System.out.printf("%3s%5s%15s\n",
                account.getId(), account.getTitle(), account.getCreated());
		
		System.out.println("\nselect 완료\n");      //완료 메세지 출력
	}
	@Test
	public void testSelectAll() {
		TestAccountDao accountDao = new TestAccountDaoImpl();
		List<TestAccount> List = new ArrayList<TestAccount>();
		List = accountDao.selectAll();
		
		System.out.printf("%3s%8s%10s\n","id","title","created");
		for(int i=0; i<List.size(); i++) {
		System.out.printf("%3s%5s%12s\n",
                List.get(i).getId(), List.get(i).getTitle(), List.get(i).getCreated());
		}
		System.out.println("\nselect 완료\n");      //완료 메세지 출력
	}
	/////////////////////////////////////////////////////////////////
	@Test
	public void selectAllContainingTitle() {
		TestAccountDao accountDao = new TestAccountDaoImpl();
		List<TestAccount> List = new ArrayList<TestAccount>();
		List = accountDao.selectAllContainingTitle("개인용");
		
		System.out.printf("%3s%8s%10s\n","id","title","created");
		for(int i=0; i<List.size(); i++) {
			System.out.printf("%3s%5s%12s\n",
	                List.get(i).getId(), List.get(i).getTitle(), List.get(i).getCreated());
		}
		System.out.println("\nselect 완료\n");      //완료 메세지 출력
	}
/////////////////////////////////////////////////////////////////////
//////----Update----------------------------------------완료
	@Test
	public void testUpdate() {
		TestAccountDao accountDao = new TestAccountDaoImpl();
		TestAccount account = new TestAccount();
		account.setTitle("하하");
		accountDao.update(0, account);

		System.out.println("\nselect 완료\n");      //완료 메세지 출력
	}
	
//////----Delete----------------------------------------완료
	@Test
	public void testDelete() {
		TestAccountDao accountDao = new TestAccountDaoImpl();
		TestAccount account = new TestAccount();
		accountDao.delete(3);
		//완료메시지
        System.out.println("\n\ndelete 완료");      //완료 메세지 출력
	  }
	
////	@Test
////	public void testCreat() {
////		assertEquals(1,1); //1과 2가 똑같은 것인가?
////		
////	}
//	
//
//

}
