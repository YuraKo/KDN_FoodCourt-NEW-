package com.kdn.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kdn.model.domain.Ranking;
import com.kdn.model.domain.RankingPageBean;
import com.kdn.model.domain.UpdateException;
import com.kdn.util.PageUtility;

@Service("rankingService")
public class RankingServiceImpl implements RankingService {

	@Autowired
	@Qualifier("rankingDao")
	private RankingDao dao;
	
	@Override
	public List<Ranking> searchAll(RankingPageBean rankingbean) {
		try {
	         int total = dao.getCount( rankingbean);
	         PageUtility bar = 
	           new PageUtility(rankingbean.getInterval()
	                       , total
	                       , rankingbean.getPageNo()
	                       , "images/");
	         rankingbean.setPagelink(bar.getPageBar());
	         
	         return dao.searchAll(rankingbean);
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new UpdateException("ranking searchAll error");
	      }
		
	}

}
