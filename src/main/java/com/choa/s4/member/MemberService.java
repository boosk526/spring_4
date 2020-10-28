package com.choa.s4.member;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception;

	public int setMemberUpdate(MemberDTO memberDTO)throws Exception;
	
	public int setMemberDelete(MemberDTO memberDTO)throws Exception;
	
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session)throws Exception;
	
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO)throws Exception;

}