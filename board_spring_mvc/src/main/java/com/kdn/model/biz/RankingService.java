package com.kdn.model.biz;

import java.util.List;

import com.kdn.model.domain.Ranking;
import com.kdn.model.domain.RankingPageBean;

public interface RankingService {
	public List<Ranking> searchAll(RankingPageBean rankingbean);

}