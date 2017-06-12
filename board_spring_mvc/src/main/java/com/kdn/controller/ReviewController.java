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
import com.kdn.model.domain.PageBean;
import com.kdn.model.domain.Review;
import com.kdn.model.domain.ReviewPageBean;

@Controller
public class ReviewController {
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
		model.addObject("reviewBoardContent", "ErrorHandler.jsp"); 
		return model;
	}
	
	@RequestMapping(value="insertReviewForm.do", method=RequestMethod.GET)
	public String insertBoardForm(Model model) {
		return "index";
	}
	@RequestMapping(value="insertReview.do", method=RequestMethod.POST)
	public String insertBoard(Review review) {
		reviewService.add(review);
		return "redirect:listReview.do";
	}
	@RequestMapping(value="updateReview.do", method=RequestMethod.POST)
	public String updateBoard(Review review) {
		System.out.println("this is update review : " + review);
		reviewService.update(review);
		System.out.println(review);
		return "redirect:listReview.do";
	}
	
	@RequestMapping(value="listReview.do", method=RequestMethod.GET)
	public String listReview(ReviewPageBean bean, Model model, NoticePageBean noticebean) {
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewPageBean", bean);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		
		
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticePageBean", noticebean);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");
		
		List<Diet> dietList = dietService.searchAll();
		model.addAttribute("dietList", dietList);
		model.addAttribute("weeklyMenuContent", "weekly_menu/weeklyMenu.jsp");
		
		return "index";

	}

	@RequestMapping(value="searchReviewBoard.do", method=RequestMethod.GET)
	public String searchBoard(int no, Model model) {
		model.addAttribute("reviewBoard", reviewService.search(no));
		model.addAttribute("reviewBoardContent", "review_board/searchBoard.jsp");
		return "index";
	}

}
