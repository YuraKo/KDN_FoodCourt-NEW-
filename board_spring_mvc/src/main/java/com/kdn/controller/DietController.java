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
import com.kdn.model.biz.RankingService;
import com.kdn.model.biz.ReviewService;
import com.kdn.model.domain.Diet;
import com.kdn.model.domain.NoticeBoard;
import com.kdn.model.domain.NoticePageBean;
import com.kdn.model.domain.Ranking;
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
	
	@Autowired
	RankingService rankingService;
	
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
		
		List<Ranking> rankingList = rankingService.searchN();
		System.out.println("저녁"+rankingList);
		model.addAttribute("rankingList", rankingList);
		List<Ranking> rankingM = rankingService.searchM();
		System.out.println("아침"+rankingM);
		model.addAttribute("rankingM", rankingM);
		List<Ranking> rankingH = rankingService.searchH();
		System.out.println("한식"+rankingH);
		model.addAttribute("rankingH", rankingH);
		List<Ranking> rankingI = rankingService.searchI();
		System.out.println("일품"+rankingI);
		model.addAttribute("rankingI", rankingI);
		
		model.addAttribute("rankingBoardContent", "ranking_board/listBoard.jsp");
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

		List<Ranking> rankingList = rankingService.searchN();
		System.out.println("저녁"+rankingList);
		model.addAttribute("rankingList", rankingList);
		List<Ranking> rankingM = rankingService.searchM();
		System.out.println("아침"+rankingM);
		model.addAttribute("rankingM", rankingM);
		List<Ranking> rankingH = rankingService.searchH();
		System.out.println("한식"+rankingH);
		model.addAttribute("rankingH", rankingH);
		List<Ranking> rankingI = rankingService.searchI();
		System.out.println("일품"+rankingI);
		model.addAttribute("rankingI", rankingI);
		
		model.addAttribute("rankingBoardContent", "ranking_board/listBoard.jsp");
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
		
		List<Ranking> rankingList = rankingService.searchN();
		System.out.println("저녁"+rankingList);
		model.addAttribute("rankingList", rankingList);
		List<Ranking> rankingM = rankingService.searchM();
		System.out.println("아침"+rankingM);
		model.addAttribute("rankingM", rankingM);
		List<Ranking> rankingH = rankingService.searchH();
		System.out.println("한식"+rankingH);
		model.addAttribute("rankingH", rankingH);
		List<Ranking> rankingI = rankingService.searchI();
		System.out.println("일품"+rankingI);
		model.addAttribute("rankingI", rankingI);
		
		model.addAttribute("rankingBoardContent", "ranking_board/listBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "searchUpdateMenu.do", method = RequestMethod.POST)
	public String searchUpdateMenu(Model model, NoticePageBean noticebean, ReviewPageBean bean, String dietDate, int scode){
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		
		model.addAttribute("updateMenuContent", "weekly_menu/updateMenu.jsp");
		model.addAttribute("oneDiet", dietService.search(dietDate, scode));
		
		List<Ranking> rankingList = rankingService.searchN();
		System.out.println("저녁"+rankingList);
		model.addAttribute("rankingList", rankingList);
		List<Ranking> rankingM = rankingService.searchM();
		System.out.println("아침"+rankingM);
		model.addAttribute("rankingM", rankingM);
		List<Ranking> rankingH = rankingService.searchH();
		System.out.println("한식"+rankingH);
		model.addAttribute("rankingH", rankingH);
		List<Ranking> rankingI = rankingService.searchI();
		System.out.println("일품"+rankingI);
		model.addAttribute("rankingI", rankingI);
		
		model.addAttribute("rankingBoardContent", "ranking_board/listBoard.jsp");
		
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
		
		List<Ranking> rankingList = rankingService.searchN();
		System.out.println("저녁"+rankingList);
		model.addAttribute("rankingList", rankingList);
		List<Ranking> rankingM = rankingService.searchM();
		System.out.println("아침"+rankingM);
		model.addAttribute("rankingM", rankingM);
		List<Ranking> rankingH = rankingService.searchH();
		System.out.println("한식"+rankingH);
		model.addAttribute("rankingH", rankingH);
		List<Ranking> rankingI = rankingService.searchI();
		System.out.println("일품"+rankingI);
		model.addAttribute("rankingI", rankingI);
		
		model.addAttribute("rankingBoardContent", "ranking_board/listBoard.jsp");
		
		return "index";
	}
	
	
}