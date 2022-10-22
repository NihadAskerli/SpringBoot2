/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao.inter;



import com.example.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    public  List<UserSkill> getAllByUserId(int userId);
    public boolean insertUserskill(UserSkill u);
    public boolean updateUserSkill(UserSkill u);
    public boolean removeUserSkill(int id);
}

