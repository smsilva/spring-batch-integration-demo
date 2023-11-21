package com.github.smsilva.batch.integration.demo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoJobConfig {

    private final JobRepository repository;

    public DemoJobConfig(JobRepository repository) {
        this.repository = repository;
    }

    @Bean
    public Job demoJob(Step firstStep) {
        return new JobBuilder("demoJob", repository)
                .start(firstStep)
                .build();
    }

}
