package com.samples.rewards.repository;

import com.samples.rewards.model.CustomerSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSalesRepository extends JpaRepository<CustomerSales, Integer> {
}
