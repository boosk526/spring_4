package com.choa.s4.member;

public interface MemberService {
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception;

	public int setMemberUpdate(MemberDTO memberDTO)throws Exception;
	
	public int setMemberDelete(MemberDTO memberDTO)throws Exception;
	
	public int setMemberJoin(MemberDTO memberDTO)throws Exception;

}