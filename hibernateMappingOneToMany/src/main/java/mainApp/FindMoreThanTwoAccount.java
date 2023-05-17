//To Find the which user having more than Two Accounts
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FindMoreThanTwoAccount {
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
        List<User> data = crt.list();
        for (User u1 : data) {
            List<Account> data2 = u1.getAccountList();
            if (data2.size() > 2) {
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
}
