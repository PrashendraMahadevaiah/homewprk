package com.ib.trading.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ib.trading.dao.AccountDAO;
import com.ib.trading.dao.TradeDAO;
import com.ib.trading.model.Account;
import com.ib.trading.model.Trade;

@Service
@Transactional
public class TradeServiceImpl implements TradeService {
	@Autowired
	private AccountDAO accountDAO = null;
	
	@Autowired
	private TradeDAO tradeDAO = null;
	
	public void createTrade(Long accountId, Trade trade) {
		Account account = accountDAO.find(accountId);
		if(account == null){
			throw new RuntimeException("Account not found with id - "+accountId);
		}
		
		trade.setAccount(account);
		updateBalance(account, trade);
		tradeDAO.save(trade);
	}
	
	private void updateBalance(Account account , Trade trade){
		switch(trade.getTradeDirection()){
			case BUY:
				account.setBalance(account.getBalance().subtract(trade.getValue()));
				break;
			case SELL:
				account.setBalance(account.getBalance().add(trade.getValue()));
				break;
				
		}
	}

}
