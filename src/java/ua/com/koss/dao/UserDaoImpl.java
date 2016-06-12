/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ua.com.koss.entity.Users;

/**
 *
 * @author koss
 */
public class UserDaoImpl implements UserDao {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("GetInfoSessionsPU");

    private EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public Users getUser(String name) {
        List<Users> list = getEntityManager()
                .createNamedQuery("Users.findByUsername", Users.class)
                .setParameter("username", name)
                .getResultList();
        Users user = null;
        for (Users users : list) {
            user = users;
        }
        return user;
    }

    @Override
    public void adduser(String name, String password, String email) {
        Users user = new Users(name, password, email);
        EntityManager em = getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(user);
        etx.commit();
    }

    @Override
    public Users isExist(String name, String password) {
        List<Users> list = getEntityManager()
                .createNamedQuery("Users.findByUsernamePassword", Users.class)
                .setParameter("username", name)
                .setParameter("password", password)
                .getResultList();
        Users user = null;
        for (Users users : list) {
            user = users;
        }
        return user;
    }

}
