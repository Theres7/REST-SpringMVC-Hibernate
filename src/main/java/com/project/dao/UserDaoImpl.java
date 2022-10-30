package com.project.dao;

import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public void saveUser(User user) {
        hibernateTemplate.save( user );
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        hibernateTemplate.update( user );
    }

    // Get All Users
    @Override
    public List<User> loadUsers() {
        return hibernateTemplate.loadAll( User.class );
    }

    // Get User by Id
    @Override
    public User getUserById(int userId) {
        return hibernateTemplate.get( User.class, userId );
    }

    // Delete User
    @Override
    @Transactional
    public void deleteUser(int userId) {
        hibernateTemplate.delete( hibernateTemplate.load( User.class, userId ) );
    }
}
