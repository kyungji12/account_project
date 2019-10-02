package kr.ac.kopo.ctc.kopo14.dao;
import java.sql.Statement;
import java.util.List;

import kr.ac.kopo.ctc.kopo14.domain.TestAccountItem;

public interface TestAccountItemDao extends TestGenericDao<TestAccountItem>{

	
//	// C
//	AccountItem create(AccountItem accountItem);	//저장하고 싶은게 parameter 저장된 객체를 return
//		
//	// R
//	AccountItem selectOne(int id);		//하나 select
//	List<AccountItem> selectAll();		//전부 select
//	List<AccountItem> selectAllContainingTitle(String title);	//title이 포함된 selectAll?
//	
//	// U
//	AccountItem update(int id, AccountItem accountItem);
//	AccountItem update(AccountItem accountItem);
//	
//	// D
//	AccountItem delete(int id);
//	AccountItem delete(AccountItem accountItem);
}
