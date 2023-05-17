//old Uers new Account
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddNewAccountType {
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
        //old user with new account
        User s1=ses.get(User.class,9);
        Account a1=new Account();
        a1.setAccountNo(9448875);
        a1.setAccountType("LOAN");

        s1.addAccount(a1);
        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();;
        System.out.println("record Inserted");
    }
}
