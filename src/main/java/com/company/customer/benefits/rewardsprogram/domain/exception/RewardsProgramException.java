package com.company.customer.benefits.rewardsprogram.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


//Created by Swaroop Tirumala on 02/05/2020

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RewardsProgramException extends Exception {

    private final String message;
    private final HttpStatus httpStatus;
}
