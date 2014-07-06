package com.ib.trading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ib.trading.dao.CustomerDAO;
import com.ib.trading.model.Customer;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO customerDAO = null;
	
	public Customer getCustomer(Long id) {
		return customerDAO.find(id);
	}

	public void createCustomer(Customer customer) {
		customerDAO.save(customer);
		
	}

}
