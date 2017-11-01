package com.cg.balance.DAO;

import java.util.ArrayList;

import com.cg.balance.exception.BalanceException;
import com.cg.bean.BalanceInfo;

public interface IBalanceDAO {
		
	int insert(BalanceInfo bean) throws BalanceException;

	

	ArrayList<Integer> retrieveId() throws BalanceException;
}
