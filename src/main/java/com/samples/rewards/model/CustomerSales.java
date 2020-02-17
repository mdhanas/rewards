package com.samples.rewards.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER_SALES")
public class CustomerSales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sales_id")
    public Integer salesId;

    @ManyToOne(cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonManagedReference
    private Customer customer;

    @Column(name= "sales_amount")
    private Integer salesAmount;

    @Column(name= "sales_date")
    private Date salesDate;

    @Column(name = "sales_month")
    private Integer salesMonth;


    public CustomerSales() {
    }

    public CustomerSales(Customer customer, Integer salesAmount, Date salesDate, Integer salesMonth) {
        this.customer = customer;
        this.salesAmount = salesAmount;
        this.salesDate = salesDate;
        this.salesMonth = salesMonth;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }


    public Integer getSalesMonth() {
        return salesMonth;
    }

    public void setSalesMonth(Integer salesMonth) {
        this.salesMonth = salesMonth;
    }


}
