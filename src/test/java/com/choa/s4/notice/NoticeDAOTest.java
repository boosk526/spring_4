package com.choa.s4.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.file.BoardFileDTO;
import com.choa.s4.board.notice.NoticeDAO;

public class NoticeDAOTest extends MyTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;

	public void setInsertFileTest()throws Exception{
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setNum(118);
		boardFileDTO.setFilename("f1");
		boardFileDTO.setOriname("o1");
	int result = noticeDAO.setInsertFile(boardFileDTO);
		assertEquals(1, result);
	}

}
