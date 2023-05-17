//write a program to delete the Account
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteAccount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter  the id");
        int id=sc.nextInt();
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx = null;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(User.class);
        cfg = cfg.addAnnotatedClass(Account.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //create a object
        Account a1=ses.get(Account.class,id);
        if(a1!=null)
        {
            tx= ses.beginTransaction();
            ses.delete(a1);
            tx.commit();;
            System.out.println("Record deleted Successfully");
        }
        else
        {
            System.out.println("Invalid Account id");
        }
    }
}
