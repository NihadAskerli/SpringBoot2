 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao.impl;

import dao.inter.AbstractDao;
import com.example.dao.inter.CountryDaoInter;
import com.example.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {
public Country getCountry(ResultSet rs)throws Exception{
    int id=rs.getInt("id");
    String name=rs.getString("name");
    String nationality=rs.getString("nationality");
    Country country=new Country(id, name, nationality);
    System.out.println(country);
    return country;
}
    @Override
    public List<Country> getAll() {
    List<Country> list=new ArrayList<>();
    
    try(Connection conn=connect()){
        Statement stmt=conn.createStatement();
        stmt.execute("select*from country");
        ResultSet rs=stmt.getResultSet();
        while(rs.next()){
            Country contry=getCountry(rs);
            list.add(contry);
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return list;
    }
    @Override
    public Country getById(int userid) {
   Country el=null;
    try(Connection conn=connect()){
        PreparedStatement stmt=conn.prepareStatement("select *from country where id=?");
        stmt.setInt(1, userid);
        stmt.execute();
        ResultSet rs=stmt.getResultSet();
        while(rs.next()){
           el=getCountry(rs);
            
        }
    }catch(Exception ex){
                ex.printStackTrace();
                }
    return el;
    }

    @Override
    public boolean updateCountry(Country u) {
   try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update country set name=?,nationality=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getNationality());
            stmt.setInt(3,u.getId());
            
            return stmt.execute();

        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
   
    }

    @Override
    public boolean removeCountry(int id) {
      try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("delete from country where id=1");
            stmt.setInt(1, id);
            return stmt.execute();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    

}
