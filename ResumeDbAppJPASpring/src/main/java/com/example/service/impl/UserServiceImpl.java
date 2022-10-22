package com.example.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.dao.impl.UserRepositoryCustom;
import com.example.entity.User;
import com.example.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {
@Autowired
@Qualifier("userDao1")
private UserRepositoryCustom userDao;




    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        return userDao.getAll(name,surname,nationalityId);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
return userDao.findByEmailAndPassword(email,password);

    }
    @Override
    public User findByEmail(String email) {

    return userDao.findByEmail(email);
    }


    @Override
    public User getById(int userId) {
return userDao.getById(userId);
    }

    @Override
    @Transactional
    public boolean updateUser(User u) {
   return userDao.updateUser(u);
    }
    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
 return userDao.addUser(u);
    }

    @Override
    public boolean removeUser(int id) {
return userDao.removeUser(id);
    }

}
