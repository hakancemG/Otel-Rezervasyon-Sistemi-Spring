package com.hakan.otel.service.CustomerService;

import com.hakan.otel.entity.Customer;
import com.hakan.otel.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(Long id){
        return customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
