package com.rental.core;

/**
 * This class is used to limit/organize Auto-Mapping fields in an object when
 * using Jackson, based on the requirement of the method that is being used to
 * call with {@link org.springframework.web.bind.annotation.RequestBody}
 * 
 * @author Akila
 *
 */
public class Views {
	/**
	 * This class is used to map all the field including {@code Id}field when
	 * mapping Customer object in {@code /updateCustomer} method.
	 * 
	 * @author Akila
	 *
	 */
	public static class UpdateCustomer {
	}

	/**
	 * This class is used to ignore {@link com.rental.core.model.Customer #cusId
	 * cusId} when capturing json object in
	 * {@link com.rental.core.controller.CustomerController #addCustomer(com.rental.core.model.Customer)
	 * addCustomer}
	 * 
	 * @author Akila
	 *
	 */
	public static class NewCustomer extends UpdateCustomer {
	}
}
