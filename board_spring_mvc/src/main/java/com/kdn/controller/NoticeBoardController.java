package com.kdn.controller;
 
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import com.kdn.model.biz.NoticeBoardService;
import com.kdn.model.domain.NoticeBoard;
import com.kdn.model.domain.PageBean;
 
@Controller
public class NoticeBoardController {
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", e.getMessage()); 
		model.addObject("noticeBoard", "ErrorHandler.jsp");
		return model;
		
	}
	
	@Autowired
	private NoticeBoardService noticeBoardService;
	
	@RequestMapping(value="insertNoticeBoardForm.do", method=RequestMethod.GET)
	public String insertBoardForm(Model model) {
		model.addAttribute("noticeBoardContent", "notice_board/insertBoard.jsp");
		return "index";
	}
	@RequestMapping(value="insertNoticeBoard.do", method=RequestMethod.POST)
	public String insertBoard(NoticeBoard noticeBoard, HttpServletRequest request) {
		String dir = request.getRealPath("upload/");
		System.out.println("upload directory : " + dir);
		noticeBoardService.add(noticeBoard, dir);
		
		return "index";
	}
	
	@RequestMapping(value="listNoticeBoard.do", method=RequestMethod.GET)
	public String listBoard(PageBean bean, Model model) {
		List<NoticeBoard> list = noticeBoardService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		return "index";
	}
 
	@RequestMapping(value="searchNoticeBoard.do", method=RequestMethod.GET)
	public String searchBoard(int nno, Model model) {
		model.addAttribute("noticeBoard", noticeBoardService.search(nno));
		System.out.println(nno);
		model.addAttribute("noticeBoardContent", "notice_board/searchBoard.jsp");
		return "index";
		
	}
	
 
}
