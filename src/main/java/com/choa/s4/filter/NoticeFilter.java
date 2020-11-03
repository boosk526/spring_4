package com.choa.s4.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.choa.s4.member.MemberDTO;

/**
 * Servlet Filter implementation class NoticeFilter
 */
public class NoticeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NoticeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//noticeList, noticeSelect 누구나 접근 가능
		//write, update, delete 로그인 한 사람중에서 id가 admin만 가능
		HttpServletRequest req = (HttpServletRequest)request;
		
		String list = req.getRequestURI();
		list = list.substring(list.lastIndexOf("/")+1);
		
		boolean check = list.equals("noticeList");
		if(!check) {
			check = list.equals("noticeSelect");
		}
		
		HttpSession session = req.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		boolean adminCheck=false;
		if(memberDTO != null && memberDTO.getId().equals("admin")) {
			adminCheck=true;
		}
		
		if(check || adminCheck) {
			chain.doFilter(request, response);
			
		}else {
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}