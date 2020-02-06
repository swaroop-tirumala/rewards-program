package com.company.customer.benefits.rewardsprogram.controller;


import com.company.customer.benefits.rewardsprogram.domain.exception.RewardsProgramException;
import com.company.customer.benefits.rewardsprogram.domain.rewards.MonthlyRewards;
import com.company.customer.benefits.rewardsprogram.domain.rewards.TotalRewards;
import com.company.customer.benefits.rewardsprogram.service.IrewardsProgramService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Created by Swaroop Tirumala on 02/05/2020

@RestController
@RequestMapping("/rewards")
@RequiredArgsConstructor
public class CustomerRewardsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final IrewardsProgramService irewardsProgramService;


    @GetMapping(path = "/total")
    public ResponseEntity<TotalRewards> getTotalRewards() throws RewardsProgramException {
        logger.info("Retrieving total rewards: ");
        return new ResponseEntity<>(irewardsProgramService.getTotalRewards(), HttpStatus.OK);
    }

    @GetMapping(path = "/monthly")
    public ResponseEntity<MonthlyRewards> getRewardsForEachMonth() throws RewardsProgramException {
        logger.info("Retrieving monthly rewards : ");
        return new ResponseEntity<>(irewardsProgramService.getMonthlyRewards(), HttpStatus.OK);
    }
}
