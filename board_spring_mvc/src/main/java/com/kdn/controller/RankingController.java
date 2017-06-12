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
import com.kdn.model.domain.RankingPageBean;
import com.kdn.model.domain.Review;
import com.kdn.model.domain.ReviewPageBean;

@Controller
public class RankingController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private RankingService rankingService;
	
	@Autowired
	private NoticeBoardService noticeBoardService;
	
	@Autowired
	private DietService dietService;
	@RequestMapping(value="listRanking.do", method=RequestMethod.GET)
	public String listReview(ReviewPageBean bean, Model model, NoticePageBean noticebean, RankingPageBean rankingbean) {
		/*List<Review> list = reviewService.searchAll(bean);
		model.addAttribute("list", list);
		model.addAttribute("reviewPageBean", bean);
		model.addAttribute("reviewBoardContent", "review_board/listReview.jsp");*/
		
	/*	System.out.println("NoticeBoardController.listBoard>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("NoticePageBean>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+noticebean);
		List<NoticeBoard> noticeList = noticeBoardService.searchAll(noticebean);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("noticePageBean", noticebean);
		model.addAttribute("noticeBoardContent", "notice_board/listBoard.jsp");*/
		
	/*	List<Diet> dietList = dietService.searchAll();
		System.out.println("dietList : " + dietList);
		model.addAttribute("dietList", dietList);
		model.addAttribute("weeklyMenuContent", "weekly_menu/weeklyMenu.jsp");
		*/
		List<Ranking> rankingList = rankingService.searchAll(rankingbean);
		model.addAttribute("rankingList", rankingList);
		model.addAttribute("rankingBoardContent", "ranking_board/listBoard.jsp");
		return "index";

	}



}
