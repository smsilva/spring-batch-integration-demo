package com.github.smsilva.batch.integration.demo.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.Message;

@Configuration
public class LoggingHandlerConfig {

    @Bean
    @ServiceActivator(inputChannel = "processFileChannel")
    public LoggingHandler logging() {
        LoggingHandler adapter = new LoggingHandler(LoggingHandler.Level.INFO);
        adapter.setLoggerName(LoggingHandler.class.getName());
        adapter.setLogExpressionString("headers.id + ': ' + payload");
        return adapter;
    }

}
