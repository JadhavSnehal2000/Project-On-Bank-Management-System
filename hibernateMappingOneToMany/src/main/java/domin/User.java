package domin;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "user")

public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private int age;

    @Column(name = "contact_no")
    private int contactNo;

    @OneToMany(mappedBy = "userRef" ,cascade = CascadeType.ALL)

    private List<Account> accountList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void addAccount(Account accRef)
    {
        if (accountList==null)
        {
            accountList =new LinkedList();
        }
        accountList.add(accRef);
        accRef.setUserRef(this);


    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
