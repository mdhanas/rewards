package com.samples.rewards.model;

import java.util.List;

public class Rewards {
    private String firstName;
    private String lastName;
    private List<MonthlySales> monthlySales;
    private Integer totalSales;
    private Integer totalRewardPoints;

    public Rewards() {
    }

    public Rewards(String firstName, String lastName, List<MonthlySales> monthlySales, Integer totalSales, Integer totalRewardPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySales = monthlySales;
        this.totalSales = totalSales;
        this.totalRewardPoints = totalRewardPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<MonthlySales> getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(List<MonthlySales> monthlySales) {
        this.monthlySales = monthlySales;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public void setTotalRewardPoints(Integer totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }
}
