package com.ib.trading.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ib.trading.model.Trade;
import com.ib.trading.model.Trade.TradeDirection;
import com.ib.trading.model.Trade.TradeSymbol;

public class TradeDAOImplTest extends BaseIntegrationTest{
	@Autowired
	private TradeDAO tradeDAO = null;
	
	@Test
	public void save(){
		//Given
		Trade trade = new Trade();
		trade.setTradeSymbol(TradeSymbol.RBS);
		trade.setTradeDirection(TradeDirection.BUY);
		trade.setQuantity(100L);
		trade.setValue(new BigDecimal(1000L));
		
		//When
		tradeDAO.save(trade);
		
		//Then
		assertNotNull(trade.getId());
		assertTrue(trade.getId() > 0);

	}
	
	@Test
	public void find(){
		//Given
		Trade trade = new Trade();
		trade.setTradeSymbol(TradeSymbol.RBS);
		trade.setTradeDirection(TradeDirection.BUY);
		trade.setQuantity(100L);
		trade.setValue(new BigDecimal(1000L));
		tradeDAO.save(trade);
		
		//When
		Trade retTrade = tradeDAO.find(trade.getId());
		
		//Then
		assertEquals(trade, retTrade);
	}
	
	
	@Test
	public void delete(){
		//Given
		Trade trade = new Trade();
		trade.setTradeSymbol(TradeSymbol.RBS);
		trade.setTradeDirection(TradeDirection.BUY);
		trade.setQuantity(100L);
		trade.setValue(new BigDecimal(1000L));
		tradeDAO.save(trade);
		
		//When
		tradeDAO.delete(trade.getId());
		
		//Then
		assertNull(tradeDAO.find(trade.getId()));
	}
	
	

}
