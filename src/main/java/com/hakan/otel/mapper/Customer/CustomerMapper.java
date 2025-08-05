package com.hakan.otel.mapper.Customer;

import com.hakan.otel.dto.Customer.CustomerAdminDTO;
import com.hakan.otel.dto.Customer.CustomerDTO;
import com.hakan.otel.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO toCustomerDTO(Customer customer){
        return CustomerDTO.builder().
                id(customer.getId()).
                firstName(customer.getFirstName()).
                lastName(customer.getLastName()).
                build();
    }
    public static CustomerAdminDTO toCustomerAdminDTO(Customer customer){
        return CustomerAdminDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .tckn(customer.getTckn())
                .build();
    }

    public static Customer toCustomer(CustomerAdminDTO dto) {
        if (dto == null) {
            return null;
        }

        return Customer.builder()
                .id(dto.getId()) // DTO içinde varsa
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .tckn(dto.getTckn())
                .build();
    }

}
