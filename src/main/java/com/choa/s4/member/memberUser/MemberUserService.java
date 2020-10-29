package com.choa.s4.member.memberUser;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;
import com.choa.s4.member.memberFile.MemberFileDAO;
import com.choa.s4.member.memberFile.MemberFileDTO;
import com.choa.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {

	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver fileSaver;
	
	
//	public MemberFileDTO getOne(MemberDTO memberDTO)throws Exception {
//		return memberFileDAO.getOne(memberDTO);
//	}
	
	
	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		//HDD 폴더 이름
		String path = session.getServletContext().getRealPath("/resources/upload/member");
		System.out.println(path);
		File file = new File(path);
		String fileName = "";
		
		int result = memberUserDAO.setMemberJoin(memberDTO);
		
		if(photo.getSize()!=0) {
			fileName = fileSaver.saveCopy(file, photo);
			//memberFile Insert
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setFilename(fileName);
			memberFileDTO.setOriname(photo.getOriginalFilename());
			
			result = memberFileDAO.setInsert(memberFileDTO);
		}
		
		return result;
	}
	
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}

}