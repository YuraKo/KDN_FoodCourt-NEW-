package com.kdn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kdn.model.biz.DietService;
import com.kdn.model.biz.NoticeBoardService;
import com.kdn.model.biz.ReviewService;
import com.kdn.model.domain.Diet;
import com.kdn.model.domain.NoticeBoard;
import com.kdn.model.domain.NoticePageBean;
import com.kdn.model.domain.Review;
import com.kdn.model.domain.ReviewPageBean;

@Controller
public class DietController {
	@Autowired
	NoticeBoardService	noticeBoardService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	DietService dietService;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", e.getMessage());
		model.addObject("content", "ErrorHandler.jsp"); 
		return model;
	}
	
	@RequestMapping(value = "addWeeklyMenuForm.do", method = RequestMethod.GET)
	public String addWeeklyMenuForm(Model model, NoticePageBean noticebean, ReviewPageBean bean){
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		
		model.addAttribute("addMenuContent", "weekly_menu/addMenu.jsp");
		return "index";
	}
	
	@RequestMapping(value = "addWeeklyMenu.do", method = RequestMethod.POST)
	public String addWeeklyMenu(Model model, NoticePageBean noticebean, ReviewPageBean bean, Diet diet ){
		System.out.println(diet);
		dietService.add(diet);
		System.out.println("diet Add : 완료");
		
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		
		List<Diet> dietList = dietService.searchAll();
		model.addAttribute("dietList", dietList);
		model.addAttribute("weeklyMenuContent", "weekly_menu/weeklyMenu.jsp");

		return "index";
	}
	
	@RequestMapping(value = "updateWeeklyMenuForm.do", method = RequestMethod.GET)
	public String updateWeeklyMenuForm(Model model, NoticePageBean noticebean, ReviewPageBean bean){
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		model.addAttribute("updateMenuContent", "weekly_menu/updateMenuForm.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "searchUpdateMenu.do", method = RequestMethod.GET)
	public String searchUpdateMenu(Model model, NoticePageBean noticebean, ReviewPageBean bean, String dietDate, int scode){
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		
		model.addAttribute("updateMenuContent", "weekly_menu/updateMenu.jsp");
		model.addAttribute("oneDiet", dietService.search(dietDate, scode));
		
		return "index";
	}
	
	@RequestMapping(value = "updateMenu.do", method = RequestMethod.POST)
	public String UpdateMenu(Model model, NoticePageBean noticebean, ReviewPageBean bean, Diet diet){
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		
		dietService.update(diet);
		System.out.println("diet update 완료 : " + diet);
		
		List<Diet> dietList = dietService.searchAll();
		model.addAttribute("dietList", dietList);
		model.addAttribute("weeklyMenuContent", "weekly_menu/weeklyMenu.jsp");
		
		return "index";
	}
	
	
}