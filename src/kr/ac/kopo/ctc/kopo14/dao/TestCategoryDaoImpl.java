package kr.ac.kopo.ctc.kopo14.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo14.domain.TestKind;
import kr.ac.kopo.ctc.kopo14.domain.TestCategory;

public class TestCategoryDaoImpl extends TestGenericDaoImpl<TestCategory> implements TestCategoryDao {
//////Create/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestCategory create_overriding(Statement stmt, TestCategory category) {
		//Insert 부분
		try {
			String sql = "insert into TestCategory(kind_no,category) value ('" 
					+ category.getKind_no().getNo() + "', '" + category.getCategory() +"');";
			stmt.execute(sql);	
		} catch (SQLException e) { 
		}
		return null;
	}
	
///////Read////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public TestCategory selectOne_overriding(Statement stmt, int no) {
		TestCategory category = new TestCategory(); 
		TestKind kind = new TestKind();
		try { 
			ResultSet rset = stmt.executeQuery("select c.no, c.kind, d.no,d.kind_no, d.category "
		               + "from TestKind as c left join TestCategory as d "
		               + "on c.no = d.kind_no "
		               + "where d.no = " + no + ";");	
			if(rset.next()) {
			kind.setNo(rset.getInt(1));
			kind.setKind(rset.getString(2));
			category.setKind_no(kind);
			
			category.setCategory(rset.getString(5));
	
			
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return category;
	}

	@Override
	public List<TestCategory> selectAll_overriding(Statement stmt) { 
		ArrayList<TestCategory> categoryList = new ArrayList<TestCategory>(); 
		TestKind kind = new TestKind();
		TestCategory category = new TestCategory();			
		try {
			ResultSet rset = stmt.executeQuery("select a.no, a.kind, b.no, b.category from TestKind as a join TestCategory as b "
							               + "on a.no = b.kind_no ;");
			while(rset.next()) {
				kind.setNo(rset.getInt(1));
				kind.setKind(rset.getString(2));
				category.setKind_no(kind);
				
				category.setCategory(rset.getString(3));
				categoryList.add(category);
			}
			rset.close();
			return categoryList; 
		} catch (Exception e) {
			e.printStackTrace();
		}						
		return null;
	}

	@Override
	public List<TestCategory> selectAllContainingCategory_overriding(Statement stmt, String category) {
		ArrayList<TestCategory> categoryList = new ArrayList<TestCategory>();
		TestKind kind = new TestKind();
		try {
			ResultSet rset = stmt.executeQuery("select a.no, a.kind, b.no, b.category "
					+ "from TestKind as a "
		               + "join TestCategory as b "
		               + "on a.no = b.kind_no "
		               + "where b.category like " + "'%" + category + "%';");
			while(rset.next()) {
				TestCategory testCategory = new TestCategory();	
				System.out.println(rset.getString(3));
				kind.setNo(rset.getInt(1));
				kind.setKind(rset.getString(2));
				testCategory.setKind_no(kind);
				
				testCategory.setCategory(rset.getString(4));
				categoryList.add(testCategory);
			}
			rset.close();
			return categoryList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
		
	}
///////Update/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestCategory update_overriding(Statement stmt, int no, TestCategory category) { 
		try {
			stmt.execute("update TestCategory set category = '"+ 
					category.getCategory() +"' where no = " + no +";"); 			
			return category;	
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

///////Delete////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public TestCategory delete_overriding(Statement stmt, int no) {
		try {
			stmt.execute("delete from TestCategory where no = " + no +";");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
}
