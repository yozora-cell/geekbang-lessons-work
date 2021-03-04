package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

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
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    private final DatabaseUserRepository databaseUserRepository;

    private final DBConnectionManager dbConnectionManager;

    public static final String DROP_USERS_TABLE_DDL_SQL = "DROP TABLE users";

    public static final String CREATE_USERS_TABLE_DDL_SQL = "CREATE TABLE users(" +
            "id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            "name VARCHAR(16) NOT NULL, " +
            "password VARCHAR(64) NOT NULL, " +
            "email VARCHAR(64) NOT NULL, " +
            "phoneNumber VARCHAR(64) NOT NULL" +
            ")";

    public UserServiceImpl() {
        dbConnectionManager = new DBConnectionManager();
        String databaseURL = "jdbc:derby:/db/user-platform;create=true";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            boolean drop = statement.execute(DROP_USERS_TABLE_DDL_SQL);
            logger.info("drop table users: " + drop);
            boolean create = statement.execute(CREATE_USERS_TABLE_DDL_SQL);
            logger.info("create table users: " + create);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbConnectionManager.setConnection(connection);
        databaseUserRepository = new DatabaseUserRepository(dbConnectionManager);
    }

    @Override
    public boolean register(User user) {
        boolean save = databaseUserRepository.save(user);
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
        return databaseUserRepository.getByNameAndPassword(name, password);
    }
}
