package com.ib.trading.service;

import com.ib.trading.model.Customer;

public interface CustomerService {
	public Customer getCustomer(Long id);
	public void createCustomer(Customer customer);
}
