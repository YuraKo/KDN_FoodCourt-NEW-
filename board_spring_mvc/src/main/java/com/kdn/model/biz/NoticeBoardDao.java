package com.kdn.model.biz;

import java.util.List;

import com.kdn.model.domain.FileBean;
import com.kdn.model.domain.NoticeBoard;
import com.kdn.model.domain.PageBean;

public interface NoticeBoardDao {
	public void 	add(NoticeBoard noticeBoard) 	;
	public void 	update(NoticeBoard noticeBoard) ;
	public void 	remove(int nno) 		;
	public NoticeBoard 	search(int nno) 		;
	public List<NoticeBoard> searchAll(PageBean bean) ;
	public int 		getCount(PageBean bean) ;
	public int 		getNoticeBoardNo() 			;
	public void 	addFiles(List<FileBean> files, int nno) ;
	public void 	removeFiles(int nno) ;
}





