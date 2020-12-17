package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl DAO;

    public UserServiceImpl() {
        DAO = new UserDaoJDBCImpl();
    }

    public void createUsersTable() {
        DAO.createUsersTable();
    }

    public void dropUsersTable() {
        DAO.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        DAO.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        DAO.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return DAO.getAllUsers();
    }

    public void cleanUsersTable() {
        DAO.cleanUsersTable();
    }

}
