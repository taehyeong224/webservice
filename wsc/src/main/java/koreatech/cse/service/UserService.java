package koreatech.cse.service;

import koreatech.cse.domain.User;
import koreatech.cse.repository.UserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;

@Service
public class UserService {  //타겟
    @Inject
    private UserMapper userMapper;

    public Boolean signup(User user) {
        if(user.getEmail() == null || user.getPassword() ==  null)
            return false;

        userMapper.insert(user);

        System.out.println("User reated: " + new Date());
        return true;
    }

    public Boolean delete(int id){
        if(id == 0)
            return false;
        else
            userMapper.delete(id);
            return true;
    }
}