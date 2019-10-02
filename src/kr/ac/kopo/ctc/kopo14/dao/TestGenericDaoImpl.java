package kr.ac.kopo.ctc.kopo14.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo14.domain.TestAccount;
import kr.ac.kopo.ctc.kopo14.domain.TestAccountItem;

public class TestGenericDaoImpl <T> implements TestGenericDao<T> {
	
	private Connection open() {
		Connection conn = null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://192.168.56.101:3306/kopo","root","ykj0112");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public T create(T t) {
		//T t0 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();			

			t=create_overriding(stmt, t);
			
			stmt.close();
			conn.close();		//연결종료
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}		//T는 선언할때 Account를 넣어줄 수도 있고 AccountItem을 넣어줄 수도 있다

	@Override
	public T selectOne(int id) {
		T t1 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();	

			t1 = selectOne_overriding(stmt, id);
			
			stmt.close();
			conn.close();		//연결종료			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t1;
	}

	
	@Override
	public List<T> selectAll() {
		List<T> t2 = new ArrayList<T>();
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();	

			t2 = selectAll_overriding(stmt);
			
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t2;
	}

	@Override
	public List<T> selectAllContainingKind(String kind) {
		List<T> t3 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();

			t3 = selectAllContainingKind_overriding(stmt, kind);
			
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t3;
	}
	@Override
	public List<T> selectAllContainingCategory(String category) {
		List<T> t8 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();

			t8 = selectAllContainingCategory_overriding(stmt, category);
			
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t8;
	}
	
	@Override
	public List<T> selectAllContainingDetail(String detail) {
		List<T> t9 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();

			t9 = selectAllContainingDetail_overriding(stmt, detail);
			
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t9;
	}
	@Override
	public List<T> selectAllContainingTitle(String title) {
		List<T> t9 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();

			t9 = selectAllContainingTitle_overriding(stmt, title);
			
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t9;
	}
	
	@Override
	public T update(int id, T t) {
		T t4 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();
			
			t4 = update_overriding(stmt, id, t);
			
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t4;
	}

	@Override
	public T update(T t) {
		T t5 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();
		
			t5 = update_overriding(stmt, t);
		
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t5;
	}

	@Override
	public T delete(int id) {
		T t6 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();
		
			t6 = delete_overriding(stmt, id);
		
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t6;                                                                                                                                                                                                                                                                                                                                        
	}

	@Override
	public T delete(T t) {
		T t7 = null;
		try {
			Connection conn = open();
			Statement stmt = conn.createStatement();
		
			t7 = delete_overriding(stmt, t);
		
			stmt.close();
			conn.close();		//연결종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t7;
	}

	@Override
	public T create_overriding(Statement stmt, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T selectOne_overriding(Statement stmt, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectAll_overriding(Statement stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectAllContainingKind_overriding(Statement stmt, String kind) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<T> selectAllContainingCategory_overriding(Statement stmt, String category){
		return null;
	}
	@Override
	public List<T> selectAllContainingDetail_overriding(Statement stmt, String detail){
		return null;
	}

	@Override
	public T update_overriding(Statement stmt, int id, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update_overriding(Statement stmt, T t) {
		// TODO Auto-generated method stub
		return null;
	}
//	public T update_overriding(Statement stmt, String title) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public T delete_overriding(Statement stmt, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete_overriding(Statement stmt, T t) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<T> selectAllContainingTitle1(String title) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<T> selectAllContainingTitle_overriding(Statement stmt, String title) {
		// TODO Auto-generated method stub
		return null;
	}

@Override
public T update(TestAccountItem accountItem, String isuait) {
	// TODO Auto-generated method stub
	return null;
}






}
