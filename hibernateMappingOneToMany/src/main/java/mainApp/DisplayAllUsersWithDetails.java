//To display All the details of specific user
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllUsersWithDetails {
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

        Criteria crt= ses.createCriteria(User.class);
        List<User>data=crt.list();
        //first user will be Find
        for(User u1:data)
        {
            System.out.println("User Name:"+u1.getUserName());
            List<Account>data2=u1.getAccountList();
          //Data of this User
            for (Account a:data2)
            {
                System.out.println("Account Number:"+a.getAccountNo());
                System.out.println("Account Type:"+a.getAccountType());

            }
            System.out.println("==============");
        }

    }
}
