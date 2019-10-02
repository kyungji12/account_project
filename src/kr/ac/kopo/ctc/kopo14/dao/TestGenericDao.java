package kr.ac.kopo.ctc.kopo14.dao;
import java.sql.Statement;
import java.util.List;

import kr.ac.kopo.ctc.kopo14.domain.TestAccount;
import kr.ac.kopo.ctc.kopo14.domain.TestAccountItem;
import kr.ac.kopo.ctc.kopo14.domain.TestCategory;

public interface TestGenericDao<T> {		//T는 선언할때 Account를 넣어줄 수도 있고 AccountItem을 넣어줄 수도 있다
	// C
	T create(T t);
	T create_overriding(Statement stmt, T t);
	
	// R
	T selectOne(int id);		//하나 select
	T selectOne_overriding(Statement stmt, int id);
	
	List<T> selectAll();		//전부 select
	List<T> selectAll_overriding(Statement stmt);		//전부 select
	
	List<T> selectAllContainingTitle(String title);	//title이 포함된 selectAll?
	List<T> selectAllContainingTitle_overriding(Statement stmt, String title);	//title이 포함된 selectAll?
	List<T> selectAllContainingKind(String kind);
	List<T> selectAllContainingKind_overriding(Statement stmt, String kind);
	List<T>	selectAllContainingCategory(String category);
	List<T> selectAllContainingCategory_overriding(Statement stmt, String category);
	List<T> selectAllContainingDetail(String detail);
	List<T> selectAllContainingDetail_overriding(Statement stmt, String detail);
	// U
	T update(int id, T t);
	T update(TestAccountItem accountItem, String isuait);
	T update_overriding(Statement stmt, int id, T t);
	
	T update(T t);
	T update_overriding(Statement stmt, T t);
	
	// D
	T delete(int id);
	T delete_overriding(Statement stmt, int id);
	T delete(T t);
	T delete_overriding(Statement stmt, T t);
	
	
	
	
	
	
}
