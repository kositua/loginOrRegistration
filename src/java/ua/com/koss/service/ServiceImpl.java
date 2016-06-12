/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.service;

import ua.com.koss.dao.SessionDao;
import ua.com.koss.dao.SessionDaoImpl;
import ua.com.koss.dao.UserDao;
import ua.com.koss.dao.UserDaoImpl;
import ua.com.koss.entity.Sessions;
import ua.com.koss.entity.Users;

/**
 *
 * @author koss
 */
public class ServiceImpl implements ServiceAPI {
    
    private final UserDao userdao;
    
    {
        userdao = new UserDaoImpl();
    }
    private final SessionDao sessiondao;
    
    {
        sessiondao = new SessionDaoImpl();
    }
    
    @Override
    public Users getUser(String name) {
        return userdao.getUser(name);
    }
    
    @Override
    public void adduser(String name, String password, String email) {
        userdao.adduser(name, password, email);
    }
    
    @Override
    public Users isExist(String name, String password) {
        return userdao.isExist(name, password);
    }
    
    @Override
    public Sessions getByHashId(String hashid) {
        return sessiondao.getByHashId(hashid);
    }
    
    @Override
    public void changeSessionCount(Sessions session) {
        sessiondao.changeSessionCount(session);
    }
    
    @Override
    public void changeSessionTime(Sessions session, String timesession) {
        sessiondao.changeSessionTime(session, timesession);
    }
    
    @Override
    public void addSession(String sessionhash, String sessiontime, String sessionsCount) {
        sessiondao.addSession(sessionhash, sessiontime, sessionsCount);
    }
    
}
