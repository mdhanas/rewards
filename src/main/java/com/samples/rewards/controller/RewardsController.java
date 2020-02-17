package com.samples.rewards.controller;

import com.samples.rewards.model.Rewards;
import com.samples.rewards.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RewardsController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Rewards> customers() {
        return customerService.getAllCustomerRewards();
    }
}