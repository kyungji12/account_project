package kr.ac.kopo.ctc.kopo14.domain;

import java.util.Date;


//package kr.ac.kopo.ctc.kopo14.domain;
//
//import java.util.Date;
//
public class TestAccountItem {
	private int id;										//넘버링
	private TestAccount account_id;						//TestAccount에서 넘어오는 id
	private TestKind kind;								//TestKind에서 넘어오는 kind
	private TestCategory category;						//TestCategory에서 넘어오는 category
	private String detail;								//내역
	private String type;								//현금/카드 구분
	private int amount;									//금액
	private Date created;								//기록일
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public TestAccount getAccount_id() {return account_id;}
	public void setAccount_id(TestAccount testAccount) {this.account_id = testAccount;}
	
	public String getDetail() {return detail;}
	public void setDetail(String detail) {this.detail = detail;}
	
	public TestKind getKind() {return kind;}
	public void setKind(TestKind testKind) {this.kind = testKind;}
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}
	
	public Date getCreated() {return created;}
	public void setCreated(Date created) {this.created = created;}
	
	public TestCategory getCategory() {return category;}
	public void setCategory(TestCategory testCategory) {this.category = testCategory;}
	public void setKind(String string) {
		// TODO Auto-generated method stub
		
	}
	public TestAccountItem get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

