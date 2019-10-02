package kr.ac.kopo.ctc.kopo14.domain;

import java.util.Date;

public class TestAccount {
	private int id;
	private String title;
	private Date created;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;} //계좌 식별자
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;} //계좌 타입
	
	public Date getCreated() {return created;}
	public void setCreated(Date created) {this.created = created;} //등록일
	public void setKind(String string) {
		// TODO Auto-generated method stub
		
	}
	public TestAccount getAccount_id() {
		// TODO Auto-generated method stub
		return null;
	}
	public TestAccountItem getKind() {
		// TODO Auto-generated method stub
		return null;
	}
	public TestAccountItem getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getDetail() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getType() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getAmount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}