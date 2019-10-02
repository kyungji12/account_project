package kr.ac.kopo.ctc.kopo14.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.ctc.kopo14.domain.TestAccount;
import kr.ac.kopo.ctc.kopo14.domain.TestKind;

public class TestKindDaoImpl extends TestGenericDaoImpl<TestKind> implements TestKindDao {

//////Create/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestKind create_overriding(Statement stmt, TestKind kind) { 
		try {
			stmt.execute( //쿼리문 실행을 위한 것
			"insert into TestKind (kind) values ('" + kind.getKind() + "');");
		} catch (SQLException e) { 
		}
		return null;
	}
///////Read////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public TestKind selectOne_overriding(Statement stmt, int no) { 
		TestKind kind = new TestKind(); 
		try {
			ResultSet rset = stmt.executeQuery("select * from TestKind where no=" +no+ ";"); 
			if(rset.next()) { 
				kind.setNo(rset.getInt(1)); 
				kind.setKind(rset.getString(2));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return kind;
	}

	@Override
	public List<TestKind> selectAll_overriding(Statement stmt) { 
		ArrayList<TestKind> kindList = new ArrayList<TestKind>(); 
		try {
			ResultSet rset = stmt.executeQuery("select * from TestKind;");
			while(rset.next()) {
				TestKind kind = new TestKind();
				kind.setNo(rset.getInt(1));
				kind.setKind(rset.getString(2));
				kindList.add(kind);
		} rset.close();
		return kindList; 
	} catch (Exception e) { 
		e.printStackTrace();
	}						
	return null; 
}

	@Override
	public List<TestKind> selectAllContainingKind_overriding(Statement stmt, String kind) { 
		ArrayList<TestKind> kindList = new ArrayList<TestKind>();
		try {
			ResultSet rset = stmt.executeQuery("select a.no, a.kind, b.no, b.category from TestKind as a "
					+ "join TestCategory as b on a.no = b.kind_no where kind ='" + kind + "';");
			while(rset.next()) {
				TestKind kindTest = new TestKind();
				kindTest.setNo(rset.getInt(1));
				kindTest.setKind(rset.getString(2));
				kindList.add(kindTest);
			}
			rset.close();
			return kindList; 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
///////Update/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestKind update_overriding(Statement stmt, int no, TestKind kind) { 
		try {			
			stmt.execute("update TestKind set no = " + kind.getNo() + ", kind = '"+
					kind.getKind() +"' where no = " + no +";");
			return kind;			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	@Override
	public TestKind update_overriding(Statement stmt, TestKind kind) {
		try {
			stmt.execute("update TestKind set kind = '"+ kind.getKind() +"' where no = " + kind.getNo() +";");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
///////Delete////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestKind delete_overriding(Statement stmt, int no) {
		try {
			stmt.execute("delete from TestKind where no = " + no +";");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	@Override
	public TestKind delete_overriding(Statement stmt, TestKind kind) {
		delete_overriding(stmt, kind.getNo());	
		return null;
	}

}

