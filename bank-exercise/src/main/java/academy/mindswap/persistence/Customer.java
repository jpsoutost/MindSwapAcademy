package academy.mindswap.persistence;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
    @Table(name = "customers")
    public class Customer {

        @Id
        @Column(name = "customerID")
        private Integer customerID;

        @Column(length = 50)
        private String name;

        @OneToMany(
                cascade = {CascadeType.ALL},
                orphanRemoval = true,
                mappedBy = "customer"
        )
        private Set<Account> accounts;

    public Customer() {
    }

    public Customer(Integer customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                '}';
    }
}
