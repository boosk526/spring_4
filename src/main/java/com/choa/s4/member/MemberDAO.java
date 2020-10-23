package com.choa.s4.member;

public interface MemberDAO {
	
	//login
	public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception;

}