package com.kdn.model.biz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kdn.model.domain.FileBean;
import com.kdn.model.domain.NoticeBoard;
import com.kdn.model.domain.PageBean;
import com.kdn.model.domain.UpdateException;
import com.kdn.util.PageUtility;

@Service("noticeBaordService")
public class NoticeBoardServiceImpl implements NoticeBoardService {
	
	@Autowired
	   @Qualifier("noticeBoardDao")
	   private NoticeBoardDao dao;

	@Override
	public void update(NoticeBoard noticeBoard) {
		try {
	         dao.update(noticeBoard);
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new UpdateException("게시글 수정 중 오류 발생");
	      }
	}

	@Override
	public void remove(int nno) {
		try {
			dao.removeFiles(nno);
			dao.remove(nno);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UpdateException("삭제 중 오류 발생");
		}

	}

	@Override
	public NoticeBoard search(int nno) {
		try {
			System.out.println("search>>>>>>>>>>>>>>>>>>>@service");
			System.out.println(nno);
			return dao.search(nno);
		} catch (Exception e) {
			e.printStackTrace();		
			throw new UpdateException("검색 중 오류 발생");
		}

	}

	@Override
	public void add(NoticeBoard noticeBoard, String dir) {
		System.out.println("insert notice board >>>>>>>>>>>>>>>>>>>>>>>>> @Service1");
		File[] files = null;
		int size = 0;
		
		try {			
			int nno = dao.getNoticeBoardNo();	
			noticeBoard.setNno(nno);
			System.out.println("insert notice board >>>>>>>>>>>>>>>>>>>>>>>>> @Service2");
			dao.add(noticeBoard);			
			System.out.println("insert notice board >>>>>>>>>>>>>>>>>>>>>>>>> @Service3");
			MultipartFile[] fileup = noticeBoard.getFileup();			
			int index = 0;					
			if(fileup != null){
				size = fileup.length;				
				files = new File[size];	
				ArrayList<FileBean> fileInfo = new ArrayList<FileBean>(size);
				String rfilename = null;
				String sfilename = null;
				for(MultipartFile file : fileup){
					rfilename = file.getOriginalFilename();
					sfilename = String.format("%d%s", System.currentTimeMillis(), rfilename);				
					fileInfo.add(new FileBean(rfilename, sfilename));					
					String pathname = String.format("%s/%s", dir, sfilename);					
					files[index] = new File(pathname);
					file.transferTo(files[index++]);
				}			
				dao.addFiles(fileInfo, nno);
			}
		} catch (Exception e) {
			e.printStackTrace();			
			if(files!=null){
				for(File file : files){
					if(file!=null && file.exists()){
						file.delete();
					}
				}
			}
			
			throw new UpdateException("개시글 작성 중 오류");
		}

	}

	@Override
	public List<NoticeBoard> searchAll(PageBean bean) {
		try {
			System.out.println("searchAll============@serviceimpl");
			int total = dao.getCount(bean);
			System.out.println("afer dao.getCount");
			
			PageUtility bar = 
			  new PageUtility(bean.getInterval()
					  		, total
					  		, bean.getPageNo()
					  		, "images/");
			bean.setPagelink(bar.getPageBar());
			
			return dao.searchAll(bean);
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new UpdateException("리스트 작성 중 오류 발생");
		}
	}
}
