package com.kdn.model.dao;

import java.util.List;

import com.kdn.model.biz.FoodDao;
import com.kdn.model.domain.Board;
import com.kdn.model.domain.Food;
import com.kdn.model.domain.PageBean;

public class FoodDaoImpl implements FoodDao {

	@Override
	public void add(Food food) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Food food) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int fno) {
		// TODO Auto-generated method stub

	}

	@Override
	public Board search(int fno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> searchAll(PageBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(PageBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFoodNo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
