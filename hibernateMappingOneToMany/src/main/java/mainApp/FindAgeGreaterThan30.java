//Write a Program to find the Age greater than 30
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class FindAgeGreaterThan30 {
    public static void main(String[] args) {
        Configuration  cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx = null;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(User.class);
        cfg = cfg.addAnnotatedClass(Account.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt = ses.createCriteria(User.class);
        //To Add the Restriction On Criteria
        crt.add(Restrictions.gt("age",30));
        List<User> data = crt.list();
        for (User u1 : data) {
            List<Account> data2 = u1.getAccountList();

                System.out.println("User name:"+u1.getUserName());
                //Data of this User
                for (Account a : data2) {
                    System.out.println("Account Number:" + a.getAccountNo());
                    System.out.println("Account Type:" + a.getAccountType());

                }
                System.out.println("==============");

        }
    }
    }
