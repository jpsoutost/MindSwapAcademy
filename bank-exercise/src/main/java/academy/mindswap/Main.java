package academy.mindswap;

import academy.mindswap.persistence.Customer;
import academy.mindswap.services.AccountService;
import academy.mindswap.services.CustomerService;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        customerService.listAllCustomers();
        customerService.listAccountsOfCustomer(1);

        Customer customer = customerService.findCustomerById(1);
        AccountService accountService = new AccountService();
        accountService.listAllAccountsOfClient(customer);
        accountService.listBalanceOfAccount(1);
        accountService.createOrUpdateAccount(1,1200, customer);
        accountService.listBalanceOfAccount(1);
        accountService.createOrUpdateAccount(5,3000, customer);
        customerService.listAccountsOfCustomer(1);
    }
}
