package com.github.smsilva.batch.integration.demo.transformers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;

@Configuration
public class CustomerTransformerConfig {

    @Bean
    @Transformer(
            inputChannel = "customerTransformChannel",
            outputChannel = "inputCustomers")
    public CustomerTransformer customerTransformer() {
        return new CustomerTransformer();
    }

}
