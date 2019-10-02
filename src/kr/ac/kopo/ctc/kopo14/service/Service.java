package kr.ac.kopo.ctc.kopo14.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.ac.kopo.ctc.kopo14.dao.*;
import kr.ac.kopo.ctc.kopo14.domain.*;

public class Service {
	
	int isdai;
	int minusValue = 0; //지출
	int plusValue = 0; //수입
	int foodValue=0, rentalValue=0, phoneValue=0, livingValue=0, clothesValue=0;
	int healthValue=0, educationValue=0, transportValue=0, eventValue=0;
	int taxValue=0, paymentValue=0, savingValue=0, etcValue=0;
	
	public int[] serviceAccountItem(int isdai) throws ParseException {
		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
		List<TestAccountItem> accountItemList = accountItemDao.selectAll();
		for (int i=0; i<accountItemList.size(); i++) {
			TestAccountItem accountItem = accountItemList.get(i);
			SimpleDateFormat sdt = new SimpleDateFormat("yyyyMM");
			String trans = sdt.format(accountItem.getCreated());
			int b = Integer.parseInt(trans);
			if(isdai == b) {
				if(accountItem.getKind().toString().contentEquals("지출")) {
					minusValue = minusValue + accountItem.getAmount();
				}
				if(accountItem.getKind().toString().contentEquals("수입")) {
					plusValue = plusValue + accountItem.getAmount();
				};
			}
		}
		int[] rVals = new int [2];
		rVals[0] = minusValue;
		rVals[1] = plusValue;
		return rVals;
	}
	
	public int[] categoryService(int isdai) throws ParseException{
		TestAccountItemDao accountItemDao = new TestAccountItemDaoImpl();
		List<TestAccountItem> accountItemList = accountItemDao.selectAll();
		for (int i=0; i<accountItemList.size(); i++) {
			TestAccountItem accountItem = accountItemList.get(i);
			SimpleDateFormat sdt = new SimpleDateFormat("yyyyMM");
			String trans = sdt.format(accountItem.getCreated());
			int b = Integer.parseInt(trans);
			if(isdai == b) {
				if(accountItem.getCategory().toString().contentEquals("식비")) {
					foodValue = foodValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("주거")) {
					rentalValue = rentalValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("통신")) {
					phoneValue = phoneValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("생활용품")) {
					livingValue = livingValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("의복/미용")) {
					clothesValue = clothesValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("건강/문화")) {
					healthValue = healthValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("교육/육아")) {
					educationValue = educationValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("교통/차량")) {
					transportValue = transportValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("경조사/회비")) {
					eventValue = eventValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("세금/이자")) {
					taxValue = taxValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("카드대금")) {
					paymentValue = paymentValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("저축/투자")) {
					savingValue = savingValue + accountItem.getAmount();
				}
				if(accountItem.getCategory().toString().contentEquals("미분류")) {
					etcValue = etcValue + accountItem.getAmount();
				};
			}
			
		}
		int[] rVals = new int [13];
		rVals[0] = foodValue;
		rVals[1] = rentalValue;
		rVals[2] = phoneValue;
		rVals[3] = livingValue;
		rVals[4] = clothesValue;
		rVals[5] = educationValue;
		rVals[6] = transportValue;
		rVals[7] = eventValue;
		rVals[8] = taxValue;
		rVals[9] = rentalValue;
		rVals[10] = paymentValue;
		rVals[11] = savingValue;
		rVals[12] = etcValue;
		return rVals;
	}



}
