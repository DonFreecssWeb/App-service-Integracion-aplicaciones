package com.isil.appservice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) throws Exception {
        try {
            customerRepository.save(customer); //lo reconoce por el JpaRepository

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void updateCustomer(Customer customer, Long id) {

    }

    @Override
    public void updateCustomerByEmail(Customer customerInput, String email) throws Exception {
            String pattern ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if(customerInput.getEmail()==null){
            throw new Exception("El correo no  ha sido enviado en el request");
        }else{
            if(customerInput.getEmail().isBlank()){
                throw new Exception("El correo no puede ser vacio");
            }
            if(!customerInput.getEmail().matches(pattern)){
                throw new Exception("El correo no tiene el formato correcto");
            }

        }

        Optional<Customer> customerToUpdate = customerRepository.findCustomerByEmail(email);

        Customer customerRepo;
        if(customerToUpdate.isPresent()){
            Customer editCustomer = customerToUpdate.get();
            editCustomer.setName(customerInput.getName().isBlank()? editCustomer.getName(): customerInput.getName());
            editCustomer.setAddress(customerInput.getAddress().isBlank()? editCustomer.getAddress(): customerInput.getAddress());
            editCustomer.setLastname(customerInput.getLastname().isBlank()? editCustomer.getLastname(): customerInput.getLastname());
            editCustomer.setDocumentId(customerInput.getDocumentId().isBlank()? editCustomer.getDocumentId(): customerInput.getDocumentId());
            customerRepository.save(editCustomer);
        }else{
            throw new Exception("Usuario con el correo "+email+" no existe");
        }
    }
    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        Optional<Customer> customerToFind = customerRepository.findCustomerByEmail(email);
        //retorno eso o sino nulo
        return customerToFind.orElse(null);
    }

    @Override
    public void deleteCustomer(Long id) {
        try {
            Optional<Customer> customerToDelete = customerRepository.findById(id);
            if(customerToDelete.isEmpty()){
                throw new Exception("El cliente no existe");
            }else{
                Customer deleteCustomer = customerToDelete.get();
                customerRepository.delete(deleteCustomer);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Customer findCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }
}
