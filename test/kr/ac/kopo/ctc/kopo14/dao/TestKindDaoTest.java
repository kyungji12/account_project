package kr.ac.kopo.ctc.kopo14.dao;

import kr.ac.kopo.ctc.kopo14.dao.TestKindDao;
import kr.ac.kopo.ctc.kopo14.dao.TestKindDaoImpl;
import kr.ac.kopo.ctc.kopo14.domain.TestKind;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestKindDaoTest {
	//----Insert----------------------------------------
	@Test
public void testCreate() {
	TestKindDao kindDao = new TestKindDaoImpl();
	TestKind kind = new TestKind();
	kind.setKind("테스트 ");
	kindDao.create(kind);	
}
//1: 지출 2 : 수입
}
