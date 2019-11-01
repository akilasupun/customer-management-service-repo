package com.rental.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.rental.core.Views;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.UpdateCustomer.class)
	@Column(name = "CUSTOMER_ID")
	private Long cusId;

	@JsonView({ Views.NewCustomer.class, Views.UpdateCustomer.class })
	@Column(name = "FIRST_NAME")
	private String firstName;

	@JsonView({ Views.NewCustomer.class, Views.UpdateCustomer.class })
	@Column(name = "LAST_NAME")
	private String lastName;
	// private String nic;

	protected Customer() {
	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", cusId, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		final Customer customer = (Customer) obj;

		if (!this.getFirstName().equals(customer.getFirstName().toString()))
			return false;
		if (!this.getLastName().equals(customer.lastName.toString()))
			return false;

		return true;
	}

}
