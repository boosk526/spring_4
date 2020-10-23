package com.choa.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.member.MemberDTO;

@Controller
@RequestMapping("/member/**")
public class MemberUserController {
	
	private MemberUserService memberUserService;
	
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession session)throws Exception {
		// 웹브라우저 종료
		// 일정시간 경과(로그인 후 요청이 발생하면 시간이 연장)
		// memberDTO를 null로 대체
		// 유지시간을 강제로 0으로 변경
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	//getMemberLogin
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberLogin(memberDTO);

		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("msg", "Login Fail");
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	
	
}
