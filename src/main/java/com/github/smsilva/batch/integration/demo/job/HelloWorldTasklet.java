package com.github.smsilva.batch.integration.demo.job;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class HelloWorldTasklet implements Tasklet {

    private final String name;

    public HelloWorldTasklet(@Value("#{jobParameters['name']}") String name) {
        this.name = name;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.printf("Hello, %s!%n", name);
        return RepeatStatus.FINISHED;
    }

    public String getName() {
        return name;
    }

}
