/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao.impl;

import com.example.entity.User;


import java.util.List;

public interface UserRepositoryCustom {
    public User findByEmailAndPassword(String email,String password);
    public List<User> getAll(String name, String surname, Integer nationalityId);
    public User getById(int id);
    public boolean updateUser(User u);
    public boolean addUser(User u);
    public  boolean removeUser(int id);
    public User findByEmail(String email);
}

