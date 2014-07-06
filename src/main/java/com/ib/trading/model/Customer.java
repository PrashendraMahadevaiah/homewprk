package com.ib.trading.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="cust_seq",sequenceName="cust_seq", allocationSize=1)
public class Customer implements BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1594112252224854074L;
	
	@GeneratedValue
	@Id
	private Long id = null;
	
	private String name = null;
	
	@Embedded
	private Address address = null;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public static class Address {
	
		private String street;
		private String city;
		private String country;
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
	}


}
