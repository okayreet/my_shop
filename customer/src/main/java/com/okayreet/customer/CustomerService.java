package com.okayreet.customer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerResponse getCustomerById(@NonNull Long customer_id) {
        Customer customer = customerRepository.findById(customer_id).get();
        return CustomerResponse.builder()
                .id(customer_id)
                .name(customer.getFirstName() + " " + customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .telephoneNumber(customer.getTelephoneNumber())
                .email(customer.getEmail())
                .address_1(customer.getAddress_1())
                .address_2(customer.getAddress_2())
                .city(customer.getCity())
                .postCode(customer.getPostCode())
                .build();
    }
}