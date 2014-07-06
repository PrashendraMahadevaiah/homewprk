package com.ib.trading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ib.trading.dao.AccountDAO;
import com.ib.trading.model.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO = null;
	
	public Account getAccount(Long id) {
		return accountDAO.find(id);
	}

	public void createAccount(Account account) {
		accountDAO.save(account);
	}

}
