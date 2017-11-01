package com.cg.balance.service;

import java.util.ArrayList;

import com.cg.balance.exception.BalanceException;
import com.cg.bean.BalanceInfo;

public interface IBalanceService {

	ArrayList<Integer> retrieveId() throws BalanceException;
	int insert(BalanceInfo bean) throws BalanceException;
	int amt(int amount);
	boolean setamt(int amount);
}
