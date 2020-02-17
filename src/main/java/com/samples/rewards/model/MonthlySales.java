package com.samples.rewards.model;

public class MonthlySales {
    private Integer month;
    private Integer sales;
    private Integer rewardPoints;

    public MonthlySales() {
    }

    public MonthlySales(Integer month, Integer sales, Integer rewardPoints) {
        this.month = month;
        this.sales = sales;
        this.rewardPoints = rewardPoints;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}
