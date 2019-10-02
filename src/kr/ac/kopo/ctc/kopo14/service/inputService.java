package kr.ac.kopo.ctc.kopo14.service;

import java.util.Scanner;

public class inputService {
	
	Scanner in = new Scanner(System.in);
	int selectService = 0; //시작화면 서비스 선택
	int selectAfterService; //서비스 완료 후 종료 선택
	String insertAccountTitle; //새 가계부 추가
	int selectAccountId; //수정할 가계부 id값
	String updateAccountTitle; //수정될 가계부 이름
	int deleteAccountTitle;
	int selectAccountItem; //조회할 내역 ~ 수입/지출/전체/특정검색어
	int selectAccountItemId; //조회할 특정 내역 id값
	int selectAccountItemCategory;
	String selectAccountItemDetail; //조회할 특정 내역 Detail값
	String inserttAccountItemDetail; //새 내역의 Detail
	int accountItemType; //카드, 현금
	int accountItemKind; //수입, 지출
	int accountItemCategory; //카테고리
	int accountItemAmount; //금액
	int updateAccountItemId;
	String updateAccountItemDetail;
	int deleteAccountItemId;
	int yearAccountItem; int monthAccountItem;
//------------------------------------------------------------------------------
	
	public int serviceType() {
		System.out.println("원하는 서비스를 선택하세요.");
		System.out.println("1.가계부 목록 조회 2. 새 가계부 추가 3. 가계부 수정 4. 가계부 삭제\n"
				+"5.내역 조회 6. 새 내역 입력 7. 내역 수정 8. 내역 삭제\n "
				+"9.월별 통계 10. 카테고리별 지출	99.프로그램 종료\n");
		selectService = in.nextInt();
		in.nextLine();
		return selectService;
	}
	
	public int afterService() {
		System.out.println();
		System.out.println("원하는 서비스를 선택하세요.");
	    System.out.println("1.시작화면으로 돌아가기\n 2.프로그램종료");
	    selectAfterService = in.nextInt();
	    in.nextLine();
	    return selectAfterService;
	}
	
	public String insertAccount() {
		System.out.println("원하는 가계부 이름을 입력하세요.");
		insertAccountTitle = in.nextLine();
		return insertAccountTitle;
	}
	
	public int updateAccountSelect() {
		System.out.println("수정을 원하는 가계부 id를 입력하세요.");
		selectAccountId = in.nextInt();
		in.nextLine();
		return selectAccountId;
	}
	
	public String updateAccountTitle() {
		System.out.println("수정될 가계부 이름을 입력하세요.");
		updateAccountTitle = in.nextLine();
		return updateAccountTitle;
	}
	
	public int deleteAccountSelect() {
		System.out.println("삭제를 원하는 가계부 id를 입력하세요.");
		deleteAccountTitle = in.nextInt();
		in.nextLine();
		return deleteAccountTitle;
	}
	
	public int selectAccountItem() {
		System.out.println("조회를 원하는 내역을 입력하세요.");
		System.out.println("1. 수입/지출 전체 내역 2.지출 내역 3. 수입 내역 4. 카테고리별 내역");
		selectAccountItem = in.nextInt();
		in.nextLine();
		return selectAccountItem;
	}
	
	public int selectAccountItemCategory() {
		System.out.println("조회할 카테고리를 선택하세요.");
		System.out.println("1.식비	2.주거	3.통신	4.생활용품	5.의복/미용\n"
				+ "6.건강/문화	7.교육/육아	8.교통/차량	9.경조사/회비	10.세금/이자\n"
				+ "11.카드대금	12.저축/투자	13.미분류	14.월급	15.용돈	16.기타");
		selectAccountItemCategory = in.nextInt();
		in.nextLine();
		return selectAccountItemCategory;
		
	}
	
	public int selectOneAccountItem() {
		System.out.println("조회를 원하는 내역의 ID를 입력하세요");
		selectAccountItemId = in.nextInt();
		in.hasNextLine();
		return selectAccountItemId;
	}
	
	public String selectDetailAccountItem() {
		System.out.println("조회를 원하는 내역의 내용을 입력하세요.");
		selectAccountItemDetail = in.nextLine();
//		in.nextLine();
		return selectAccountItemDetail;
	}
	
	public int AccountType() {
		System.out.println("관리할 가계부의 고유번호를 입력하세요.");
		selectAccountItemId = in.nextInt();
		in.nextLine();
		return selectAccountItemId; //다른 메소드에서 쓴 변수인데 또 써도 되나..?
	}
	
	public String insertDetail() {
		System.out.println("수입 또는 지출의 내용을 입력하세요.");
		inserttAccountItemDetail = in.nextLine();
//		in.nextLine();
		return inserttAccountItemDetail;
	}
	
	public int AccountItemType() {
		System.out.println("현금/카드 선택하세요.");
		System.out.println("1.현금 2.카드");
		accountItemType = in.nextInt();
		in.nextLine();
		return accountItemType;
	}
	
	public int AccountItemKind() {
		System.out.println("수입/지출 선택하세요.");
		System.out.println("1.지출 2.수입");
		accountItemKind = in.nextInt();
		in.nextLine();
		return accountItemKind;
	}
	
	public int AccountItemCategory() {
		System.out.println("카테고리를 선택하세요.");
		System.out.println("1.식비	2.주거	3.통신	4.생활용품	5.의복/미용\n"
				+ "6.건강/문화	7.교육/육아	8.교통/차량	9.경조사/회비	10.세금/이자\n"
				+ "11.카드대금	12.저축/투자	13.미분류	14.월급	15.용돈	16.기타");
		accountItemCategory = in.nextInt();
		in.nextLine();
		return accountItemCategory;
	}
	
	
	public int AccountItemAmount() {
		System.out.println("금액을 입력하세요.");
		accountItemAmount = in.nextInt();
		in.nextLine();
		return accountItemAmount;		
	}
	
	public int updateAccountItemSelect() {
		System.out.println("수정을 원하는 내역의 고유번호를 입력하세요.");
		updateAccountItemId = in.nextInt();
		in.nextLine();
		return updateAccountItemId;		
	}
	
	public String updateAccountItemDetail() {
		System.out.println("수정할 내용을 입력하세요.");
		updateAccountItemDetail = in.nextLine();
		return updateAccountItemDetail;	
	}
	
	public int deleteAccountItemSelect() {
		System.out.println("삭제를 원하는 내역의 id를 입력하세요.");
		deleteAccountItemId = in.nextInt();
		System.out.println("삭제가 완료되었습니다.");
		in.nextLine();
		return deleteAccountItemId;	
	}
	
	public int dateAccountItem() {
		System.out.println("통계를 원하는 연월을 입력하세요(여섯자리 숫자).");
		yearAccountItem = in.nextInt();
		return yearAccountItem;
	}
	public int categoryAccountItem() {
		System.out.println("통계를 원하는 연월을 입력하세요(여섯자리 숫자).");
		yearAccountItem = in.nextInt();
		return yearAccountItem;
	}

}
