package com.example.spring_batch.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfigChunk {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<String> itemReader;

    @Autowired
    private ItemProcessor<String,String> itemProcessor;

    @Autowired
    private ItemWriter<String> itemWriter;

    @Autowired
    private JobExecutionListener jobListener;

    @Autowired
    private StepExecutionListener stepListener;

    @Bean
    public JobParametersValidator jobParametersValidator(){
        DefaultJobParametersValidator validator = new DefaultJobParametersValidator();

        String[] requireKeys = new String[]{"run.id","require1"};
        validator.setRequiredKeys(requireKeys);

        String[] optionKeys = new String[]{"option1"};
        validator.setOptionalKeys(optionKeys);

        return validator;
    }

    @Bean
    public Step chunkStep(){
        return stepBuilderFactory.get("HelloChunkStep")
                .<String,String>chunk(1)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .listener(stepListener)
                .build();
    }

    @Bean
    public Job chunkJob(){
        return jobBuilderFactory.get("HelloWorldChunkJob")
                .incrementer(new RunIdIncrementer())
                .start(chunkStep())
                .listener(jobListener)
                .validator(jobParametersValidator())
                .build();
    }

}
