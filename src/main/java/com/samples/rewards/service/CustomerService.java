package com.samples.rewards.service;

import com.samples.rewards.model.Customer;
import com.samples.rewards.model.CustomerSales;
import com.samples.rewards.model.MonthlySales;
import com.samples.rewards.model.Rewards;
import com.samples.rewards.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Rewards> getAllCustomerRewards() {
        List<Rewards> rewards = new ArrayList<>();
        try{
            List<Customer> customers = customerRepository.findAll();
            for(Customer customer: customers){
                List<CustomerSales> last3MonthSales =  customer.getCustomerSales().parallelStream().filter(customerSales -> customerSales.getSalesDate().after(Date.from(ZonedDateTime.now().minusMonths(3).toInstant()))).collect(Collectors.toList());
                Map<Integer, List<Integer>> groupedSalesByMonth = last3MonthSales.stream().collect(Collectors.groupingBy(CustomerSales::getSalesMonth, Collectors.mapping(CustomerSales::getSalesAmount, Collectors.toList())));
                System.out.println("Collected for Customer " + customer.getFirstName() + " is " + groupedSalesByMonth);
                List<MonthlySales> monthlySalesList = new ArrayList<>();
                for(Map.Entry<Integer, List<Integer>> eachMonth : groupedSalesByMonth.entrySet()) {
                    Integer totalSalesPerMonth = 0;
                    Integer totalRewardsPerMonth = 0;
                    for(Integer eachSales : eachMonth.getValue()){
                        totalSalesPerMonth += eachSales;
                        totalRewardsPerMonth += calculateRewardPoints(eachSales);
                    }
                    MonthlySales monthlySales = new MonthlySales();
                    monthlySales.setMonth(eachMonth.getKey());
                    monthlySales.setSales(totalSalesPerMonth);
                    monthlySales.setRewardPoints(totalRewardsPerMonth);
                    monthlySalesList.add(monthlySales);
                }
                Long totalSales = monthlySalesList.stream().collect(Collectors.summarizingInt(MonthlySales::getSales)).getSum();
                Long totalRewardPoints = monthlySalesList.stream().collect(Collectors.summarizingInt(MonthlySales::getRewardPoints)).getSum();
                rewards.add(new Rewards(customer.getFirstName(), customer.getLastName(), monthlySalesList,  totalSales.intValue() , totalRewardPoints.intValue()));
            }

        } catch (Exception e) {
            System.out.println("Error while retrieving customer details with Sales.");
        }
        return rewards;
    }

    private Integer calculateRewardPoints(Integer salesAmount) {
        Integer totalRewards = 0;
        if (salesAmount > 100) {
            totalRewards += (2* (salesAmount-100)) + 50;
        } else if (salesAmount > 50) {
            totalRewards += (salesAmount-50);
        }
        return totalRewards;
    }
}
