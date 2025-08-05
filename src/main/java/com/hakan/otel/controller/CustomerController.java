package com.hakan.otel.controller;

import com.hakan.otel.dto.Customer.CustomerAdminDTO;
import com.hakan.otel.dto.Customer.CustomerDTO;
import com.hakan.otel.entity.Customer;
import com.hakan.otel.mapper.Customer.CustomerMapper;
import com.hakan.otel.service.CustomerService.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // frontend için.
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    // 1. Resepsiyon görevlisi / kısıtlı görünüm
    @GetMapping("/customers")
    public List<CustomerDTO> findAllCustomers() {

        List<Customer> customers = customerService.findAllCustomers();

        List<CustomerDTO> dtoList = new ArrayList<>();

        for (Customer customer : customers) {
            dtoList.add(CustomerMapper.toCustomerDTO(customer));
        }
        return dtoList;
    }

    // 2. Admin için tam görünüm
    @GetMapping("/admin/customers")
    public List<CustomerAdminDTO> findAllCustomersAdmin() {
        List<Customer> customers = customerService.findAllCustomers();
        List<CustomerAdminDTO> dtoList = new ArrayList<>();

        for (Customer customer : customers) {
            dtoList.add(CustomerMapper.toCustomerAdminDTO(customer));
        }
        return dtoList;
    }

    // Admin görünümü: tüm bilgileri döner.
    @GetMapping("/admin/customers/{id}")
    public ResponseEntity<?> findCustomerByIdAdmin(@PathVariable Long id){
        Optional<Customer> customerOpt = customerService.findCustomerById(id);

        if(customerOpt.isPresent()){
            Customer customer = customerOpt.get();
            // Yetkiye göre DTO seçimi yapılabilir. Burada örnek Admin DTO ile dönüş:
            CustomerAdminDTO dto = CustomerMapper.toCustomerAdminDTO(customer);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Resepsiyon / genel görünüm: sadece kısıtlı bilgileri döner.
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id){
        Optional<Customer> customerOpt = customerService.findCustomerById(id);

        if(customerOpt.isPresent()){
            CustomerDTO dto = CustomerMapper.toCustomerDTO(customerOpt.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/customers")
    public ResponseEntity<CustomerAdminDTO> createCustomer(@RequestBody @Valid CustomerAdminDTO customerAdminDTO){
        Customer customer = CustomerMapper.toCustomer(customerAdminDTO);
        Customer savedCustomer = customerService.saveCustomer(customer);
        CustomerAdminDTO responseDto = CustomerMapper.toCustomerAdminDTO(savedCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }



    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
