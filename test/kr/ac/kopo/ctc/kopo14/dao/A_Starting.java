package kr.ac.kopo.ctc.kopo14.dao;

import java.util.Scanner;

public class A_Starting { 				//시작화면
	public Scanner in ;
	int inputNumber;
	int inputType;
	String str;
	
	public A_Starting() {
		in = new Scanner(System.in);
		inputNumber = 0;
		inputType = 0;
		str = "";
	}
	
	public  void inputAll() {
		inputNumber();
		inputType();
	}
	
	public int inputNumber() {
		System.out.print("메뉴를 선택해주세요.(번호 입력)\n");
		System.out.print("1. 가계부 입력	2. 내역 조회	3. 내역 수정\n" + 
				"4. 내역 삭제	5. 새 계좌 만들기	6. 종료\n");
		try {
			inputNumber=in.nextInt();
			if ( inputNumber < 1 || inputNumber > 6) {
				System.out.println("1~6 사이로 입력해주세요.");
				//continue;
			}else if (inputNumber == 6) {
				//break;
				}
			}catch (Exception e ) {
				System.out.println("숫자만 입력해주세요.");
				str = in.nextLine();
			}
			return inputNumber;
		}

	
	public int inputType() {
		System.out.print("계좌 타입을 선택해주세요.(번호 입력)\n");
		System.out.print("1. 개인용	2. 모임용	3. 종료\n");
		try {
			inputType=in.nextInt();
			if ( inputType != 1 && inputType != 2 && inputType != 3) {
				System.out.println("1~3 사이로 입력해주세요.");
				//continue;
			}else if (inputType == 3) {
				//break;
			}
		}catch (Exception e) {
			System.out.println("숫자만 입력해주세요.");
			str = in.nextLine();
		}
		return inputType;		
	}

	public void finalize()throws Throwable{
		in.close();		
	}

}
