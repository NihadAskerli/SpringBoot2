/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao.impl;


import dao.inter.AbstractDao;
import dao.inter.EmploymentHistoryDaoInter;
import com.example.dao.inter.UserSkillDaoInter;
import com.example.entity.EmploymentHistory;
import com.example.entity.Skill;
import com.example.entity.User;
import com.example.entity.UserSkill;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    private EmploymentHistory getEmployementHistory(ResultSet rs)throws  Exception{
        String header= rs.getString("header");
        String jobDescription=rs.getString("jobDescription");
        Date begindate=rs.getDate("begin_date");
        Date enddate=rs.getDate("end_date");
        int userid=rs.getInt("user_id");
//     EmploymentHistory emp=new EmploymentHistory(null,header,begindate,enddate,jobDescription,new User(userid));
     return null;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result=new ArrayList<>();
        try(Connection c=connect()) {

            PreparedStatement stmt =c.prepareStatement("select * from employment_history where user_id=?");
            stmt.setInt(1,userId);
            stmt.execute();
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                EmploymentHistory emp=getEmployementHistory(rs);
                result.add(emp);
            }
            System.out.println(c.getClass().getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}

