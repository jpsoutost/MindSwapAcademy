package academy.mindswap.persistence;

import javax.persistence.*;


@Entity
    @Table(name = "accounts")
    public class Account {

    @Id
    @Column(name = "accountID")
    private Integer accountID;

    @Column
    private Integer balance;

    @ManyToOne
    private Customer customer;

    public Account() {
    }

    public Account(Integer accountID, Integer balance, Customer customer) {
        this.accountID = accountID;
        this.balance = balance;
        this.customer = customer;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", balance=" + balance +
                ", customer=" + customer.getName() +
                '}';
    }
}
