package com.company.customer.benefits.rewardsprogram.service.processor;

import com.company.customer.benefits.rewardsprogram.domain.response.Data;

import java.util.ArrayList;
import java.util.List;

//Created by Swaroop Tirumala on 02/05/2020

public class RewardsProcessor {

    //Logic to calculate rewards points based on logic
    private int calculateRewards(int amount) {

        if (amount >= 50 && amount <= 100) {
            return amount - 50;
        } else if (amount > 100) {
            return (2 * (amount - 100) + 50);
        }
        return 0;
    }

    //Returns total rewards for an individual
    public int getTotalRewards(List<Data> dataList) {
        final ArrayList<Integer> Rewards = new ArrayList();
        dataList.stream().forEach(data ->
                {
                    Rewards.add(calculateRewards(data.getAmount()));

                }
        );
        return Rewards.stream().reduce(0, (a, b) -> a + b);
    }


}
