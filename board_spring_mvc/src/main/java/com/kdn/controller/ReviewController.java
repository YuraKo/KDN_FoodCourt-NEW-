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
import com.kdn.model.domain.ReviewPageBean;

@Controller
public class ReviewController {
	
//	@ExceptionHandler
//	public ModelAndView handler(Exception e) {
//		ModelAndView model = new ModelAndView("index");
//		model.addObject("msg", e.getMessage()); //request占쎈퓠 占쏙옙占쎌삢
//		model.addObject("reviewBoardContent", "ErrorHandler.jsp"); //request占쎈퓠 占쏙옙占쎌삢
//		return model;
//		
//	}
	@Autowired
	private ReviewService reviewService;
	
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
		reviewService.update(review);
		System.out.println(review);
		return "redirect:listReview.do";
	}
	
	@RequestMapping(value="listReview.do", method=RequestMethod.GET)
	public String listReview(ReviewPageBean bean, Model model) {
		List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");
		return "index";

	}

	@RequestMapping(value="searchReviewBoard.do", method=RequestMethod.GET)
	public String searchBoard(int no, Model model) {
		model.addAttribute("reviewBoard", reviewService.search(no));
		model.addAttribute("reviewBoardContent", "review_board/searchBoard.jsp");
		return "index";
		
	}


	@RequestMapping(value="test2.do", method=RequestMethod.GET)
	public String test(int rno, Model model) {
		model.addAttribute("reviewBoard", reviewService.search(rno));
		model.addAttribute("reviewBoardContent", "review_board/searchBoard.jsp");
		return "index";
		
	}


}
