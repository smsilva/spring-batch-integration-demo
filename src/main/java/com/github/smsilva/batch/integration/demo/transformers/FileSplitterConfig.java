package com.github.smsilva.batch.integration.demo.transformers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.file.splitter.FileSplitter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class FileSplitterConfig {

    @Bean
    @Splitter(inputChannel = "fileInputChannel")
    public MessageHandler fileSplitter(MessageChannel customerTransformChannel) {
        FileSplitter splitter = new FileSplitter(true, false);
        splitter.setFirstLineAsHeader("id,name");
        splitter.setApplySequence(false);
        splitter.setOutputChannel(customerTransformChannel);
        return splitter;
    }

}
