package com.github.smsilva.batch.integration.demo.channels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ChannelsConfig {

    @Bean
    public MessageChannel fileInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel processFileChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel customerTransformChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel inputCustomers() {
        return new DirectChannel();
    }

}
