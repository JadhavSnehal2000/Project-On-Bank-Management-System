//new user new Account
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddUser {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx=null;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(Account.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        //create the object user
        User u1=new User();
        u1.setUserName("AJAY");
        u1.setAge(33);
        u1.setContactNo(7247111);

        //create the object of account
        Account a1=new Account();
        a1.setAccountNo(6263222);
        a1.setAccountType("SAVING");
        a1.setUserRef(u1);

        //another object
        Account a2=new Account();
        a2.setAccountNo(162333);
        a2.setAccountType("CURRENT");
        a2.setUserRef(u1);


        u1.addAccount(a1);
        u1.addAccount(a2);

        tx=ses.beginTransaction();
        ses.save(u1);
        tx.commit();
        System.out.println("Account Created Successfully");
    }
}
