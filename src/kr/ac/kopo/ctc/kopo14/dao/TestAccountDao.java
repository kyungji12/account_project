package kr.ac.kopo.ctc.kopo14.dao;

import java.sql.Statement;
import java.util.List;
/* List는 배열의 한계 때문에 만들어진 자료형
 * List 는 메모리가 허용하는 한 계속 해서 추가 할 수 있도록 만든 자료형 클래스
 */
import kr.ac.kopo.ctc.kopo14.domain.TestAccount; //Account class에서 변수 받아오기

public interface TestAccountDao extends TestGenericDao<TestAccount> {

//	//c
//	Account create(Account account); //id와 created는 따로 안넣어줘도 알아서 채워짐
//	
//제네릭에서 상속받으므로 삭제	
	
	//r
//	Account selectOne(int id); //유니크한 값을 가져와서 넣어주면 해당 데이터를 가져옴
//	List<Account> selectAll(); //리스트 전체 뽑으려고
//	List<Account> selectAllContainingTitle(String title); //해당 타이틀로 검색하려고
	
	//u
//	Account update(int id);	
	
	//d
//	Account delete(int id);	
}