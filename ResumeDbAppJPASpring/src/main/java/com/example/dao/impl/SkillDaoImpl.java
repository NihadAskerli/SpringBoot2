
package com.example.dao.impl;


import com.example.entity.Skill;
import dao.inter.AbstractDao;
import com.example.dao.inter.SkillDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
    
public Skill getSkill(ResultSet rs)throws Exception{
    int id=rs.getInt("id");
    String name=rs.getString("name");
   
    Skill skill=new Skill(id, name);
    System.out.println(skill);
    return skill;
}
    @Override
    public List<Skill> getAll() {
    List<Skill> list=new ArrayList<>();
    
    try(Connection conn=connect()){
        Statement stmt=conn.createStatement();
        stmt.execute("select*from skill");
        ResultSet rs=stmt.getResultSet();
        while(rs.next()){
            Skill skill=getSkill(rs);
            list.add(skill);
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return list;
    }

    @Override
    public Skill getById(int userid) {
   Skill el=null;
    try(Connection conn=connect()){
        PreparedStatement stmt=conn.prepareStatement("select *from skill where id=?");
        stmt.setInt(1, userid);
        stmt.execute();
        ResultSet rs=stmt.getResultSet();
        while(rs.next()){
           el=getSkill(rs);
            
        }
    }catch(Exception ex){
                ex.printStackTrace();
                }
    return el;
    }

    @Override
    public boolean updateSkill(Skill u) {
   try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update skill set name=? where id=?");
             stmt.setString(1, u.getName());
            stmt.setInt(2,u.getId());
           
            
            
            return stmt.execute();

        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
   
    }
    @Override
    public List<Skill> getByName(String name) {
List<Skill> list = new ArrayList<>();
try(Connection con=connect()){
    PreparedStatement stmt=con.prepareStatement("select * form skill where name like ?;");
    stmt.setString(1, name);
    stmt.execute();
}catch(Exception ex){
    ex.printStackTrace();
}
return list;
        }

    @Override
    public boolean removeSkill(int id)  {
      try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("delete from skill where id=?");
            stmt.setInt(1, id);
            return stmt.execute();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean insertSkill(Skill skl) {
        boolean b=true;
       try (Connection con=connect()){
           PreparedStatement stmt =con.prepareStatement("insert into skill(id,name) values(?,?)",Statement.RETURN_GENERATED_KEYS);
           stmt.setInt(1, skl.getId());
           stmt.setString(2, skl.getName());
           b=stmt.execute();
           ResultSet generatedKeys=stmt.getGeneratedKeys();
           if(generatedKeys.next()){
               skl.setId(generatedKeys.getInt(1));
           }
       }catch(Exception ex){
           ex.printStackTrace();
           b= false;
       }
       return b;
    }
}

