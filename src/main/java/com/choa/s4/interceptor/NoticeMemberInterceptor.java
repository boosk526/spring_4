package com.choa.s4.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.s4.member.MemberDTO;

@Component
public class NoticeMemberInterceptor extends HandlerInterceptorAdapter {
	
	//NoticeList, NoticeSelect는 누구나 통과
	//나머지 로그인 한 사람 중 admin만 통과
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		boolean check = false;
		if(memberDTO != null && memberDTO.getId().equals("admin1")) {
			check = true;
		}else {
		
			request.setAttribute("msg", "권한이 필요");
			request.setAttribute("path", "../member/memberLogin");
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		
		return check;
	}
	

}