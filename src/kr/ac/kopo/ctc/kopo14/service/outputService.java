package kr.ac.kopo.ctc.kopo14.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.ctc.kopo14.dao.*;
import kr.ac.kopo.ctc.kopo14.dto.*;
import kr.ac.kopo.ctc.kopo14.domain.*;
import kr.ac.kopo.ctc.kopo14.domain.TestCategory;

public class outputService {
	TestCategoryDao categoryDao =new TestCategoryDaoImpl();
	TestKindDao kindDao = new TestKindDaoImpl();
	TestKind kind = new TestKind();//지출/수입
	TestCategory category = new TestCategory();//카테고리
	Scanner in = new Scanner(System.in);
	inputService inputService = new inputService();
	TestAccountDao accountDao = new TestAccountDaoImpl();
	TestAccount account = new TestAccount();
	TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
	TestAccountItem accountItem = new TestAccountItem();
	Service ss = new Service();
    DateType datetype = new DateType();
	
	int isaf = 0; //logOut
	String isac = null; //CreateAccount
	int isuas = 0; String isuat = null; //updateAccount
	int isdas = 0; //deleteAccount
	
	int isat = 0; int isik = 0; int isic = 0; String isit = null; int isait = 0; int isaim = 0; //int isaipm = 0;  createAccountItem
// account_title,     kind			category		 detail			  type	   	 	 amount
	
	String issta = null; //selectAccountItemConTitle()
	int issoai = 0; //selectAccountItemOne()
	int isuais = 0; String isuait = null; //updateAccountItem
	int isdais = 0; //deleteAccountItem
	int isdai = 0; //serviceAccountItem
	
	

////////////Log Out
	public int logOut() {
		isaf = inputService.afterService();
		if (isaf == 1) {
		}
		if (isaf == 2) {
			System.out.println("가계부 프로그램을 종료합니다.");
		}
		return isaf;
	}
/////////////Account
	public void selectAllAccount() {
		List<TestAccount> account = new ArrayList<TestAccount>();
		account = accountDao.selectAll();
		System.out.printf("%3s%8s%10s\n","ID","가계부명","생성일");
		for(int i=0; i<account.size(); i++) {
		System.out.printf("%3s%5s%12s\n",
				account.get(i).getId(), account.get(i).getTitle(), account.get(i).getCreated());
		}
		System.out.println("\nselect 완료\n");
	}
	
	public void createAccount() {
		isac = inputService.insertAccount();
		account.setTitle(isac);
		accountDao.create(account);
		System.out.println("가계부가 생성되었습니다.");
		
	}
	
	public void updateAccount() {
		isuas = inputService.updateAccountSelect();
		account = accountDao.selectOne(isuas);
		isuat = inputService.updateAccountTitle();
		account.setTitle(isuat);
		accountDao.update(account); //accountDao.update(account, account.getId());?
		System.out.println("수정이 완료되었습니다.");
	}
	
	public void deleteAccount() {
		isdas = inputService.deleteAccountSelect();
		account = accountDao.delete(isdas);
		System.out.println("삭제가 완료되었습니다.");
	}
	
////////////AccountItem
	
