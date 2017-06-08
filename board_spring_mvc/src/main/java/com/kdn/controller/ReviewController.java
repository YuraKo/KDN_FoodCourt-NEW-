package com.kdn.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kdn.model.biz.ReviewService;
import com.kdn.model.domain.PageBean;
import com.kdn.model.domain.Review;

@Controller
public class ReviewController {
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", e.getMessage()); //request�뿉 ���옣
		model.addObject("reviewBoardContent", "ErrorHandler.jsp"); //request�뿉 ���옣
		return model;
		
	}
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="insertReviewForm.do", method=RequestMethod.GET)
	public String insertBoardForm(Model model) {
		model.addAttribute("reviewBoardContent", "review_board/insertReview.jsp");
		return "index";
	}
	@RequestMapping(value="insertReview.do", method=RequestMethod.POST)
	public String insertBoard(Review review) {
		reviewService.add(review);
		return "redirect:listReview.do";
	}
	
	@RequestMapping(value="listReview.do", method=RequestMethod.GET)
	public String listReview(PageBean bean, Model model) {
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("reviewList", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		return "index";

	}

	@RequestMapping(value="searchReview.do", method=RequestMethod.GET)
	public String searchBoard(int no, Model model) {
		model.addAttribute("review", reviewService.search(no));
		model.addAttribute("reviewBoardContent", "review_board/searchBoard.jsp");
		return "index";
		
	}
	

}
