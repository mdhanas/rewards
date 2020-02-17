package com.samples.rewards.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CustomerSales> customerSales = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, List<CustomerSales> customerSales) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerSales = customerSales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<CustomerSales> getCustomerSales() {
        return customerSales;
    }

    public void setCustomerSales(List<CustomerSales> customerSales) {
        this.customerSales = customerSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getCustomerSales(), customer.getCustomerSales());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getCustomerSales());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerSales=" + customerSales +
                '}';
    }
}
