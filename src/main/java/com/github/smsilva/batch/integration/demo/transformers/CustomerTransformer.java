package com.github.smsilva.batch.integration.demo.transformers;

import com.github.smsilva.batch.integration.demo.domain.Customer;
import org.springframework.integration.core.GenericTransformer;

public class CustomerTransformer implements GenericTransformer<String, Customer> {

    @Override
    public Customer transform(String line) {
        String[] fields = line.split(",");

        Customer customer = new Customer();
        customer.setId(fields[0]);
        customer.setName(fields[1]);

        return customer;
    }

}
