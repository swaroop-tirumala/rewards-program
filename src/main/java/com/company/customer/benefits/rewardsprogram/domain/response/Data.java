package com.company.customer.benefits.rewardsprogram.domain.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

//Created by Swaroop Tirumala on 02/05/2020

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION")
@JsonIgnoreProperties(value = {"id"})
public class Data {
    @Id
    private String id;
    private int amount;
    private LocalDate transactionDate;
}
