package com.company.customer.benefits.rewardsprogram.service;


import com.company.customer.benefits.rewardsprogram.domain.exception.RewardsProgramException;
import com.company.customer.benefits.rewardsprogram.domain.rewards.MonthlyRewards;
import com.company.customer.benefits.rewardsprogram.domain.rewards.TotalRewards;

//Created by Swaroop Tirumala on 02/05/2020

public interface IrewardsProgramService {

    TotalRewards getTotalRewards() throws RewardsProgramException;

    MonthlyRewards getMonthlyRewards() throws RewardsProgramException;
}
