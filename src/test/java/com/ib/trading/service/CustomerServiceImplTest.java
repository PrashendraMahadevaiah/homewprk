package com.ib.trading.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ib.trading.dao.BaseIntegrationTest;
import com.ib.trading.model.Customer;
import com.ib.trading.model.Customer.Address;

public class CustomerServiceImplTest extends BaseIntegrationTest{
	@Autowired
	private CustomerService customerService = null;
	
	@Test
	public void createCustomer(){
		//Given
		Customer customer = new Customer();
		customer.setName("Sangeetha");
		Address address = new Customer.Address();
		address.setCity("London");
		address.setCountry("UK");
		address.setStreet("Dominion drive");
		customer.setAddress(address);
		
		//When
		customerService.createCustomer(customer);
		
		//Then
		assertNotNull(customer.getId());
	
	}
}
