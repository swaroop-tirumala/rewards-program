package com.company.customer.benefits.rewardsprogram.repository;

import com.company.customer.benefits.rewardsprogram.domain.response.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//Created by Swaroop Tirumala on 02/05/2020

@Repository
public interface RewardsProgramRepository extends JpaRepository<Data, Long> {

    List<Data> findAll();

    @Query(value = "SELECT * FROM TRANSACTION t WHERE t.TRANSACTION_DATE <= TO_DATE(?1, 'YYYY/MM/DD') AND t.TRANSACTION_DATE >= TO_DATE(?2, 'YYYY/MM/DD')",
            nativeQuery = true)
    List<Data> findTransactionMonthly(LocalDate startDate, LocalDate endDate);

}
