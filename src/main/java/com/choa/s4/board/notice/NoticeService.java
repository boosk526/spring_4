package com.choa.s4.board.notice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.BoardService;
import com.choa.s4.board.file.BoardFileDTO;
import com.choa.s4.util.FileSaver;
import com.choa.s4.util.Pager;

@Service
@Transactional
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileSaver fileSaver;


	public boolean summernoteDelete(String file, HttpSession session)throws Exception{
		String path = session.getServletContext().getRealPath("/resources/upload/notice");
		File file2 = new File(path, file);
		boolean result = false;
		if(file2.exists()) {
			result = file2.delete();
		}
		return result;
	}
	
	public String summernote(MultipartFile file, HttpSession session)throws Exception{
		// 파일을 하드디스크에 저장하고 저장된 파일명을 리턴
		String path = session.getServletContext().getRealPath("/resources/upload/notice");
		System.out.println(path);
		File dest = new File(path);
		String fileName = fileSaver.saveCopy(dest, file);
		
		return fileName;
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		
		//파일을 HDD에 저장 /resources/upload/notice
		String path = session.getServletContext().getRealPath("/resources/upload/notice");
		File file = new File(path);
		System.out.println(path);
		//---- Sequence
		//boardDTO.setNum(noticeDAO.getNum());
		
		//---- Notice Insert
		int result = noticeDAO.setInsert(boardDTO);
		
		System.out.println("Num : "+boardDTO.getNum());
		//---- NoticeFile Insert
		
		for(MultipartFile multipartFile:files) {
			if(multipartFile.getSize() !=0) {
				String fileName = fileSaver.saveCopy(file, multipartFile);
				
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setFileName(fileName);
				boardFileDTO.setOriName(multipartFile.getOriginalFilename());
				boardFileDTO.setNum(boardDTO.getNum());
				
				noticeDAO.setInsertFile(boardFileDTO);
			}
		}
		
		//-------------
		
		
		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getOne(boardDTO);
	}

}