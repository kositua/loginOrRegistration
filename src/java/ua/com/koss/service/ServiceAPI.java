/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.service;

import ua.com.koss.entity.Sessions;
import ua.com.koss.entity.Users;

/**
 *
 * @author koss
 */
public interface ServiceAPI {

    Users getUser(String name);

    void adduser(String name, String password, String email);

    Users isExist(String name, String password);

    Sessions getByHashId(String hashid);

    void changeSessionCount(Sessions session);

    void changeSessionTime(Sessions session, String timesession);

    void addSession(String sessionhash, String sessiontime, String sessionsCount);
}
