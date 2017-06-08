package com.kdn.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdn.model.biz.NoticeBoardService;
import com.kdn.model.domain.NoticeBoard;
import com.kdn.model.domain.PageBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	NoticeBoardService	noticeBoardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, PageBean bean) {
		List<NoticeBoard> list = noticeBoardService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		return "index";
	}
	
}
