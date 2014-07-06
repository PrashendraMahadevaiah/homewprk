package com.ib.trading.service;

import com.ib.trading.model.Trade;

public interface TradeService {
	public void createTrade(Long accountId, Trade trade);
}
