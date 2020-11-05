package com.choa.s4.board.notice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.board.BoardService;
import com.choa.s4.board.file.BoardFileDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	
	   @PostMapping("summernote")
	   public ModelAndView summernote(MultipartFile file, HttpSession session) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      
	      String fileName = noticeService.summernote(file, session);
	      System.out.println(fileName);
	      
	      String name = session.getServletContext().getContextPath()+File.separator;
	      name = name+"notice"+File.separator+fileName;
	      System.out.println(name);
	      
	      mv.addObject("msg", fileName);
	      mv.setViewName("common/ajaxResult");
	      return mv;
	   }

	
	 @GetMapping("fileDown")
	   public ModelAndView fileDown(BoardFileDTO boardFileDTO) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      mv.addObject("board", "notice");
	      mv.addObject("fileDTO",boardFileDTO);
	      mv.setViewName("fileDown");
	      return mv;
	   }

	
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getOne(boardDTO);
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "notice");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
				
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception{
		
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getOriginalFilename());
		}
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO, files, session);
		String message="Write Fail";
		if(result>0) {
			message ="Write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "notice");
		return mv;
	}
	
	//@RequestMapping(value = "noticeList")
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO>  ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("Notice List");
		mv.setViewName("board/boardList"); 
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getOne(boardDTO);
		mv.addObject("dto", boardDTO);
		
		mv.setViewName("board/boardUpdate");
		return mv;
	}

}