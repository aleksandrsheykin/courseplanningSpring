package main.services;

import main.models.dao.UserDao;
import main.models.dao.UserDaoImpl;
import main.models.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 21.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User auth(String login, String password) {
        User user = userDao.findUserByLoginAndPassword(login, password);

        if (user == null) {
            return null;
        }

        return user;
    }

    public boolean registration(String mail, String password, String firstName, String lastName, Integer limit) {
        Integer userId = userDao.insert(firstName, lastName, mail, password, limit);
        return userId>0?true:false;
    }
}
