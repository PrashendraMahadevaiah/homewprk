package com.ib.trading.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="trade_seq",sequenceName="trade_seq", allocationSize=1)
public class Trade implements Serializable, BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1594112252224854074L;
	
	@GeneratedValue
	@Id
	private Long id = null;
	
	public enum TradeDirection {BUY, SELL;};
	
	private TradeDirection tradeDirection  = null;
	
	private Long quantity = null;
	
	public enum TradeSymbol{RBS, UBS};
	
	private TradeSymbol tradeSymbol = null;
	
	private BigDecimal value = null;
	
	@OneToOne
	private Account account =  null;
		
	public TradeSymbol getTradeSymbol() {
		return tradeSymbol;
	}

	public void setTradeSymbol(TradeSymbol tradeSymbol) {
		this.tradeSymbol = tradeSymbol;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public TradeDirection getTradeDirection() {
		return tradeDirection;
	}

	public void setTradeDirection(TradeDirection tradeDirection) {
		this.tradeDirection = tradeDirection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
