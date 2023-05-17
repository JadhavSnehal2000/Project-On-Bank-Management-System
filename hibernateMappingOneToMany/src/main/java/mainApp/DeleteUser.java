//write a program to delete user
package mainApp;

import domin.Account;
import domin.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteUser {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the user id");
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
        User u1=ses.get(User.class,id);
        if(u1!=null)
        {
            tx= ses.beginTransaction();
            ses.delete(u1);
            tx.commit();
            System.out.println("User deleted along with Account Successfully");

        }
        else
        {
            System.out.println("Invalid user id");
        }
    }
}
