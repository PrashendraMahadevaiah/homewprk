package com.ib.trading.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ib.trading.dao.BaseIntegrationTest;
import com.ib.trading.model.Account;
import com.ib.trading.model.Trade;
import com.ib.trading.model.Trade.TradeDirection;
import com.ib.trading.model.Trade.TradeSymbol;

public class TradeServiceImplTest extends BaseIntegrationTest {
	@Autowired
	private TradeService tradeService = null;
	
	@Autowired
	private AccountService accountService = null;
	
	@Test
	public void createTrade(){
		//Given
		Account account = new Account();
		account.setName("SpreadBet");
		accountService.createAccount(account);
		Trade trade = new Trade();
		trade.setQuantity(100L);
		trade.setTradeDirection(TradeDirection.BUY);
		trade.setTradeSymbol(TradeSymbol.RBS);
		trade.setValue(new BigDecimal(1000.00));
			
		//When
		tradeService.createTrade(account.getId(), trade);
		
		//Then
		assertNotNull(trade.getId());
		
		assertEquals(0L, account.getBalance().longValue());
	}
}
