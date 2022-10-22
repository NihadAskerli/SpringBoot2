package com.example.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository ("userDao2")
public class UserDaoImpl2 implements UserRepositoryCustom {
@PersistenceContext
EntityManager em;
public UserDaoImpl2(){

    System.out.println("userdaoimple2");
}




    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {

        String jpql = "select u from User u where 1=1 ";
        Query q = em.createQuery(jpql, User.class);


        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality.id=:nid";
        }

        Query query = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);

        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }

        return query.getResultList();
    }
//JPQl
    @Override
    public User findByEmailAndPassword(String email, String password) {


        Query q = em.createQuery("select u from User u where u.email=:e and u.password=:p",
                User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        List<User> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;

    }
//    Criterial Builder
//    @Override
//    public User findByEmail(String email){
//
//
//        CriteriaBuilder cb=em.getCriteriaBuilder();
//        CriteriaQuery<User> q1=cb.createQuery(User.class);
//        Root<User> postRoot=q1.from(User.class);
//        CriteriaQuery<User>q2=q1
//        .where(cb.equal( postRoot.get("email"),email));
//        Query query = em.createQuery(q2);
////        q.setParameter("e", email);
////        q.setParameter("p", password);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
// jpql
    @Override
    public User findByEmail(String email) {

        Query q = em.createQuery("select u from User u where u.email=:e",
                User.class);
        q.setParameter("e", email);

        List<User> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
//    Named Query
//        @Override
//    public User findByEmail(String email){
//
//             Query query = em.createNamedQuery("User.findByEmail",User.class);
//
//        query.setParameter("email", email);
//
//        List<User> list = query.getResultList();
//        if (list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//
//    }
//            @Override
//    public User findByEmail(String email){
//
//             Query query = em.createNativeQuery("select * from user where email=?",User.class);
//
//        query.setParameter(1, email);
//
//        List<User> list = query.getResultList();
//        if (list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//
//    }

    @Override
    public User getById(int userId) {

        User u = em.find(User.class, userId);

        return u;
    }

    @Override
    public boolean updateUser(User u) {


        em.merge(u);

        return true;
    }
    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));

        em.persist(u);

        return true;
    }

    @Override
    public boolean removeUser(int id) {


        User u = em.find(User.class, id);

        em.remove(u);

        return true;
    }

}
