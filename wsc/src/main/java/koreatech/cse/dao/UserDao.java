package koreatech.cse.dao;

import koreatech.cse.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by kth on 2015. 10. 6..
 */
@Repository
public class UserDao {
    public void add(User user){
        System.out.println("user add = " + user);
    }

    public User get() {
        System.out.println("user get = " + true);
        return new User();
    }
}
