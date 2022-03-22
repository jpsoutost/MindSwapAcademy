package academy.mindswap.services;

import academy.mindswap.persistence.Account;
import academy.mindswap.persistence.Customer;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountService {

    private EntityManagerFactory emf;

    public AccountService() {
        emf = Persistence.createEntityManagerFactory("mindswap");
    }

    public void listAllAccountsOfClient(Customer customer){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            CriteriaQuery<Account> query = em.getCriteriaBuilder().createQuery(Account.class);
            Root <Account> aux =  query.from(Account.class);
            query.select(aux);
            ParameterExpression<Customer> p = em.getCriteriaBuilder().parameter(Customer.class);
            query.where(em.getCriteriaBuilder().equal(aux.get("customer"), customer));
            List<Account> accounts = em.createQuery(query).getResultList();
            System.out.println(accounts);
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void listBalanceOfAccount(Integer accountID){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
          /*  CriteriaQuery<Account> query = em.getCriteriaBuilder().createQuery(Account.class);
            Root <Account> aux =  query.from(Account.class);
            query.select(aux);
            ParameterExpression<Integer> p = em.getCriteriaBuilder().parameter(Integer.class);
            query.where(em.getCriteriaBuilder().equal(aux.get("accountID"), accountID));
            Account account = em.createQuery(query).getSingleResult();
            System.out.println(account.getBalance());*/

            TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.accountID = :id"  , Account.class);
            query.setParameter("id", accountID);
            Account account = query.getSingleResult();
            System.out.println(account.getBalance());
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void createOrUpdateAccount(Integer accountID, Integer balance, Customer customer){

        Account account = new Account(accountID, balance, customer);
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(account);
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
