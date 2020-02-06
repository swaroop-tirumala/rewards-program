package com.company.customer.benefits.rewardsprogram.configuration;

import com.company.customer.benefits.rewardsprogram.service.processor.RewardsProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Created by Swaroop Tirumala on 02/05/2020

@Configuration
public class RewardsConfiguration {
    @Bean
    public RewardsProcessor rewardsProcessor() {
        return new RewardsProcessor();
    }
}
