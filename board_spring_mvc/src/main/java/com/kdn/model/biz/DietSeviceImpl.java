package com.kdn.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kdn.model.domain.Diet;
import com.kdn.model.domain.Food;
import com.kdn.model.domain.PageBean;
import com.kdn.model.domain.UpdateException;
import com.kdn.util.PageUtility;

@Service("DietService")
public class DietSeviceImpl implements DietService {

	@Autowired
	@Qualifier("dietDao")
	private DietDao dao;
	
	@Override
	public void update(Diet diet) {
		try{
			dao.update(diet);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new UpdateException("DB Update error"); 
		}
	}

	@Override
	public void remove(int dietNo) {
		try{
			dao.remove(dietNo);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new UpdateException("DB Delete error"); 
		}
	}

	@Override
	public Diet search(int dietNo) {
		try{
			return dao.search(dietNo);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new UpdateException("DB Delete error"); 
		}
	}

	@Override
	public void add(Diet food) {
		try{
			int dietNo = dao.getDietNo();
			food.setDietNo(dietNo);
			dao.add(food);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new UpdateException("DB Add error");
		}
	}

	@Override
	public List<Diet> searchAll() {
		try{
		    return dao.search5Diet();
		} catch(Exception e){
			 e.printStackTrace();
	         throw new UpdateException("DB SearchAll error");
		}
	}


}