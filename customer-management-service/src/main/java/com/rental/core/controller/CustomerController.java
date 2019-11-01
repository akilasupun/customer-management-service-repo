package com.rental.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.rental.core.Views;
import com.rental.core.model.Customer;
import com.rental.core.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerService;

	@PostMapping(path = "/addCustomer")
	public void addCustomer(@RequestBody @JsonView(Views.NewCustomer.class) Customer newCustomer) {
		customerService.saveCustomer(newCustomer);
	}

	@GetMapping(path = "/getCustomer/{customerId}", produces = "application/json")
	public Customer retreiveCustomer(@PathVariable Long customerId) {
		return customerService.findCustomer(customerId);
	}

	@PutMapping(path = "/updateCustomer")
	public void updateCustomer(@RequestBody @JsonView(Views.UpdateCustomer.class) Customer updatedCustomer) {
		customerService.updateCustomer(updatedCustomer);
	}

	@DeleteMapping(path = "/deleteCustomer/{id}")
	public ResponseEntity<?> removeCustomer(@PathVariable Long id) {
		if (!customerService.deleteCustomer(id))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		return ResponseEntity.ok("Customer Deleted succesfully!");

	}
}
