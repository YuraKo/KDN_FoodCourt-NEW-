package com.kdn.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdn.model.biz.RankingDao;
import com.kdn.model.domain.Ranking;
import com.kdn.model.domain.RankingPageBean;
@Repository("rankingDao")
public class RankingDaoImpl implements RankingDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<Ranking> searchAll(RankingPageBean rankingbean) {
		RowBounds rows = new RowBounds(rankingbean.getStart()-1, rankingbean.getInterval());
		
		return session.selectList("ranking.searchAll", rankingbean, rows);
	}

	@Override
	public int getCount(RankingPageBean rankingbean) {
		// TODO Auto-generated method stub
		return session.selectOne("ranking.getCount", rankingbean);
	}

}
