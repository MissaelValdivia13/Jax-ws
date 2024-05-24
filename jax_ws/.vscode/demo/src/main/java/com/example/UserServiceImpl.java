package com.example;


import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.UserService")
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) throws SQLException {
        return userDao.getUserById(id);
    }

    @Override
    public void createUser(User user) throws SQLException {
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        userDao.deleteUser(id);
    }

    public static void main(String[] args) {
        UserGUI userCLI = new UserGUI();
        userCLI.start();
        javax.xml.ws.Endpoint.publish("http://localhost:8081/userService", new UserServiceImpl());
        System.out.println("Service is published at http://localhost:8081/userService");
    }
}
