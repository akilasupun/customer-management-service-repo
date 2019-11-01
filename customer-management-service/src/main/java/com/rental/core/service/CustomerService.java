package com.rental.core.service;

import com.rental.core.model.Customer;

public interface CustomerService {
	/**
	 * Retrieve a Customer by customer id
	 * 
	 * @param customerId customerId of the customer that has to be found.
	 * @return retrieved customer using the provided customerId.
	 */
	public Customer findCustomer(Long customerId);

	/**
	 * Save provided Customer object.
	 * 
	 * @param newCustomer Customer object that has to be saved
	 * @return Returns {@code True} if object saved successfully and {@code False}
	 *         otherwise.
	 */
	public Boolean saveCustomer(Customer newCustomer);

	/**
	 * Persist updated Customer Entity based on the Id of the old Entity. This will
	 * replace the old database entry with the updated entity.
	 * 
	 * @param updatedCustomer Customer Entity which is updated
	 * @return {@code True} if updated successfully otherwise {@code False}
	 */
	public Boolean updateCustomer(Customer updatedCustomer);

	/**
	 * Delete the Customer based on the given {@code customrId}
	 * 
	 * @param customerId Id of the Customer that has to be deleted.
	 * @return returns {@code True} if Customer deleted successfully otherwise
	 *         {@code False}
	 */
	public Boolean deleteCustomer(Long customerId);
}
