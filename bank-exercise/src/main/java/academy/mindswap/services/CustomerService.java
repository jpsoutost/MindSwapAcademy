package academy.mindswap.services;

import academy.mindswap.persistence.Account;
import academy.mindswap.persistence.Customer;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Set;

public class CustomerService {

    private EntityManagerFactory emf;

    public CustomerService() {
        emf = Persistence.createEntityManagerFactory("mindswap");
    }

    public Customer findCustomerById(Integer customerID){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            Customer customer = em.find(Customer.class, customerID);
            return customer;

        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void listAccountsOfCustomer(Integer customerID){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            Customer customer = em.find(Customer.class, customerID);
            System.out.println(customer.getAccounts());

        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void listAllCustomers(){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            CriteriaQuery<Customer> query = em.getCriteriaBuilder().createQuery(Customer.class);
            query.select(query.from(Customer.class));
            List<Customer> customers = em.createQuery(query).getResultList();
            System.out.println(customers);
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void createOrUpdateCustomer(Integer customerID, String name){
        Customer customer = new Customer(customerID, name);
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        }catch (RollbackException e){
            if(em!=null) {
                em.getTransaction().rollback();
            }
        }finally{
            if(em!=null){
                em.close();
            }
        }
    }
}
