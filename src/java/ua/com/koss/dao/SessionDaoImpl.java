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
import ua.com.koss.entity.Sessions;

/**
 *
 * @author koss
 */
public class SessionDaoImpl implements SessionDao {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("GetInfoSessionsPU");

    private EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public Sessions getByHashId(String hashid) {
        List<Sessions> list = getEntityManager()
                .createNamedQuery("Sessions.findBySessionhash", Sessions.class)
                .setParameter("sessionhash", hashid)
                .getResultList();
        Sessions session = null;
        for (Sessions sessions : list) {
            session = sessions;
        }
        return session;
    }

    @Override
    public void changeSessionCount(Sessions session) {
        Integer count = Integer.valueOf(session.getSessionsCount());
        count++;
        session.setSessionsCount(String.valueOf(count));
        extactChangesToDB(session);
    }

    @Override
    public void changeSessionTime(Sessions session, String timesession) {
        session.setSessiontime(timesession);
        extactChangesToDB(session);
    }

    private void extactChangesToDB(Sessions session) {
        EntityManager em = getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.merge(session);
        etx.commit();
    }

    @Override
    public void addSession(String sessionhash, String sessiontime, String sessionsCount) {
        Sessions session = new Sessions(sessionhash, sessiontime, sessionsCount);
        EntityManager em = getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(session);
        etx.commit();
    }

    
}
