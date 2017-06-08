package com.kdn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kdn.model.biz.MemberService;
import com.kdn.model.domain.Member;
import com.kdn.model.domain.PageBean;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", e.getMessage());
		model.addObject("content", "ErrorHandler.jsp");
		return model;
	}
	
	//등록
	@RequestMapping(value="registerForm.do", method=RequestMethod.GET)
	public String insertMemberForm(Model model) {
		model.addAttribute("content", "member/register.jsp");
		return "index";
	}
	
	@RequestMapping(value="registerMember.do", method=RequestMethod.POST)
	public String insertMember(Member member, Model model) {
		System.out.println(member);
		memberService.add(member);
		return "index";
	}
	
	//로그인
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(Model model, HttpSession session, int mno, String pw) {
		System.out.println("log : 로그인 시도 - " + mno);
		memberService.login(mno, pw);
		session.setAttribute("mno", mno);
		System.out.println("log : 로그인 완료");
		return "index";
	}

	//로그아웃
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String loginOut(HttpSession session) {
		session.removeAttribute("mno");
		return "index";
	}
	
	//myPage
	@RequestMapping(value="myPage.do", method=RequestMethod.GET)
	public String myPage(HttpSession session, Model model) {
		int mno = (Integer) session.getAttribute("mno");
		System.out.println(memberService.search(mno));
		model.addAttribute("member", memberService.search(mno));
		model.addAttribute("content", "member/myPage.jsp");
		return "index";
		
	}
	
	@RequestMapping(value="memberUpdateForm.do", method=RequestMethod.GET)
	public String memberUpdateForm(Model model) {
		model.addAttribute("content", "member/updateMember.jsp");
		return "index";
	}
	
	@RequestMapping(value="updateMember.do", method=RequestMethod.POST)
	public void updateMember(Member member, Model model, HttpServletResponse response) throws IOException {
		memberService.update(member);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.println("<script>alert('회원정보가 변경 되었습니다.');"
				  + "document.location.href = '/board'"
				  + "</script>");
		out.flush();
		out.close();
	}
	
	//멤버 리스트
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public String memberList(PageBean bean, Model model) {
		List<Member> list = memberService.searchAll(bean);
		model.addAttribute("mlist", list);
		model.addAttribute("content", "member/memberList.jsp");
		return "index";
	}
}