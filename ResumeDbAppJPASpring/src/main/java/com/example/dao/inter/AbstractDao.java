/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao {
    public Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/resume";
        String username="root";
        String pasword="Esger123#N";
        Connection c= DriverManager.getConnection(url,username,pasword);
        return c;
    
    }
    private static EntityManagerFactory emf =null;
    public EntityManager em(){
        if(emf==null){
            emf=Persistence.createEntityManagerFactory("resumeappPU");
        }
        EntityManager entityManager=emf.createEntityManager();
        return entityManager;
    }
        public void emfclose(){
            emf.close();
        }
    } 



