package com.ib.trading.service;

import com.ib.trading.model.Account;

public interface AccountService {
	public Account getAccount(Long id);
	public void createAccount(Account account);
}
