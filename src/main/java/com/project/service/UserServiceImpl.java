package com.project.service;

import com.project.dao.UserDao;
import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Override
    public void saveUser(User user) {
        userDao.saveUser( user );
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser( user );
    }

    @Override
    public List<User> loadUsers(){
        return userDao.loadUsers();
    }

    @Override
    public User getUserById(int userId){
        return userDao.getUserById( userId);
    }

    @Override
    public void deleteUser(int userId){
        userDao.deleteUser( userId );
    }
}
