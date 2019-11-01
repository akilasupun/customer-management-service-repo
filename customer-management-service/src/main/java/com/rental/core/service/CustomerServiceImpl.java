package com.rental.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.core.model.Customer;
import com.rental.core.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer findCustomer(Long customerId) {
		return repository.findById(customerId).orElse(null);
	}

	@Override
	public Boolean saveCustomer(Customer newCustomer) {
		if (newCustomer.getCusId() != null)
			newCustomer.setCusId(null);
		return newCustomer.equals(repository.save(newCustomer));

	}

	@Override
	public Boolean updateCustomer(Customer updatedCustomer) {
		return updatedCustomer.equals(repository.save(updatedCustomer));
	}

	@Override
	public Boolean deleteCustomer(Long customerId) {
		if (!repository.existsById(customerId))
			return false;
		repository.deleteById(customerId);
		return true;
	}

}
