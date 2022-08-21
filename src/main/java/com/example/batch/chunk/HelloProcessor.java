package com.example.batch.chunk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope
@Slf4j
public class HelloProcessor implements ItemProcessor<String,String> {

    @Value("#{JobExecutionContext['jobKey']}")
    private String jobValue;

    @Value("#{StepExecutionContext['stepKey']}")
    private String stepValue;

    @Value("#{jobParameters['require1']}")
    private String require1;

    @Value("#{jobParameters['option1']}")
    private String option1;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution){
        log.info("jobKey={}",jobValue);
        log.info("stepKey={}",stepValue);
        log.info("require1={}",require1);
        log.info("option1={}",option1);
    }

    @Override
    public String process(String item) throws Exception {
        item = item + "☆";
        log.info("Processor:{}",item);
        return item;
    }
}
