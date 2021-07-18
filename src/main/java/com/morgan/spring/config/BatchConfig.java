package com.morgan.spring.config;

import com.morgan.spring.batch.AddressProcessor;
import com.morgan.spring.batch.AddressReader;
import com.morgan.spring.batch.AddressWriter;
import com.morgan.spring.dto.AddressDTO;
import com.morgan.spring.dto.AddressHistoryDTO;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job buildJob(AddressReader reader, AddressWriter writer, AddressProcessor processor){
        return jobBuilderFactory.get("SachinJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(step(reader, processor, writer))
                .end()
                .build();
    }

    @Bean
    public Step step(AddressReader reader,  AddressProcessor processor, AddressWriter writer) {
        return stepBuilderFactory.get("Converter")
                .<AddressDTO, AddressHistoryDTO>chunk(5)
                .reader(reader.reader())
                .processor(processor)
                .writer(writer.write())
                .build();
    }

    private JobExecutionListener listener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                System.out.println("Starting job");
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
                    System.out.println("Ending Job");
                }
            }
        };
    }
}
