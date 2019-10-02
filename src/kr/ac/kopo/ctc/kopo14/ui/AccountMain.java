package kr.ac.kopo.ctc.kopo14.ui;

import java.util.Scanner;

import kr.ac.kopo.ctc.kopo14.service.inputService;
import kr.ac.kopo.ctc.kopo14.service.outputService;


public class AccountMain {
	public static void main(String[] args) {

		inputService is = new inputService();
		outputService os = new outputService();
		
		int isst = 0;
		int isstt = 0;
		int oslo = 0;
		int issai = 0;
		
		while(true) {
			isst = is.serviceType(); //시작화면 서비스 선택
			
			if(isst == 99) {
				System.out.println("가계부 프로그램을 종료합니다.");
				break;
			}
			//1. 가계부 목록 조회
			if(isst == 1) {
				os.selectAllAccount();
				oslo = os.logOut();
				if(oslo == 2) break;
			}
			//2. 새 가계부 추가
			if(isst ==2) {
				os.createAccount();
				os.selectAllAccount();
				oslo = os.logOut();
				if(oslo == 2) break;
			}
			//3. 가계부 수정
			if(isst == 3) {
				os.updateAccount();
				os.selectAllAccount();
				oslo = os.logOut();
				if(oslo == 2) break;
			}
			//4. 가계부 삭제
			if(isst == 4) {
				os.deleteAccount();
				os.selectAllAccount();
				oslo = os.logOut();
				if(oslo==2) break;
			}
			
			//5.내역 조회 
			//5. 내역 조회
			if(isst == 5) {
				issai = is.selectAccountItem();
				if(issai == 1) {
					os.selectAccountItemAll();
					}
				if(issai == 2) {
					os.selectAccountItemOut();
					}
				if(issai == 3) {
					os.selectAccountItemIn();
					}
				if(issai == 4) {
						isstt = is.selectAccountItemCategory();
						if (isstt == 1) {
							os.selectAccountItemCategory1();
						}
						if (isstt == 2) {
							os.selectAccountItemCategory2();
						}
						if (isstt == 3) {
							os.selectAccountItemCategory3();
						}
						if (isstt == 4) {
							os.selectAccountItemCategory4();
						}
						if (isstt == 5) {
							os.selectAccountItemCategory5();
						}
						if (isstt == 6) {
							os.selectAccountItemCategory6();
						}
						if (isstt == 7) {
							os.selectAccountItemCategory7();
						}
						if (isstt == 8) {
							os.selectAccountItemCategory8();
						}
						if (isstt == 9) {
							os.selectAccountItemCategory9();
						}
						if (isstt == 10) {
							os.selectAccountItemCategory10();
						}
						if (isstt == 11) {
							os.selectAccountItemCategory11();
						}
						if (isstt == 12) {
							os.selectAccountItemCategory12();
						}
						if (isstt == 13) {
							os.selectAccountItemCategory13();
						}
						if (isstt == 14) {
							os.selectAccountItemCategory14();
						}
						if (isstt == 15) {
							os.selectAccountItemCategory15();
						}
						if (isstt == 16) {
							os.selectAccountItemCategory16();
						}
					}

				oslo = os.logOut();
				if(oslo==2) break;
			}
			//6. 새 내역 입력
			
			if(isst == 6) {
				os.createAccountItem();
				oslo = os.logOut();
				if(oslo==2) break;
			}
			//7. 내역 수정
			if(isst == 7) {
				os.updateAccountItem();
				oslo = os.logOut();
				if(oslo==2) break;
			}
			//8. 내역 삭제
			if(isst == 8) {
				os.deleteAccountItem();
				oslo = os.logOut();
				if(oslo==2) break;
			}
			
			//9. 월별 통계
			if(isst == 9) {
				os.serviceAccountItem();
				oslo = os.logOut();
				if(oslo==2) break;
			}
			//10.카테고리별 통계
			if(isst == 10) {
				os.categoryService();
				oslo = os.logOut();
				if(oslo==2) break;
			}
		}
	}
}
