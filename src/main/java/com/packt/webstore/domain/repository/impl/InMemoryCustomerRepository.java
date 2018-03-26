package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {
        Customer customer1 = new Customer("1","Stefan","Dluga 3 Warszawa");
        Customer customer2 = new Customer("2","Zbyszek","Krótka 2 Wrocław");
        Customer customer3 = new Customer("3","Andrzej","Nowa 33 Poznań");

        listOfCustomers.add(customer1);
        listOfCustomers.add(customer2);
        listOfCustomers.add(customer3);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
