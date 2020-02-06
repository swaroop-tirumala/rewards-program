package com.company.customer.benefits.rewardsprogram.service.implementation;

import com.company.customer.benefits.rewardsprogram.repository.RewardsProgramRepository;
import com.company.customer.benefits.rewardsprogram.domain.exception.RewardsProgramException;
import com.company.customer.benefits.rewardsprogram.domain.response.Data;
import com.company.customer.benefits.rewardsprogram.domain.rewards.MonthlyRewards;
import com.company.customer.benefits.rewardsprogram.domain.rewards.TotalRewards;
import com.company.customer.benefits.rewardsprogram.service.IrewardsProgramService;
import com.company.customer.benefits.rewardsprogram.service.processor.RewardsProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//Created by Swaroop Tirumala on 02/05/2020

@Service
@RequiredArgsConstructor
public class RewardsProgramService implements IrewardsProgramService {


    private final RewardsProgramRepository rewardsProgramRepository;


    private final RewardsProcessor rewardsProcessor;

    @Override
    public TotalRewards getTotalRewards() throws RewardsProgramException {
        try {
            TotalRewards totalRewards = new TotalRewards();
            List<Data> retVal = rewardsProgramRepository.findAll();
            totalRewards.setTotalPoints(rewardsProcessor.getTotalRewards(retVal));
            return totalRewards;
        } catch (Exception e) {
            throw new RewardsProgramException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public MonthlyRewards getMonthlyRewards() throws RewardsProgramException {
        MonthlyRewards monthlyRewards = new MonthlyRewards();
        ArrayList<Integer> rewards = new ArrayList<>();
        try {
            for (int i = 0; i < 3; i++) {
                LocalDate currentDate = LocalDate.now();
                List<Data> retVal = rewardsProgramRepository.findTransactionMonthly(currentDate.minusMonths(i), currentDate.minusMonths(i + 1));
                rewards.add(rewardsProcessor.getTotalRewards(retVal));
            }
            monthlyRewards.setMonthlyPoints(rewards);
            return monthlyRewards;
        } catch (Exception e) {
            throw new RewardsProgramException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
