package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		Customer newCustomer = getCustomer(customer.getId());
		if (customer.getEmail() != null) {
			newCustomer.setEmail(customer.getEmail());
		}
		if (customer.getFirstName() != null) {
			newCustomer.setFirstName(customer.getFirstName());
		}
		if (customer.getLastName() != null) {
			newCustomer.setLastName(customer.getLastName());
		}
		saveCustomer(newCustomer);
		return newCustomer;

	}

}
