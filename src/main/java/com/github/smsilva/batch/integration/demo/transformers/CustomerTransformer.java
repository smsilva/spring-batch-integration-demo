package com.github.smsilva.batch.integration.demo.transformers;

import com.github.smsilva.batch.integration.demo.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;

public class CustomerTransformer extends AbstractTransformer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerTransformer.class);

    @Override
    protected Customer doTransform(Message<?> message) {
        String payload = (String) message.getPayload();

        String[] fields = payload.split(",");

        Customer customer = new Customer();
        customer.setId(fields[0]);
        customer.setName(fields[1]);

        return customer;
    }

}
