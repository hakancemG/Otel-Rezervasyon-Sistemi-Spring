package com.hakan.otel.service.CustomerService;

import com.hakan.otel.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Optional<Customer> findCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);
}
