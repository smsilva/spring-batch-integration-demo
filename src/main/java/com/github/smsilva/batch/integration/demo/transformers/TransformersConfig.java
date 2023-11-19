package com.github.smsilva.batch.integration.demo.transformers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.file.transformer.FileToStringTransformer;

@Configuration
public class TransformersConfig {

    @Bean
    @Transformer(
            inputChannel = "fileInputChannel",
            outputChannel = "processFileChannel")
    public FileToStringTransformer fileToStringTransformer() {
        return new FileToStringTransformer();
    }

}
