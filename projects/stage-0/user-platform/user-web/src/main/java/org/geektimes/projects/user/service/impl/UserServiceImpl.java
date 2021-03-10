package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * description
 * program geekbang-lessons-mercyblitz
 *
 * @author yangxiao-lhq
 * @date 2021/3/3 15:21
 **/
@Deprecated
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Resource(name = "bean/UserRepository")
    private UserRepository UserRepository;

    @Override
    public boolean register(User user) {
        boolean save = UserRepository.save(user);
        logger.info("save user: " + save);
        return save;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return UserRepository.getByNameAndPassword(name, password);
    }
}
