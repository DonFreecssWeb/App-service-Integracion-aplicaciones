package com.isil.appservice.customer;


import java.util.List;


public interface CustomerService {
    void addCustomer(Customer customer) throws Exception;
    void updateCustomer(Customer customer, Long id);

    void updateCustomerByEmail(Customer customer, String email) throws Exception;

    List<Customer> findAllCustomers();
    Customer findCustomerByEmail(String email);
    void deleteCustomer(Long id);

    Customer findCustomerById(Long id);
}
