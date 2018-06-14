package jos.learning.cloud.domain.user.service;

import jos.learning.cloud.domain.user.dto.User;
import jos.learning.cloud.domain.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jos on 2018/6/14.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void addUser(String name,String role) {
        userDao.save(User.builder().name(name).role(role).build());
    }

    public void delUser(Long userId) {
        userDao.deleteById(userId);
    }

    public User getUser(Long userId) {
        return userDao.findById(userId).orElse(null);
    }


    public void updateUser(User user){
        userDao.save(user);
    }

    public List<User> listUser() {
        List<User> result = new ArrayList<User>();
        userDao.findAll().forEach(user -> {
            result.add(user);
        });
        return result;
    }
}
