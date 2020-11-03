package com.choa.s4.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;

public class MemberFileDAOTest extends MyTestCase {

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test(expected = RuntimeException.class)
	public void setInsertTest()throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("id41331313");
		memberFileDTO.setFileName("fileName");
		memberFileDTO.setFileName("Oriname");
		int result = memberFileDAO.setInsert(memberFileDTO);
		assertEquals(1, result);
	}

}