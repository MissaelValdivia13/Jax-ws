package com.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface UserService {

    @WebMethod
    List<User> getAllUsers() throws SQLException;

    @WebMethod
    User getUserById(int id) throws SQLException;

    @WebMethod
    void createUser(User user) throws SQLException;

    @WebMethod
    void updateUser(User user) throws SQLException;

    @WebMethod
    void deleteUser(int id) throws SQLException;
}

