package com.github.smsilva.batch.integration.demo.adapters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

import java.io.File;

@Configuration
public class FileInboundChannelAdapter {

    @Value("${app.inbound.file.path}")
    String inboundFilePath;

    @Bean
    @InboundChannelAdapter(
            value = "fileInputChannel",
            poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        var source = new FileReadingMessageSource();
        source.setDirectory(new File(inboundFilePath));
        source.setFilter(new SimplePatternFileListFilter("*.txt"));
        source.setFilter(new AcceptOnceFileListFilter<>());
        return source;
    }

}
