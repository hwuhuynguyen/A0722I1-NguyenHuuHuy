package practice.dao;

import practice.model.Login;
import practice.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList;
    static {
        userList = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        userList.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Bill");
        u2.setAccount("bill");
        u2.setEmail("bill@codegym.vn");
        u2.setPassword("123456");
        userList.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("mike");
        u2.setEmail("mike@codegym.vn");
        u3.setPassword("123456");
        userList.add(u3);
    }

    public static User checkLogin(Login login){
        for (User user: userList) {
            if(user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }

}