	public void selectAccountItemAll() {
		List<TestAccountItem> accountItem = accountItemDao.selectAll();
		accountItem = accountItemDao.selectAll();
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );
		}
	}	
	public void selectAccountItemOut() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingKind("지출");
		List<TestAccount> account = accountDao.selectAll();
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemIn() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingKind("수입");
		List<TestAccount> account = accountDao.selectAll();
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
//	public void selectAccountItemCategory() {
//		
//	}
	
	
	public void selectAccountItemCategory1() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("식비");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory2() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("주거");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory3() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("통신");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory4() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("생활용품");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory5() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("의복/미용");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory6() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("건강/문화");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory7() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("교육/육아");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory8() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("교통/차량");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory9() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("경조사/회비");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory10() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("세금/이자");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory11() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("카드대금");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory12() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("저축/투자");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory13() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("미분류");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory14() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("월급");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory15() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("용돈");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	public void selectAccountItemCategory16() {
		List<TestAccountItem> accountItem = accountItemDao.selectAllContainingCategory("기타");
		System.out.printf("%3s	%1s	%2s	%-8s	%2s			%4s	%-10s	%-12s\n","ID","가계부ID","분류","카테고리","내역","종류","금액","기록일");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i=0; i<accountItem.size(); i++) {
			System.out.printf("%3s	%5s		%2s	%-8s	%-15s	%4s	%-10s	%-12s\n",
					+ accountItem.get(i).getId(),accountItem.get(i).getAccount_id().getId(),
					accountItem.get(i).getKind().getKind(),accountItem.get(i).getCategory().getCategory(),
					accountItem.get(i).getDetail(),accountItem.get(i).getType(),accountItem.get(i).getAmount(),
					accountItem.get(i).getCreated() );

		}
		
	}
	

	public void createAccountItem() {

		isat = inputService.AccountType(); //account_id
		account = accountDao.selectOne(isat);
		accountItem.setAccount_id(account);
		
		isit = inputService.insertDetail(); //Detail
		accountItem.setDetail(isit);
		
		isait = inputService.AccountItemType(); //type : 현금. 카드
		if(isait == 1) {accountItem.setType("현금");}else {accountItem.setType("카드");}
				
		isik = inputService.AccountItemKind(); // kind : 1. 지출 2. 수입
		kind = kindDao.selectOne(isik);
		accountItem.setKind(kind);
		
		isic = inputService.AccountItemCategory(); //category
		category = categoryDao.selectOne(isic);
		accountItem.setCategory(category);
		
		isaim = inputService.AccountItemAmount(); //amount
		accountItem.setAmount(isaim);
		
		accountItemDao.create(accountItem);
		System.out.println("새 내역이 입력되었습니다.");
	}
	
	public void updateAccountItem() {
		isuais = inputService.updateAccountItemSelect(); //accountItem의 id번호
		accountItem = accountItemDao.selectOne(isuais);
		
		isuait = inputService.updateAccountItemDetail();//바꾸게될 detail
		accountItem.setDetail(isuait);
		
		accountItemDao.update(accountItem, isuait);
		System.out.println("내역이 수정되었습니다.");		
	}
	
	public void deleteAccountItem() {
		isdais = inputService.deleteAccountItemSelect();
		accountItem = accountItemDao.delete(isdais);
		System.out.println("내역이 삭제되었습니다.");
	}
	
	public void serviceAccountItem() {
		isdai = inputService.dateAccountItem();
		datetype.setStatDate(isdai);
		try { 
			int[] rVals = ss.serviceAccountItem(datetype.getStatDate());
			System.out.println("지출은 "+rVals[0]+"원 입니다 :(");
			System.out.println("수입은 "+rVals[1]+"원 입니다 :)");
			System.out.println("수익은 "+ (rVals[1]-rVals[0]) +"원 입니다! ♥");
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void categoryService() {
		isdai = inputService.categoryAccountItem();
		datetype.setStatDate(isdai);
		try {
			int[] rVals = ss.categoryService(datetype.getStatDate());
			System.out.println("식비는 총 "+rVals[0]+"원 지출했습니다 :(");
			System.out.println("주거는 총 "+rVals[1]+"원 지출했습니다 :(");
			System.out.println("통신은 총 "+rVals[2]+"원 지출했습니다 :(");
			System.out.println("생활용품은 총 "+rVals[3]+"원 지출했습니다 :(");
			System.out.println("의복/미용은 총 "+rVals[4]+"원 지출했습니다 :(");
			System.out.println("건강/문화는 총 "+rVals[5]+"원 지출했습니다 :(");
			System.out.println("교육/육아는 총 "+rVals[6]+"원 지출했습니다 :(");
			System.out.println("교통/차량은 총 "+rVals[7]+"원 지출했습니다 :(");
			System.out.println("경조사/회비는 총 "+rVals[8]+"원 지출했습니다 :(");
			System.out.println("세금/이자는 총 "+rVals[9]+"원 지출했습니다 :(");
			System.out.println("카드대금은 총 "+rVals[10]+"원 지출했습니다 :(");
			System.out.println("저축/투자는 총 "+rVals[11]+"원 지출했습니다 :(");
			System.out.println("미분류는 총 "+rVals[12]+"원 지출했습니다 :(");
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
