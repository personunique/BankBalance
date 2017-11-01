package com.cg.balance.service;

import java.util.ArrayList;

import com.cg.balance.DAO.BalanceDAOImpl;
import com.cg.balance.DAO.IBalanceDAO;
import com.cg.balance.exception.BalanceException;
import com.cg.bean.BalanceInfo;



public class BalanceServiceImpl implements IBalanceService{
	IBalanceDAO dao=null;
	
	@Override
	public ArrayList<Integer> retrieveId() throws BalanceException {
		
		dao=new BalanceDAOImpl();
		return dao.retrieveId();
	}

	@Override
	public int insert(BalanceInfo bean) throws BalanceException {
		
		dao=new BalanceDAOImpl();
		return dao.insert(bean);
	}

	

	@Override
	public boolean setamt(int amount) {
		if(amount>10000)
		{
			return false;
		}
		else
		{
			return true;
	}
	}

	@Override
	public int amt(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
