/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao.impl;

import dao.inter.AbstractDao;
import com.example.dao.inter.UserSkillDaoInter;
import com.example.entity.Skill;
import com.example.entity.User;
import com.example.entity.UserSkill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userSkillId=rs.getInt("userSkillId");
        int userid = rs.getInt("id");
        int skillid = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        User user = new User();
//        return new UserSkill(userSkillId, new User(userid), new Skill(skillid, skillName), power);
   return null;
    }

    @Override
    public List<UserSkill> getAllByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("SELECT"
                    + "\tib.id as userSkillId,"
                    + "\ti.*,"
                    + "\tib.skill_id,"
                    + "\tb.name as skill_name ,"
                    + "\tib.power"
                    + "\tFROM"
                    + "\tuser_skill ib"
                    + "\tLEFT JOIN user i ON ib.user_id = i.id"
                    + "\tLEFT JOIN skill b ON ib.skill_id = b.id"
                    + "\tWHERE"
                    + "\tib.user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }
            System.out.println(c.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insertUserskill(UserSkill u) {
      try ( Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("insert into user_skill(skill_id,user_id,power) values(?,?,?)");
//            stmt.setInt(1, u.getSkill().getId());
//            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());
            
           return  stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
     try ( Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("update user_skill set skill_id=? ,user_id=?,power=? where id=?");
//            stmt.setInt(1, u.getSkill().getId());
//            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());
            stmt.setInt(4, u.getId());
           return  stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUserSkill(int id) {
        try ( Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("delete from user_skill where id=?");
            stmt.setInt(1, id);
            System.out.println("id:" + String.valueOf(id));
           return  stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
