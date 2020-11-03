package com.choa.s4.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.file.BoardFileDTO;
import com.choa.s4.util.Pager;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void setInsertFileTest()throws Exception{
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setNum(144);
		boardFileDTO.setFileName("ttt");
		boardFileDTO.setOriName("000");
		int result = noticeDAO.setInsertFile(boardFileDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		System.out.println(ar.size());
		assertEquals(10, ar.size());
	}
	
	
	//@Test
	public void setInsertTest()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title test");
		boardDTO.setWriter("writer test");
		boardDTO.setContents("contents test");
		int result = noticeDAO.setInsert(boardDTO);
		assertEquals(1, result);
	}

}