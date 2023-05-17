//display user account
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAccountDetails {

    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx=null;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(User.class);
        cfg=cfg.addAnnotatedClass(Account.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        User obj=ses.get(User.class,10);
        System.out.println("User name:"+obj.getUserName());
        List<Account>data=obj.getAccountList();
        for(Account a:data)
        {
            System.out.println("ACCOUNT NO:"+a.getAccountNo());
            System.out.println("ACCOUNT TYPE:"+a.getAccountType());
            System.out.println("================================");
        }
    }
}
