package com.kdn.model.biz;

import java.util.List;

import com.kdn.model.domain.PageBean;
import com.kdn.model.domain.Review;

public interface ReviewDao {
	public void 	add(Review review) 	;
	public void 	update(Review review) ;
	public void 	remove(int rno) 		;
	public Review 	search(int rno) 		;
	public List<Review> searchAll(PageBean bean) ;
	public int 		getCount(PageBean bean) ;
	public int 		getBoardNo() 			;
}





