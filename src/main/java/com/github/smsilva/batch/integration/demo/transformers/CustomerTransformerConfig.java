package com.github.smsilva.batch.integration.demo.transformers;

import com.github.smsilva.batch.integration.demo.domain.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.GenericTransformer;

@Configuration
public class CustomerTransformerConfig {

    @Bean
    @Transformer(
            inputChannel = "customerTransformChannel",
            outputChannel = "inputCustomers")
    public GenericTransformer<String, Customer> stringToCustomerTransformer() {
        return new CustomerTransformer();
    }

}
